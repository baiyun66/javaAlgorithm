package leetcode.AlgorithmBasis;
import java.util.*;

public class Rob {
    public static void main(String[] args){
//        int[] nums = {2,7,9,3,1};
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
                ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        Solution_Rob solution_c = new Solution_Rob();
        System.out.println(solution_c.rob_2(nums));

    }
}



class Solution_Rob {

    public int rob(int[] nums) {
        int [] ans = new int[nums.length+1];
        if(nums.length == 1){
            return nums[0];
        }
        for(int i =0;i<ans.length;i++){
            ans[i] = -1;
        }
        ans [1] = nums[0];
        ans [2] = Math.max(nums[1],nums[0]);

        return rob2(nums,ans,nums.length);

    }

    public int rob2(int[] nums,int[] ans,int n) {
        if(n==1 || n==2){
            return ans[n];
        }else {
            if(ans[n-2]!=-1){
                ans[n] = Math.max(rob2( nums,ans,n-1),ans[n-2]+nums[n-1]);
            }else{
                ans[n] = Math.max(rob2( nums,ans,n-1),rob2( nums,ans,n-2)+nums[n-1]);
            }
        }
        return ans[n];

    }

    public int rob_2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int [] ans = new int[nums.length];

        ans [0] = nums[0];
        ans [1] = Math.max(nums[1],nums[0]);
        int i;
        for(i=2;i<ans.length;i++){
            ans[i] = Math.max(ans[i-1],ans[i-2]+nums[i]);
        }
        return ans[i-1];
    }
}