package leetcode.codeLisit200.binary;

public class SwapTwoInt {

    public int[] swapTwoInt(int [] nums){
        nums[0] = nums[0]^nums[1];
        nums[1] = nums[1]^nums[0];
        nums[0] = nums[0] ^ nums[1];
        return nums;
    }

    public static void main(String[] args) {
        int [] nums ={1,2};
        SwapTwoInt swapTwoInt = new SwapTwoInt();
        nums = swapTwoInt.swapTwoInt(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
