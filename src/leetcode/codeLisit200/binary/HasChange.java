package leetcode.codeLisit200.binary;
import static java.lang.Integer.toBinaryString;
class HasChange {
    public boolean hasAlternatingBits(int n) {
        // int before = n&1;
        //  int now = 0;
        // while(n>0){
        //     n>>=1;
        //     now = n&1;
        //     if(before==now){
        //         return false;
        //     }else{
        //         before = now;
        //     }
        // }
        // return true;

        int len = toBinaryString(n).length();
        int mask= (1<<len)-1;
        System.out.println(toBinaryString(mask));
        return (n ^ (0b01010101010101010101010101010101 & mask)) ==0 || (n ^ (0b10101010101010101010101010101010 & mask))==0;

    }

    public static void main(String[] args) {
        HasChange hasChange = new HasChange();
        hasChange.hasAlternatingBits(5);
    }
}