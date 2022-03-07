package structpractice.dp;

// 背包问题带价值
//https://www.lintcode.com/problem/125/
import static java.util.Arrays.sort;

public class ansNum {
    public static void main(String[] args) {
        Dp dp = new Dp();
        System.out.println(dp.dpWeight());

    }

    static class Dp{
        int[] weight = {8,7,4,3};
        int size = 11;


        public int dpWeight(){
            int ans=0;
            int max=0;
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
                    boolean isUpdate = false;
                    if(weight[i-1]<=j){
                        if(weight[i-1] + Math.max(maxWight[i-1][j-weight[i-1]],maxWight[i][j-weight[i-1]])>=maxWight[i-1][j]){
                            isUpdate = true;
                            if(j==size)
                            System.out.printf("%d  %d  %d  \n",weight[i-1],Math.max(maxWight[i-1][j-weight[i-1]],maxWight[i][j-weight[i-1]]),maxWight[i-1][j]);
                            maxWight[i][j] = weight[i-1] + Math.max(maxWight[i-1][j-weight[i-1]],maxWight[i][j-weight[i-1]]);
                        }
                        else{
                            maxWight[i][j] = maxWight[i-1][j];
                        }
                    } else{
                        maxWight[i][j] = maxWight[i-1][j];
                    }

                    if(j==size){
                        if(maxWight[i][j]>max){
                            max = maxWight[i][j];
                            ans = 0;
                            if(isUpdate){
                                ans++;
                                System.out.println("update");
                            }
                        }else{
                            if(isUpdate){
                                ans++;
                                System.out.println("update");
                            }
                        }
                    }
                }
                print(maxWight);

            }
            System.out.printf("最大值为：%d\n",maxWight[maxWight.length-1][size]);
            return ans;
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






    }
}
