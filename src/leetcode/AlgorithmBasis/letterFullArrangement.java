package leetcode.AlgorithmBasis;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class letterFullArrangement {
    public static void main(String[] args){
        String S = "s32x4";
        Solution_letterFull solution_c = new Solution_letterFull();
        solution_c.out(solution_c.letterCasePermutation(S));
    }
}



class Solution_letterFull {

    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        List<String> ans = new ArrayList<String>();
        List<Integer> position = new ArrayList<Integer>();
        for(int i=0;i<chars.length;i++){
            if('a'<=chars[i] && chars[i] <='z'){
                position.add(i);
            }
        }
        for(int i =0;i<=position.size();i++){
            combin_array(position,0,chars,ans,i,position.size(),0);
        }
        return ans;
    }

    public void combin_array( List<Integer> position,int cur_size ,char[] chars,List<String> ans,int need_size,int chs,int cur){
        if(need_size == cur_size){
            ans.add(String.valueOf(chars));
            return;
        }
        for(int i=cur;i<chs;i++){
            cur_size++;
            int index = position.get(i);
            chars[index] =  Character.toUpperCase(chars[index]);
            combin_array(position,cur_size,chars,ans,need_size,chs,i+1);
            cur_size--;
            chars[index] = Character.toLowerCase(chars[index]);
        }
    }

    public void out(List<String> lists){
        for(int i=0;i<lists.size();i++){
            System.out.print(lists.get(i));
            System.out.println();
        }
    }
}


