package leetcode.codeLisit200.doubleindex;

public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        int len = (int)Math.pow(c,0.5);
        int l = 0;
        int r = len;

        while (l<=r){
            if(c-l*l == r*r){
                return true;
            }else if(c-l*l < r*r){
                r--;
            }else {
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int c = 3;

        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        System.out.println(judgeSquareSum.judgeSquareSum(c));
    }
}
