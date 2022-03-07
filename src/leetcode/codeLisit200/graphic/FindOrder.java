package leetcode.codeLisit200.graphic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> preClass = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
           preClass.add(new ArrayList<Integer>(5));
        }
        int [] ans = new int[numCourses];
        boolean [] down = new boolean[numCourses];

        // 前导课程
        for (int i = 0; i < prerequisites.length; i++) {
            preClass.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < preClass.size(); i++) {
            System.out.println(preClass.get(i).toString());
        }

        int count = 0;
        for (int i = 0; i < preClass.size(); i++) {
            if(preClass.get(i).size()==0){
                down[i] = true;
                ans[count] = i;
                count++;
            }
        }
        while (count<numCourses){
            boolean flagNo = true;
            for (int i = 0; i < preClass.size(); i++) {
                if(!down[i]){
                    boolean flag = true;
                    for (int j = 0; j < preClass.get(i).size(); j++) {
                        if(!down[preClass.get(i).get(j)]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        down[i] = true;
                        ans[count] = i;
                        count++;
                        flagNo = false;
                    }
                }
            }
            if(flagNo){
                return new int[]{};
            }
        }

        return ans;

    }


    public int[] findOrder1(int numCourses, int[][] prerequisites) {
//        ArrayList<ArrayList<Integer>> preClass = new ArrayList<>(numCourses);
        Map<Integer,ArrayList<Integer>> preClass = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            preClass.put(i,new ArrayList<Integer>(5));
        }
        int [] ans = new int[numCourses];
        boolean [] down = new boolean[numCourses];

        // 前导课程
        for (int i = 0; i < prerequisites.length; i++) {
            preClass.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < preClass.size(); i++) {
            System.out.println(preClass.get(i).toString());
        }

        int count = 0;
        for (int i = 0; i < preClass.size(); i++) {
            if(preClass.get(i).size()==0){
                down[i] = true;
                ans[count] = i;
                count++;
            }
        }
        while (count<numCourses){
            boolean flagNo = true;
            for (int i = 0; i < preClass.size(); i++) {
                if(!down[i]){
                    boolean flag = true;
                    ArrayList<Integer> temp = preClass.get(i);
                    for (int j = 0; j < temp.size(); j++) {
                        if(!down[temp.get(j)]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        down[i] = true;
                        ans[count] = i;
                        count++;
                        flagNo = false;
                    }
                }
            }
            if(flagNo){
                return new int[]{};
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        int numCourses = 4;
//        int[][] prerequisites ={{1,0},{0,3},{2,1},{2,4},{3,1},{4,3},{5,3},{5,4},{7,6}};//{1,0}
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        FindOrder findOrder = new FindOrder();
        int[] ans = findOrder.findOrder1(numCourses,prerequisites);
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ",ans[i]);
        }
//        System.out.println(canFinish.ans);
    }
}
