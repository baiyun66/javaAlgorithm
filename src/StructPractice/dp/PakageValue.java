package structpractice.dp;

import java.util.Arrays;
// 背包问题带价值
//https://www.lintcode.com/problem/125/
import static java.util.Arrays.sort;

public class PakageValue {
    public static void main(String[] args) {
        Dp dp = new Dp();
        System.out.println(dp.dpWeight());

    }

    static class Dp{
        int[] weight = {2, 3, 5, 7};
        int [] V = {1,5,2,4};
        int size = 10;


        public int dpWeight(){
            int [][] maxWight = new int[weight.length+1][size+1];
            for(int i=0;i< size+1;i++){
                maxWight[0][i] =0;
            }
            for(int i=0;i< weight.length+1;i++){
                maxWight[i][0] =0;
            }
            print(maxWight);
            for(int i=1;i< weight.length+1;i++){
                for(int j =1;j<size+1;j++ ){
                    if(weight[i-1]<=j){
                        maxWight[i][j] =  Math.max(maxWight[i-1][j],V[i-1] + maxWight[i-1][j-weight[i-1]]);
                    } else{
                        maxWight[i][j] = maxWight[i-1][j];
                    }
                }
                print(maxWight);

            }
            Arrays.sort(maxWight[maxWight.length-1]);

            return maxWight[maxWight.length-1][size];
        }


        public void print(int [][] maxWight){
            System.out.println("开始计算");
            for(int i=0;i< weight.length+1;i++){
                for(int j =0;j<size+1;j++ ){
                    System.out.printf("%d ",maxWight[i][j]);
                }
                System.out.println();

            }
        }


        public int dpWeight2() {
            int [] dps = new int[size+1];
            for(int i = 0;i< weight.length;i++){
                for(int j=dps.length-1;j>=weight[i];j--){
                    dps[j] = Math.max(dps[j-weight[i]]+weight[i],dps[j]);
                }
            }
            return dps[size];
        }

        public int backPackII(int m, int[] A, int[] V) {
            // write your code here
            int [] dps = new int[m+1];
            for(int i = 0;i<A.length;i++){
                for(int j = m;j>=A[i];j--){
                    dps[j] = Math.max(dps[j-A[i]] + V[i], dps[j]);
                }
            }
            return dps[m];
        }

    }
}
