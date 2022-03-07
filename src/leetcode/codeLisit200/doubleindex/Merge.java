package leetcode.codeLisit200.doubleindex;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int id1 = m-1;
        int id2 = n-1;
        int k = m+n-1;
        while (id1>=0 || id2>=0){
            if(id2 == -1 || (id1>-1&&nums1[id1]>=nums2[id2])){
                nums1[k] = nums1[id1];
                id1--;
                k--;
            }else{
                nums1[k] = nums2[id2];
                id2--;
                k--;
            }
        }

    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
//        int [] nums1 = {1};
//        int m = 1;
//        int[] nums2 = {0};
//        int n = 0;
        Merge merge = new Merge();
        merge.merge(nums1,m,nums2,n);

        for (int i = 0; i < n+m; i++) {
            System.out.printf("%d ",nums1[i]);
        }
    }
}
