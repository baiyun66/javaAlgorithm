package structpractice.sort;

import java.util.Arrays;

import static java.util.Arrays.*;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561,-1};
        System.out.println(Arrays.toString(stream(arr).sorted().toArray()));
        arr = new int[]{-9, 78, 0, 23, -567, 70, -1, 900, 4561,-1};



        System.out.println(Arrays.toString(arr));
        m_sort sort_ = new m_sort();
        sort_.sort_(arr,0,arr.length-1);

    }
}

class m_sort{
    public  void sort_(int[] arr,int left,int right){
        int mid  = (left+right)/2;
        System.out.println(mid);
        if(left < mid ) {
            sort_(arr, left, mid);
        }
        if(right > mid+1){
            sort_(arr,mid+1,right);
        }
        merge(arr,left,mid,right);
    }
    public void  merge(int[] arr,int left,int mid,int right){
        int i = left;
        int j = mid+1;
        int[ ]temp = new int[right-left+1];
        int t = 0;
        while (i<=mid && j<=right){
            if(arr[i]<arr[j]){
                temp[t] = arr[i];
                i++;
            }else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        while (i<=mid){
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j<=right){
            temp[t] = arr[j];
            j++;
            t++;
        }
        int k = 0;
        while (k<temp.length){
            arr[left+k] = temp[k];
            k++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
