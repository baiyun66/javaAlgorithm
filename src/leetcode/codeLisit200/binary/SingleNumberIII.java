package leetcode.codeLisit200.binary;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        int[] res = new int[2];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans^nums[i];
        }
        ans = ans & -ans;

        for (int num : nums) {
            if ((num & ans) == 0)
            {res[0] ^= num;}
            else {res[1] ^= num;}
        }

        return res;

    }


    public static void main(String[] args) {
        int []  nums = {1,2,1,3,2,5};
        SingleNumberIII singleNumber = new SingleNumberIII();
        for (int i:
        singleNumber.singleNumber(nums)) {
            System.out.println(i);
        }
    }
}
