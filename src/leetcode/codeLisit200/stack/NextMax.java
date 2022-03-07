package leetcode.codeLisit200.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextMax {
    public static void main(String[] args) {
        NextMax temperatures = new NextMax();
        int[] temperature = {5,4,3,2,1};
        int[] ans = temperatures.nextGreaterElements(temperature);

        for(int i = 0;i<ans.length;i++){
            System.out.printf("%d,",ans[i]);
        }

    }
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<len;i++){
            ans[i] = -1;
        }
        for(int i = 1;i<len*2;i++){
            if(nums[i%len]>nums[(i-1)%len]){
                ans[(i-1)%len] = nums[i%len];
                while(stack.size()>0){
                    if(nums[i%len]>nums[stack.peek()]){
                        ans[stack.pop()] = nums[i%len];
                    }else {
                        break;
                    }
                }
            }else {
                stack.add((i-1)%len);
            }
        }
        return ans;
    }
}
