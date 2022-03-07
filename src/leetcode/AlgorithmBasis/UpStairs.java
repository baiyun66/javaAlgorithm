package leetcode.AlgorithmBasis;
import java.util.*;

public class UpStairs {
    public static void main(String[] args){
        int n = 45;
        Solution_UP solution_c = new Solution_UP();
        System.out.println(solution_c.climbStairs(n));

    }
}



class Solution_UP {

        public int climbStairs(int n) {
            int [] x = new int[n+1];
            return climbStairs2(n,x);
        }

    public int climbStairs2(int n,int[] x) {
        if(n==1 || n==0){
            return 1;
        }
        else {
            if(x[n-1]!=0){
                x[n] = x[n-1] + climbStairs2(n-2,x);
            }else {
                x[n] = climbStairs2(n-2,x)+climbStairs2(n-1,x);
            }
        }
        return x[n];
    }
}