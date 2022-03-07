package leetcode.codeLisit200.doubleindex;

import static java.lang.Integer.toBinaryString;

public class ReverseVowels {
    public String reverseVowels(String s) {

        int mask = 0;
        char [] aChars = {'a','e','i','o','u'};
        int tc;
        for (int i = 0; i < aChars.length; i++) {
            tc = aChars[i]-'a';
            mask |= 1<<tc;
        }
        System.out.println(mask);
        System.out.println(toBinaryString(mask));

        char [] chars = s.toCharArray();
        int len = chars.length;
        int l = 0;
        int r = len-1;
        char t;
        while (l<r){
            while (!isA(chars[l]) && l<r){
                l++;
            }
            while (!isA(chars[r]) && l<r){
                r--;
            }
            t = chars[l];
            chars[l] = chars[r];
            chars[r] = t;
            r--;
            l++;
        }

        return new String(chars);
    }

    public boolean isA(char c){
        if(c>'z' || c<'A')return false;
        if(c>='a'){
            return ((1065233>>(c-'a'))&1) ==1;
        }else {
            return ((1065233>>(c-'A'))&1) ==1;
        }
    }


    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels("hello"));
//        System.out.println('c'>'C');

//        return "aeiouAEIOU".indexOf(ch) >= 0;


    }
}
