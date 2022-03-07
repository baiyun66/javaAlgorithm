package leetcode.codeLisit200.binary;
import static java.lang.Integer.toBinaryString;

class FindComplement {
    public int findComplement(int num) {
        int len = toBinaryString(num).length();
        System.out.println(len);
        System.out.println((int)(Math.pow(2, len)-1));
        return num ^ (int)(Math.pow(2, len)-1);

//        Integer.highestOneBit(num)
        // return num^(((num&(num-1))-1)<<1)+1;

    }

    public static void main(String[] args) {
        FindComplement findComplement  = new FindComplement();
        System.out.println(findComplement.findComplement(8));
    }
}