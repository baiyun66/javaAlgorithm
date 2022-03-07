package leetcode.codeLisit200.doubleindex;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int l = 0;

        int r = len-1;

        while (l<r){
            if(target-numbers[l] == numbers[r]){
                return new int[]{l+1,r+1};
            }else if(target-numbers[l] < numbers[r]){
                r--;
            }else {
                l++;
            }
        }
        return new int[]{0,0};

    }

    public static void main(String[] args) {
        int []numbers = {2,7,11,15};
        int target = 9;

        TwoSumII sumII = new TwoSumII();
        for (int i : sumII.twoSum(numbers, target)) {
            System.out.println(i);
        }
    }
}
