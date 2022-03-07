package leetcode.codeLisit200.str;

import java.util.HashMap;

public class CharLoopCover {
    public static void main(String[] args) {
        String s1 = "AABCD";
        String s2 = "CDAA";
        CharLoopCover charLoopCover = new CharLoopCover();
//        System.out.println(charLoopCover.isLoopInclude(s1, s2));

//        System.out.println(charLoopCover.loopMove(s1, 15));

//        String s3 = "I am a students";
//        System.out.println(charLoopCover.reverseWords(s3));

        String s4 = "amiastudents";
        String s5 = "iamastusdent";

//        System.out.println(charLoopCover.isAnagram(s4, s5));
//        System.out.println(charLoopCover.isAnagram2(s4, s5));

//        String s6 = "AYZnjcc";
//        System.out.println(charLoopCover.longestPalindrome(s6));

//        String s6 = "13";
//        String s7 = "42";
//        System.out.println(charLoopCover.isIsomorphic(s6,s7));

//        System.out.printf("%d", charLoopCover.countSubstrings("aaa"));

        System.out.printf("%d", charLoopCover.countBinarySubstrings("00110011"));
    }

    //    编程之美 3.1
    public Boolean isLoopInclude(String s1,String s2) {

        s1 = s1+s1;
        int len = s2.length();
        for(int i = 0;i<s1.length()-len;i++){
            System.out.println(s1.substring(i, i + len));
            if(s1.substring(i,i+len).equals(s2) ){
                return true;
            }
        }
        return false;

    }

    //    编程之美 2.17
    public String loopMove(String s1,int k) {
        int len = s1.length();
       String temp = s1.substring(len - k%len,len);
        System.out.println(temp);
        s1 = s1.substring(0,len - k%len);

       return temp+s1;

    }

    public String reverseWords(String s1) {
        String [] strArray = s1.split(" ");

        String ans = "";
        for(int i = strArray.length-1;i>0;i--){
            ans = ans + strArray[i]+" ";
        }
        ans+=strArray[0];
        return ans;

    }

    public boolean isAnagram(String s, String t) {
        int [] ch1 = new int[26];
        int [] ch2 = new int[26];
        if(s.length()!=t.length()){
            return false;
        }

        for(int i = 0;i<s.length();i++){
            ch1[s.charAt(i)-'a'] ++;
            ch2[t.charAt(i)-'a'] ++;
        }

        for(int i = 0;i<26;i++){
           if(ch1[i]!=ch2[i]){
               return false;
           }
        }
        return true;

    }

    public boolean isAnagram2(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int [] ch1 = new int[26];
        int [] ch2 = new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        for(int i = 0;i<chars1.length;i++){
            ch1[chars1[i]-'a'] ++;
            ch2[chars2[i]-'a'] ++;
        }

        for(int i = 0;i<26;i++){
            if(ch1[i]!=ch2[i]){
                return false;
            }
        }
        return true;

    }


    public int longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int[] ans = new int[26*2];

        for(int i = 0;i<array.length;i++){
            if (array[i]-'A'<26){
                ans[array[i]-'A']++;
            }
            if (array[i]-'a'>0){
                ans[array[i]-'a'+26]++;
            }
        }
        int len = 0;
        int flag = 0;

        for(int i = 0;i<ans.length;i++){
            if(ans[i]%2==0){
                len+=ans[i];
            }else {
                if(flag==0){len+=1;flag=1;}
                if(ans[i]/2!=0){
                    len += (ans[i]-1);
                }
            }
        }
//        System.out.println(ans[i]);
        return len;
    }

    public boolean isIsomorphic(String s, String t) {
        char[] array = new char[26];
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        if(s1.length != s2.length){
            return false;
        }
        if(!isIsomorphic2(s1, s2)){
            return false;
        }
        if(!isIsomorphic2(s2, s1)){
            return false;
        }
        return true;
    }

    public boolean isIsomorphic2( char[] s1,   char[] s2) {
        HashMap<Character,Character> fx= new HashMap<>();
        for(int i = 0;i<s1.length;i++){
            if(!fx.containsKey(s1[i])){
                fx.put(s1[i],s2[i]);
            }else {
                if(fx.get(s1[i]) != s2[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public int countSubstrings(String s) {
        char[] array = s.toCharArray();
        int len = 2;
        int arrayLn = array.length;
        int ans = arrayLn;
//        System.out.printf("%d\n", ans);
        while (len<=arrayLn){
            for(int i = 0;i<arrayLn-len+1;i++){
                if(isReturnStr(array,i,i+len-1)){
                    ans++;
                }
            }
//            System.out.printf("%d %d\n", len,ans);
            len++;
        }
        return ans;
    }

    public Boolean isReturnStr(char [] array,int l,int r) {
        while (l<r){
            if(array[l]!=array[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;

    }

    public int countBinarySubstrings(String s) {
        int strLen = s.length();
        char [] array = s.toCharArray();
        int ans = 0;
        if(strLen<2){
            return 0;
        }
        int len = 2;
        int l = 0;
        while(len<=strLen){
            int i = 0;
            while (i<=strLen-len){
                l = i;
                i+=1;
                System.out.printf("%d - %d\n", l,len);
                if(isRightBinarySubstrings(array,l,len)){
                    System.out.print("right\n");
                    ans++;
                }
            }
            len+=2;
        }
    return ans;
    }

    public Boolean isRightBinarySubstrings(char[] array,int l,int len) {
        int r = l+len-1;
        char lv = array[l];
        char rv = array[r];
        if(lv==rv){
            return false;
        }
        while (l<r){
            if(array[l]!=lv || array[r]!=rv){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
