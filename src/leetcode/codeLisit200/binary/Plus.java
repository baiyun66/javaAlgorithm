package leetcode.codeLisit200.binary;

import static java.lang.Integer.toBinaryString;

public class Plus {

        public int getSum(int a, int b) {
            System.out.println(toBinaryString(a));
            System.out.println(toBinaryString(b));
            while (b != 0) {
                int carry = (a & b) << 1;
                System.out.println(toBinaryString(carry));
                a = a ^ b;
                System.out.println(toBinaryString(a));
                b = carry;
                System.out.println(toBinaryString(b));
            }
            return a;
        }

    public static void main(String[] args) {
        Plus plus = new Plus();
        System.out.println(plus.getSum(5, 9));
    }
}
