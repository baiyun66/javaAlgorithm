package structpractice.sort;

import java.util.Arrays;

import static java.util.Arrays.*;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561,-1};
        System.out.println(Arrays.toString(stream(arr).sorted().toArray()));
         arr = new int[]{-9, 78, 0, 23, -567, 70, -1, 900, 4561,-1};
        q_sort sort_ = new q_sort();
        sort_.sort_(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }


}

class q_sort{
    public  void sort_(int[] arr, int left, int right){

        int l = left;
        int r = right;
        int flag  = arr[(left+right)/2];
        while (l<r){
            while (l<r && arr[l]<flag){
                l++;
            }
            while (l<r && arr[r]>flag){
                r--;
            }
            int p = arr[r];
            arr[r] = arr[l];
            arr[l] = p;

            if(arr[r] == flag){
                l+=1;
            }
            if(arr[l] == flag){
                r-=1;
            }

            if(l-1> left){
                sort_(arr,left,l-1);
            }
            if(l+1<right){
                sort_(arr,l+1,right);
            }
        }

    }
}
