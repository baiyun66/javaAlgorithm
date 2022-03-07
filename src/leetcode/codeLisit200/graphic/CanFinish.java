package leetcode.codeLisit200.graphic;

import java.util.Arrays;

public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] isac = new int[numCourses];
        for (int i = 0; i <numCourses; i++) {
            if(isac[i]==0){
                if(!deepSearch(i,isac,prerequisites)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean deepSearch(int numIndex, int[] isac,int[][] prerequisites) {
        //回到原点，有环
        if(isac[numIndex] == 1){return false;}

        // 验证无误的节点，跳过重复的验证
        if(isac[numIndex]==-1){return true;}


        isac[numIndex] = 1;
        for (int i = 0; i < prerequisites.length; i++) {
            if(prerequisites[i][1] == numIndex){
                if (!deepSearch(prerequisites[i][0],isac,prerequisites)) { return false; }
            }
        }
        // 验证无误的节点
        isac[numIndex] = -1;
        return true;
    }


    public static void main(String[] args) {
        int numCourses = 8;
//        int numCourses = 1;
        int[][] prerequisites ={{0,1},{0,3},{2,1},{2,4},{3,1},{4,3},{5,3},{5,4},{7,6}};//{1,0}
//        int[][]  prerequisites= {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
//        int[][]  prerequisites= {{0,0}};
        CanFinish canFinish = new CanFinish();
        System.out.println(canFinish.canFinish(numCourses,prerequisites));
//        System.out.println(canFinish.ans);
    }
}
