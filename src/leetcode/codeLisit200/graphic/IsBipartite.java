package leetcode.codeLisit200.graphic;

public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        if(n==1){
            return false;
        }
        // 状态
        int [] state = new int[n];
        // 是否检查该节点
        boolean[] isac = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            state[i] = -1;
            isac[i] = false;
        }
        state[0] = 0;
        while (count<n) {
            int lastCount = count;
            for (int i = 0; i < n; i++) {
                if (state[i] == -1 || isac[i]) {continue; }
                count += 1;
                isac[i] = true;
                for (int j = 0; j < graph[i].length; j++) {
                    if (state[graph[i][j]] == -1) {
                        state[graph[i][j]] = state[i] == 1 ? 0 : 1;
                    } else if (state[graph[i][j]] == state[i] && state[i] != -1) { return false; }
                }
            }
            if(lastCount==count){
                for (int i = 0; i < n; i++) {
                    if(!isac[i] && state[i]==-1){ state[i]=0;break; }
                } }
        }
        return true;
    }

//     for (int i = 0; i < n; i++) {
//        System.out.printf("%d ",state[i]);
//    }
//        System.out.println();
    public static void main(String[] args) {
//        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
//        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        IsBipartite isBipartite = new IsBipartite();
        System.out.println(isBipartite.isBipartite(graph));
    }
}
