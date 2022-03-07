package leetcode.AlgorithmBasis;

public class BinarySearch {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,6};
        int target = 5;
        Solution solution = new Solution();
//        int a = solution.search(nums,target);
        int a = solution.searchInsert(nums,target);
        System.out.println(a);
    }
}


class Solution {
    public int search(int[] nums, int target) {
        System.out.println((double) 5/2);
        int h = 0;
        int t = nums.length-1;
        while (h<=t){
            int m = (int) Math.floor((t+h)/2);
            if (nums[m]==target){
                return m;
            }
            else if(nums[m]<target){
                h = m+1;
            }else {
                t = m-1;
            }
        }
        return -1;

    }
    public int firstBadVersion(int n) {
        int h = 1;
        int t = n;
        int m =0;
//        while (h<t){
//            m = h+(t-h)/2;
//            if(isBadVersion(m)){
//                t = m;
//            }else {
//                h = m+1;
//            }
//        }
        return h;
    }

    public int searchInsert(int[] nums, int target) {
        int h = 0;
        int t = nums.length-1;
        if(target<nums[t]){
            return t+1;
        }
        while (h<t){
            int m = h+(t-h)/2;
            if (nums[m]==target){
                return m;
            }
            else if(nums[m]<target){
                h = m+1;
            }else {
                t = m;
            }
        }
        return h;

    }
}