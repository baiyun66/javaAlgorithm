package leetcode.AlgorithmBasis;

import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;
import java.util.TreeMap;

public class doublePointer {
    public static void main(String[] args){
//        int[] nums = {0,0,0,1,2,3,4};
//        Solution3 solution = new Solution3();
//        solution.moveZeroes2(nums);


//        int[] nums = {1,2,3 };
//        int target =4 ;
//        Solution3 solution = new Solution3();
//        int[]a = solution.twoSum2(nums,target);
//        System.out.println(Arrays.toString(a));


//        char[] s = {'h','e','l','l','o'};
//        Solution3 solution = new Solution3();
//        solution.reverseString(s);
//Let's take LeetCode contest
        String s = "I love you";
        Solution3 solution = new Solution3();
        String a = solution.reverseWords2(s);
        System.out.println(a);
    }
}


class Solution3 {
    public void moveZeroes(int[] nums) {
        int r = nums.length;
        int index = 0;
        while (index<r){
            if(nums[index]==0){
                for(int j = index;j<r-1;j++){
                    int p = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = p;
                }
                r--;
            }
            if(nums[index]!=0){
                index+=1;
            }
            System.out.println(index);
        }
        System.out.println(Arrays.toString(nums));

    }

    public void moveZeroes2(int[] nums) {
        int r = 0;
        int l = 0;
        int len = nums.length;
        while (r<len){
            if(nums[r]!=0){
                int p = nums[r];
                nums[r] = nums[l];
                nums[l] = p;
                l++;
            }
            r++;
            System.out.println(Arrays.toString(nums));
        }


    }

    // 1,2,3                ,4,4,9,56,90
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=1;
        int index = r;
        while (index<numbers.length){
            if(target-numbers[l]>numbers[index] && index<numbers.length-1){
                index++;
            }else if(target-numbers[l]==numbers[index]){
                return new int[]{l+1,index+1};
//                break;
            }else {
                r=index-1;
                l++;
                index=l+1;
                System.out.print(l);
                System.out.print(r);
                System.out.println();
            }

        }
        return new int[]{l+1,r+1};

    }

    public int[] twoSum2(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;

        while (l<r){
            if(target-numbers[l]>numbers[r]){
               l++;
            }else if(target-numbers[l]==numbers[r]){
                return new int[]{l+1,r+1};
            }else {
             r--;
            }
        }
        return new int[]{l+1,r+1};

    }

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length-1;
        while (l<r){
            char p = s[l];
            s[l] = s[r];
            s[r] = p;
            l++;
            r--;
        }
        System.out.println(s);

    }
    public void reverseString2(char[] s,int l,int r) {
        while (l<r){
            char p = s[l];
            s[l] = s[r];
            s[r] = p;
            l++;
            r--;
        }
//        System.out.println(s);

    }

    public String reverseWords(String s) {
        int l = 0;
        int r = 0;
        Boolean start = true;
        char [] w = s.toCharArray();
        int index = 0;
        while (index<=s.length()-1){
            if(w[index]==' ' ){
                if(start)
                {
                    l = r;
                    start = false;
                }else{
                    l = r+2;
                }
                r = index-1;
               reverseString2(w,l,r);
            }
            if(index==s.length()-1)
            {
                if(r==0)
                {
                    l = r;
                    start = false;
                }else{
                    l = r+2;
                }
                r = index;
                reverseString2(w,l,r);
            }
            index++;
            System.out.println(w);
        }
//        System.out.println(w);

        String p="";
        for(int i=0;i<w.length;i++){
            p+=w[i];
        }

        return p;

    }

    public String reverseWords2(String s) {
        int index = 0;
        int len = s.length();
        StringBuffer stringBuffer = new StringBuffer();
        while (index<len){
            int start = index;
            while (s.charAt(index)!=' ' && index<len-1){
                index++;
            }
            if(index==len-1){
                index+=1;
            }
            for(int p = start;p<index;p++){
                stringBuffer.append(s.charAt(index-1-p+start));
            }
            if(index!=len){
                stringBuffer.append(' ');
            }
            System.out.println(stringBuffer.toString());
            index++;

        }
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();

    }

}