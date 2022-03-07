package leetcode.AlgorithmBasis;

import javax.xml.stream.FactoryConfigurationError;
import java.util.*;

public class slideWindows {
    public static void main(String[] args) {
//        String string = "abcabccc";
//        Solution4 solution4 = new Solution4();
//        int num = solution4.lengthOfLongestSubstring2(string);
//        System.out.println(num);
//        s1 = "ab" s2 = "eidbaooo"
        String string1 = "ik";
        String string2 = "lik";

        Solution4 solution4 = new Solution4();
        Boolean num = solution4.checkInclusion2(string1,string2);
        System.out.println(num);

    }

}

class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1){
            return s.length();
        }
        char [] chs= s.toCharArray();
        int l = 0;
        int r = 1;
        int max_len = 1;
        while (r<chs.length){
            int p = belongToString(chs,chs[r],l,r);
            if(p!=-1){

                l=p+1;
            }else {
                if(max_len<(r-l+1)){
                    max_len = (r-l+1);
                }
            }
            r++;
        }
        return max_len;

    }

    public int belongToString(char [] chs,char c,int l ,int r){
        for(int i = l; i<r; i++){
            if(chs[i]==c){
               return i;
            }
        }
        return -1;
    }



        public int lengthOfLongestSubstring2(String s) {
            // 哈希集合，记录每个字符是否出现过
            Set<Character> occ = new HashSet<Character>();
            int n = s.length();
            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
            int rk = -1, ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    // 左指针向右移动一格，移除一个字符
                    occ.remove(s.charAt(i - 1));
                }
                System.out.println(occ);
                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                    // 不断地移动右指针
                    occ.add(s.charAt(rk + 1));
                    ++rk;
                }
                System.out.println(occ);
                // 第 i 到 rk 个字符是一个极长的无重复字符子串
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }

    public boolean checkInclusion(String s1, String s2) {
//        List<Character> list = new ArrayList<Character>();
        StringBuffer list = new StringBuffer();
        int len =s1.length();
        if(len>s2.length()){
            return false;
        }
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        for(int i=0;i<len;i++){
            list.append(b[i]);

        }
        Arrays.sort(a);
//        System.out.println(a);
        if(len==s2.length()){
            return checkSting(a,list.toString());
        }

        for(int i = len;i<=s2.length();i++){
            if(checkSting(a,list.toString())){
                return true;
            }
            if(i!=s2.length()){
                list.deleteCharAt(0);
                list.append(b[i]);
            }
        }
        return false;
    }
    public boolean checkSting(char[] a, String list) {
        char[] chs = list.toCharArray();
        Arrays.sort(chs);
//        System.out.println(chs);
        if (Arrays.equals(chs, a)){
            return true;
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int[] chs1 = new int[26],chs2 = new int[26];
        int len1 =s1.length();
        int len2 =s2.length();
        if(len1>len2){
            return false;
        }
        for(int i=0;i<len1;i++){
            chs1[s1.charAt(i)-'a']++;
            chs2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(chs1,chs2)){
            return true;
        }
        for(int i = len1;i<len2;i++){
            chs2[s2.charAt(i)-'a']++;
            chs2[s2.charAt(i-len1)-'a']--;
            if(Arrays.equals(chs1,chs2)){
                return true;
            }
        }
        return false;
    }
}