package leetcode.codeLisit200.binary;

public class MissingNumber {

    public int missingNumber(int[] nums) {

//        int sum = nums.length*(nums.length+1)/2;
//
//        for (int i :nums
//             ) {
//            sum-=i;
//        }
//        return sum;

        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ nums.length;

    }

    public static void main(String[] args) {

        int[] nums = {9,6,4,2,3,5,7,0,1};

        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));


    }
}
