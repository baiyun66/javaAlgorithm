package leetcode.codeLisit200.binary;

import static java.lang.Integer.toBinaryString;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {

//        return n>0 && (n&(n-1))==0;
        // 4的幂
        return n > 0 && (n & (n - 1)) == 0 && (n & 0b01010101010101010101010101010101) != 0;
    }

    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        System.out.println(isPowerOfTwo.isPowerOfTwo(4));
        System.out.println(toBinaryString(32));
        System.out.println(toBinaryString(32).length());


    }
}
