package leetcode.codeLisit200.doubleindex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans="";

        for (int i = 0; i < dictionary.size(); i++) {
            if(dictionary.get(i).length()>ans.length() && beIn(s,dictionary.get(i))){
                ans = dictionary.get(i);
                System.out.println(ans);
            }else if( dictionary.get(i).length()==ans.length() && dictionary.get(i).compareTo(ans)<0  && beIn(s,dictionary.get(i))){
                ans = dictionary.get(i);
                System.out.println(ans);
            }
        }

        return ans;

    }

    private boolean beIn(String s, String s1) {
        int index1 = 0;
        for (int i = 0; i < s1.length(); i++) {
            while (index1<s.length() && s.charAt(index1)!=s1.charAt(i)){
                index1++;
            }
            if(index1==s.length()){
                return false;
            }
            index1++;
        }
        return true;

    }

    public static void main(String[] args) {
//        String s = "abpcplea";
//        String [] strs = {"ale","apple","monkey","plea","abpcple"};
//        String s = "abce";
//        String [] strs = {"ace","abe"};
//        String s ="abpcplea";
////
//                String [] strs = {"ale","apple","monkey","plea","abpcplaaa","abpcllllll","abccclllpppeeaaaa"};

        String s = "aewfafwafjlwajflwajflwafj";
        String [] strs =     {"apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"};

        List<String> dictionary = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            dictionary.add(strs[i]);
        }
//        System.out.println();
        FindLongestWord findLongestWord = new FindLongestWord();
        System.out.println(findLongestWord.findLongestWord(s, dictionary));


    }
}
