package leetcode.AlgorithmBasis;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class array01 {
    public static void main(String[] args){

        int[][] mat = {{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1},{0,0,0}};
        for(int i =0 ;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
        array01_Solution solution = new array01_Solution();
        int[][] new_mat = solution.updateMatrix(mat);
    }

}

class array01_Solution {
    public int[][] updateMatrix(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        Queue<int []> queue = new LinkedList<int[]>();
        int[][] dist = new int[height][width];
        Boolean[][] searched = new Boolean[height][width];
        for(int i =0 ;i<height;i++){
            for(int j=0;j<width;j++){
                if(mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    searched[i][j] = true;
                }else{
                    searched[i][j] = false;
                }
            }
        }
        int[] x_ = {0,1,0,-1};
        int[] y_ = {1,0,-1,0};
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int Q = 0; Q < 4; Q++) {
                int ni = p[0]+y_[Q];
                int nj = p[1]+x_[Q];
                if(ni>=0 && ni<height && nj>=0 && nj<width){
                    if(!searched[ni][nj]){
                        dist[ni][nj] = dist[p[0]][p[1]]+1;
                        searched[ni][nj] = true;
                        queue.add(new int[]{ni,nj});
                    }

                }
            }
        }

        return dist;

    }

}