package structpractice.search;

import java.util.ArrayList;
import java.util.List;

public class insert_search {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,5,6,7,8,9,10,11,18,18,18,21,22};
        Search_insert search = new Search_insert();
        List<Integer> ans = new ArrayList<>();
        int key = 10000;
        search.search(key,nums,ans,0,nums.length-1);

        System.out.println(ans.toString());
    }
}

class Search_insert{
    public void search(int key,int[] nums,List<Integer> ans,int l,int r){
        // 二分
        //int mid = l+ (r-l)/2;

        // 插值查找

        if(r<=l){
            return;
        }
        int mid = l+ (r-l)*(key-l)/(nums[r]-nums[l]);
        if(mid>r){
            return;
        }
        System.out.println(mid);
        if(nums[mid]==key){
            ans.add(mid);
            int k = mid-1;
            while (k>0){
                if(nums[k]==key){
                    ans.add(k);
                    k--;
                }else {
                    break;
                }
            }
            k = mid+1;
            while (k<nums.length){
                if(nums[k]==key){
                    ans.add(k);
                    k++;
                }else {
                    break;
                }
            }
            return;
        }else if(nums[mid]>key){
            search(key,nums,ans,l,mid-1);
        }else {
            search(key,nums,ans,mid+1,r);
        }



    }
}