package leetcode.codeLisit200.binary;

import static java.lang.Long.toBinaryString;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
//        int ans = ;
        String ans = toBinaryString(x^y);
        int count = 0;
        for (int i = 0; i < ans.length(); i++) {
            if(ans.charAt(i)=='1'){
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int x= 1;
        int y = 3;

        HammingDistance hammingDistance = new HammingDistance();
        System.out.println(hammingDistance.hammingDistance(x,y));

    }
}
