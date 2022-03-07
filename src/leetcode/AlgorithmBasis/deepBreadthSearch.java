package leetcode.AlgorithmBasis;

import java.util.LinkedList;
import java.util.Queue;

public class deepBreadthSearch {
    public static void main(String[] args){
        int [][] image = {{0,0,0},{0,0,0}};
        int sr = 0, sc = 0, newColor = 2;
        Solution5 solution = new Solution5();
        int [][] a = solution.floodFill2(image,sr,sc,newColor);
        int width = image[0].length;
        int height = image.length;
        for(int i=0; i<height; i++){
            for (int j=0; j<width; j++)
                System.out.printf("%5d",image[i][j]);
            System.out.println();
        }
    }
}


class Solution5 {
    public int num = 0;
    public int start_color;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
         int width = image[0].length;
         int height = image.length;
         if(num==0){
             start_color =  image[sr][sc];
             num = 1;
         }
        if(sr<0 ||sr>=height || sc<0 ||sc>=width){
            return image;
        }

        System.out.println();
        System.out.print(sr);
        System.out.println(sc);
        System.out.println(start_color);
        System.out.println();
        if(image[sr][sc] == newColor){
            return image;
        }
        else if(image[sr][sc] == start_color){
            image[sr][sc] = newColor;
            for(int i=0; i<height; i++){
                for (int j=0; j<width; j++)
                    System.out.printf("%5d",image[i][j]);
                System.out.println();
            }
            System.out.println();
        }else{
            return image;
        }
        image = floodFill(image,sr+1,sc, newColor);
        image = floodFill(image,sr,sc+1, newColor);
        image = floodFill(image,sr-1,sc, newColor);
        image = floodFill(image,sr,sc-1, newColor);
        return image;
    }


    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int[] x_ = {0, 1, 0, -1};
        int[] y_ = {1, 0, -1, 0};
        int width = image[0].length;
        int height = image.length;
        int start_color = image[sr][sc];
        if (start_color == newColor) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            sr = p[0];
            sc = p[1];
            if (image[sr][sc] == start_color) {
                image[sr][sc] = newColor;
                for (int i = 0; i < 4; i++) {
                    int y = sr + y_[i];
                    int x = sc + x_[i];
                    if (y >= 0 && y < height && x >= 0 && x < width ) {
                        if (image[y][x]==start_color)
                        {
                            queue.offer(new int[]{y, x});
                        }
                    }

                }

            }
        }
        return image;
    }
}

