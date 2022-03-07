package leetcode.codeLisit200.binary;


import static java.lang.Integer.toBinaryString;

public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<=1;
            res |= (n&1);
            n>>=1;
        }
        return res;

    }

    public static void main(String[] args) {
        int num = -3;
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(num));

    }
}
