package leetcode.AlgorithmBasis;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class maxLand {
    public static void main(String[] args){
        int [][] grid= {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0}
                ,{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        Solution7 solution7 = new Solution7();
        int p = solution7.maxAreaOfIsland(grid);
        System.out.println(p);
    }
}

class Solution7 {
    public int maxAreaOfIsland(int[][] grid) {
        int max_size = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int current = grid[i][j];
                if(current==1){
                    int size = breathSearch(grid,i,j);
                    if(max_size<size){
                        max_size = size;
                    }
                }
            }
        }
        return max_size;
    }

    public int breathSearch(int[][] grid,int sr,int sc ){
        int[] x_ = {0, 1, 0, -1};
        int[] y_ = {1, 0, -1, 0};
        int width = grid[0].length;
        int height = grid.length;
        int size = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            sr = p[0];
            sc = p[1];
            if (grid[sr][sc] == 1) {
               size++;
               grid[sr][sc] = 0;
                for (int i = 0; i < 4; i++) {
                    int y = sr + y_[i];
                    int x = sc + x_[i];
                    if (y >= 0 && y < height && x >= 0 && x < width ) {
                        if (grid[y][x]==1)
                        {
                            queue.offer(new int[]{y, x});
                        }
                    }

                }

            }
        }
        return size;
    }
}
