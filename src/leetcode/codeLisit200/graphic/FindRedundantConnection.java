package leetcode.codeLisit200.graphic;

import java.util.ArrayList;

public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> set = new ArrayList<>(edges.length);
        int[] ans = new int[0];
        ArrayList<Integer> temp;

        for (int i = 0; i < edges.length; i++) {
            // 状态
            int l = -1;
            int r = -1;
            for (int j = 0; j < set.size(); j++) {
                if(set.get(j).contains(edges[i][0]) && set.get(j).contains(edges[i][1])){
                    ans = edges[i];
                    return ans;
                }else if(set.get(j).contains(edges[i][0]) && !set.get(j).contains(edges[i][1])){
                    l = j;
                }else if(set.get(j).contains(edges[i][1]) && !set.get(j).contains(edges[i][0])){
                    r = j;
                }
            }
            if(l==-1 && r==-1){
                temp = new ArrayList<>();
                temp.add(edges[i][0]);
                temp.add(edges[i][1]);
                set.add(temp);
            }else {
                if(l!=-1 && r==-1){
                    set.get(l).add(edges[i][1]);
                } else if(r!=-1 && l==-1){
                    set.get(r).add(edges[i][0]);
                }else {
                    set.get(l).addAll(set.get(r));
                    set.remove(set.get(r));
                }
            }
//            System.out.println(exist.toString());
        }
        return ans;
    }


    public int[] findRedundantConnection1(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }


    public int[] findRedundantConnection2(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        // 初始化集合，及每个集合由自己的点组合，未曾合并
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 遍历边，合并集合
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = find(parent, edge[0]), node2 = find(parent, edge[1]);
            if ( node1==node2) {
                return edge;
            } else {
                parent[node1] = node2;
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
//        int[][] edges = {{1,2}, {2,3}, {3,4}, {4,5}, {1,5}};
        int[][] edges = {{3,4},{1,2},{2,4},{3,5},{2,5}};
//        int[][] edges = {{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}};
        FindRedundantConnection findRedundantConnection = new FindRedundantConnection();
        int[] ans = findRedundantConnection.findRedundantConnection2(edges);
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ",ans[i]);
        }

    }
}
