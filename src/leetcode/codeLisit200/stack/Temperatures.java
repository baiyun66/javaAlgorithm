package leetcode.codeLisit200.stack;

import java.util.Stack;

public class Temperatures {
    public static void main(String[] args) {
        Temperatures temperatures = new Temperatures();
        int[] temperature = {73,74,75,71,69,72,76,73};
        int[] ans = temperatures.dailyTemperatures(temperature);

        for(int i = 0;i<ans.length;i++){
            System.out.printf("%d,",ans[i]);
        }


    }
    public int[] dailyTemperatures(int[] temperatures) {
        int [] ans = new int[temperatures.length];
        Stack<Integer> stackMin = new Stack<>();
        for(int i =1;i<ans.length;i++){
            if(temperatures[i]>temperatures[i-1]){
                ans[i-1] = 1;
            }else {
                stackMin.add(i-1);
            }
            while(stackMin.size()>0) {
                if (temperatures[i] > temperatures[stackMin.peek()]) {
                    ans[stackMin.peek()] = i - stackMin.pop();
                }else {
                    break;
                }
            }
        }
        return ans;
    }
}
