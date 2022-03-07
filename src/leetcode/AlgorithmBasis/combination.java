package leetcode.AlgorithmBasis;
import java.util.*;

public class combination {
    public static void main(String[] args){
        int n = 4;
        int k = 2;
        Solution_c solution_c = new Solution_c();

        solution_c.out(solution_c.combine(n,k));
    }
}



class Solution_c {

    public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Stack<Integer> que = new Stack<>();
    combin_array(1,n,k,ans,que);
    return ans;
    }

    public void combin_array( int cur,int n,int k,List<List<Integer>> ans,Stack<Integer> que){
        if(que.size()+n-cur+1<k){
            return ;
        }
        if(que.size()==k){
            //为什么要新建一个对象
            ans.add(new ArrayList<Integer>(que));
            return;
        }

        for(int i=cur;i<=n;i++){
            que.add(i);
            combin_array(i+1,n,k,ans,que);
            que.pop();
        }
    }

    public void out(List<List<Integer>> lists){
        for(int i=0;i<lists.size();i++){
            System.out.print(lists.get(i));
            System.out.println();
        }
    }
}