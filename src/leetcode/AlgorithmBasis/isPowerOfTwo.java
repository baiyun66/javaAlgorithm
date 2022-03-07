package leetcode.AlgorithmBasis;
import java.util.*;

public class isPowerOfTwo {
    public static void main(String[] args){

        int n = 1112574;
        Solution_ispt solution_c = new Solution_ispt();
        System.out.println(solution_c.isPowerOfTwo(n));

    }
}



class Solution_ispt {

    public boolean isPowerOfTwo(int n) {

        return n>0 && (n & n-1) == 0;
    }

}