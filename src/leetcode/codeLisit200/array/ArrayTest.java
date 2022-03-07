package leetcode.codeLisit200.array;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Collections;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();

//        int [] nums = {0,0,1,0,0};

//        arrayTest.printNums(nums);
//        arrayTest.moveZeroes2(nums);
//        arrayTest.printNums(nums);


//        int[][] matrix= {{1,2,3},{4,5,6}};
//        arrayTest.printNums(matrix);
//        arrayTest.printNums(arrayTest.matrixReshape(matrix,3,2));

//        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        int target = 5;
//        System.out.printf("%b", arrayTest.searchMatrix(matrix, target));

//        int[][] matrix = {{-5,-4}, {-5,-4}};
//        int[][] matrix =   {{1,5,9},{10,11,13},{12,13,15}};
//        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
//        int target = 2;
//        System.out.println(arrayTest.kthSmallest(matrix,target));


        int [] nums = {1,5,3,2,2,7,6,4,8,9};
        int [] ans = arrayTest.findErrorNums1(nums);
        System.out.printf("%d %d",ans[0],ans[1]);
    }

    public void moveZeroes(int[] nums) {
        int t = 0;
        int i = 0;
        int k = 0;
        while (i < nums.length && k < nums.length - 1) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
                k++;
                printNums(nums);
            } else {
                i++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int l = 0;
        int r = 0;
        int t = 0;
        while (r < nums.length) {

            if (nums[r] != 0) {
                t = nums[r];
                nums[r] = nums[l];
                nums[l] = t;
                l++;
            }
            r++;


        }
    }

    public void printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);

        }
        System.out.println();
    }

    public void printNums(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.printf("%d ", nums[i][j]);

            }
            System.out.println();
        }
        System.out.println();
    }


    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int h = mat.length;
        int w = mat[0].length;
        if (h * w != r * c) {
            return mat;
        }
        int[][] newMat = new int[r][c];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
//                System.out.printf("%d  %d\n", (i * w + j) / c, (i * w + j) % c);
                newMat[(i * w + j) / c][(i * w + j) % c] = mat[i][j];
            }
        }
        return newMat;

    }


    public int findMaxConsecutiveOnes(int[] nums) {
        int temp = nums[0];
        int maxLen = 0;
        int tempLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == temp) {
                tempLen++;
            } else {
                maxLen = Math.max(maxLen, tempLen);
                tempLen = 1;
                temp = nums[i];
            }
        }

        return maxLen;

    }

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        int mid = (left+right)/2;
        while (left<right){
            mid  = left+(right-left)/2;
            if(isKInRight(matrix,mid,n,k)){
                left=mid+1;
            }else {
                right = mid;
            }
        }
        System.out.printf("%d %d\n", left,right);
        return left;
    }

    public boolean isKInRight(int[][] matrix,int mid,int n,int k){
        int nums = 0;
        int x = 0;
        int y = n-1;
        while (y>=0 && x<n){
            if(matrix[y][x]>mid){
                y--;
                nums+=x;
//                System.out.printf("%d\n", nums);
            }else {
                x++;

            }
            if(x>=n){
                nums+=x*(y+1);
            }
        }
        return nums<k;

    }

    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        int flag = 1;
        if(nums[0]!=1){
            ans[1] = 1;
            flag = 0;
        }
        for(int i = 1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                ans[0] = nums[i];
            }
            if (flag==1 && nums[i]!=i+1){
                ans[1]=i+1;
                flag = 0;
            }
            if(flag==0 && ans[1]==nums[i]){
                 ans[1] = i+1;
            }
        }
        return ans;
    }


    public int[] findErrorNums1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
