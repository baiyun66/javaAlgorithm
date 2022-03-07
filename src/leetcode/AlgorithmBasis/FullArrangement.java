package leetcode.AlgorithmBasis;
import java.util.*;

public class FullArrangement {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        Solution_Full2 solution_c = new Solution_Full2();
        solution_c.out(solution_c.permute(nums));
    }
}



class Solution_Full {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Stack<Integer> que = new Stack<>();
        int[] state = new int[nums.length];
        combin_array(state,nums,ans,que);
        return ans;
    }

    public void combin_array( int [] state,int[] nums,List<List<Integer>> ans,Stack<Integer> que){
        if(que.size() == state.length){
            ans.add(new ArrayList<Integer>(que));
            return;
        }
        for(int i=0;i<state.length;i++){
            if(state[i]==0)
            {
                que.add(nums[i]);
                state[i] = 1;
                combin_array(state,nums,ans,que);
                que.pop();
                state[i] = 0;
            }
        }
    }

    public void out(List<List<Integer>> lists){
        for(int i=0;i<lists.size();i++){
            System.out.print(lists.get(i));
            System.out.println();
        }
    }
}

class Solution_Full2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> state = new ArrayList<Integer>();
        for(int i:nums){
            state.add(i);
        }
        int n = nums.length;
        combin_array(n,state,ans,0);
        return ans;
    }

    public void combin_array(int n,List<Integer> state,List<List<Integer>> ans,int cur){
        if(cur == n-1){
            ans.add(new ArrayList<Integer>(state));
            return;
        }
        for(int i=cur;i<n;i++) {
            Collections.swap(state,i,cur);
            combin_array(n,state,ans, cur+1);
            Collections.swap(state,cur,i);
        }
    }

    public void out(List<List<Integer>> lists){
        for(int i=0;i<lists.size();i++){
            System.out.print(lists.get(i));
            System.out.println();
        }
    }
}
