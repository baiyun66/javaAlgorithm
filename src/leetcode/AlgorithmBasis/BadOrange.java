package leetcode.AlgorithmBasis;

import java.util.LinkedList;
import java.util.Queue;

public class BadOrange {
    public static void main(String[] args){
        int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        SolutionBadOrange solutionBadOrange = new SolutionBadOrange();
        int a = solutionBadOrange.orangesRotting(grid);
        System.out.println(a);
    }
}


class SolutionBadOrange{
        public int orangesRotting(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            Queue<int []> queue = new LinkedList<int[]>();
            int dist = -1;
            Boolean[][] bad = new Boolean[height][width];
            int flag = 0;
            for(int i =0 ;i<height;i++){
                for(int j=0;j<width;j++){
                    if(grid[i][j] == 2) {
                        queue.add(new int[]{i, j});
                        bad[i][j] = true;

                    }else{
                        bad[i][j] = false;

                    }
                    if(grid[i][j]==1){
                        flag =1;
                    }
                }
            }
            if(flag==0){
                return 0;
            }
            int[] x_ = {0,1,0,-1};
            int[] y_ = {1,0,-1,0};
            while (!queue.isEmpty()) {
                int size = queue.size();
                for(int num = 0;num<size;num++){
                    int[] p = queue.poll();
                    for (int Q = 0; Q < 4; Q++) {
                        int ni = p[0]+y_[Q];
                        int nj = p[1]+x_[Q];
                        if(ni>=0 && ni<height && nj>=0 && nj<width){
                            if(grid[ni][nj]==1 && !bad[ni][nj]){
                                bad[ni][nj] = true;
                                queue.add(new int[]{ni,nj});
                            }
                        }
                    }

                }
                dist++;
            }
            for(int i =0 ;i<height;i++) {
                for (int j = 0; j < width; j++) {
//                    System.out.print(bad[i][j]);
//                    System.out.print(' ');
                    if (!bad[i][j] && grid[i][j]!=0) {
                        dist=-1;
                    }
                }
//                System.out.println();
            }
            return dist;
        }

}