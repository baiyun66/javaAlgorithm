package leetcode.codeLisit200.doubleindex;

public class ValidPalindrome {
    int flag = 1;
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l<r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else {

                System.out.println(s.charAt(r));
                System.out.println(s.charAt(l));
                if(s.charAt(l+1) == s.charAt(r) && flag==1 && s.charAt(l) == s.charAt(r-1) ){
                    flag = 0;
                   return validPalindrome(s.substring(l+1,r+1)) || validPalindrome(s.substring(l,r));
                } else if(s.charAt(l+1) == s.charAt(r) &&flag==1 ){
                    flag = 0;
                    return validPalindrome(s.substring(l+1,r+1));
                } else if(s.charAt(l) == s.charAt(r-1) &&flag==1 ){
                    flag = 0;
                    return validPalindrome(s.substring(l,r));
                }
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
//        String s = "acaac";
        System.out.println(s.substring(1,3));
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.validPalindrome(s));
    }
}
