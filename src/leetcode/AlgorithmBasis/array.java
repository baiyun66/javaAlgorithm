package leetcode.AlgorithmBasis;

import java.lang.reflect.Array;
import java.util.Arrays;

public class array {
    public static void main(String[] args){

//        int[] nums = {-4,-1,0,3,10};
//        Solution1 solution = new Solution1();
//        int[] a = solution.sortedSquares1(nums);
//        System.out.println(a.length);

        int k = 2;
        int[] nums = {-1,-100,3,99};
        Solution1 solution = new Solution1();
        solution.rotate1(nums,k);





    }
}

class Solution1 {

    public int[] sortedSquares(int[] nums) {

        for(int i=0;i<nums.length;i++){
            nums[i]= nums[i]*nums[i];
        }

        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));

        return nums;

    }
    public int[] sortedSquares1(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int[] ans = new int[r+1];
        int index = r;
        while (index>=0){
            if(nums[l]*nums[l]<=nums[r]*nums[r]){
                ans[index]= nums[r]*nums[r];
                r--;
            }else {
                ans[index]= nums[l]*nums[l];
                l++;
            }
            index--;
        }

        System.out.println(Arrays.toString(ans));

        return ans;

    }
    public void rotate(int[] nums, int k) {

        int len = nums.length;
        k = k%len;
        int index = 0;
        int p = nums[index];
        int q = nums[(index + k) % len];
        for(int i =0;i<len;i++){
            nums[(index + k) % len] = p;
            index = (index+k)%len;
            p = q;
            q = nums[(index + k) % len];
            System.out.println(Arrays.toString(nums));
        }
        }


    public void rotate1(int[] nums, int k) {
        System.out.println(nums.length);
        k =  k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        System.out.println(Arrays.toString(nums));

    }

    public void reverse(int[] nums,int start,int end){
        int q = nums[end];
       while(start<end){
           q = nums[end];
           nums[end] = nums[start];
           nums[start] = q;
           start++;
           end--;
       }
    }
}
