package leetcode.codeLisit200.stack;

import java.util.Stack;

public class KuoHaoPiPei {

    public static void main(String[] args) {
        KuoHaoPiPei kuoHaoPiPei = new KuoHaoPiPei();
        System.out.println(kuoHaoPiPei.isValid("{"));
    }

    public boolean isValid(String s) {
        Stack<Character> chs = new Stack<>();
        int p = 0;
        int len = s.length();
        while (p<len){
            char temp =  s.charAt(p);
            if(temp=='{' || temp=='(' || temp=='['){
                System.out.printf("in stack %c\n",temp);
                chs.add(temp);
            }else{
                if(chs.size()==0) {
                    return false;
                }
                char tempPeek = chs.peek();
                if((tempPeek=='[' && temp==']') || (tempPeek=='{' && temp=='}') || (tempPeek=='(' && temp==')')){

                    System.out.printf("out stack %c\n",temp);
                    chs.pop();
                }else {
                    return false;
                }
            }
            p++;
        }
        if(chs.size()==0) {
            return true;
        }else {
            return false;
        }
    }
}


