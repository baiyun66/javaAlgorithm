package interview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 24629
 * @Description
 * @create 2022-03-05 19:11
 */
public class NotContinue {

    public int addValue(int [] nums,int index,int last){
        int ans = 0;
        for (int i = index; i < nums.length; i++) {
            if(nums[i]>last+1){
                ans++;
            }else if(nums[i]==last+1) {
//                ans.get() = nums[i];
                int ans1 = addValue(nums,i+1,last);
                int ans2 = addValue(nums,i+1,nums[i]);
                return Math.max(ans1,ans2);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7,9,10};
//        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);
        NotContinue notContinue = new NotContinue();
        System.out.println(notContinue.addValue(nums,0,nums[0]));
//        System.out.println(ans.toString());
    }
}
