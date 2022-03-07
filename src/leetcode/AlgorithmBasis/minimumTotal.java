package leetcode.AlgorithmBasis;
import java.util.*;

public class minimumTotal {
    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> x = new ArrayList();
        x.add(2);
        triangle.add(x);
       x = new ArrayList();
        x.add(3);
        x.add(4);
        triangle.add(x);
      x = new ArrayList();
        x.add(6);
        x.add(5);
        x.add(7);
        triangle.add(x);
        x = new ArrayList();
        x.add(4);
        x.add(1);
        x.add(8);
        x.add(3);
        triangle.add(x);

        for(int i=0;i<triangle.size();i++){
            System.out.println(triangle.get(i).toString());
        }
        Solution_mini solution_c = new Solution_mini();
        System.out.println(solution_c.minimumTotal(triangle));

    }
}



class Solution_mini {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size==1){
            return triangle.get(0).get(0);
        }
        int index_len = 0;
        int[] mini = new int[size];
        mini[0] = triangle.get(0).get(0);
        int [] index_array;
        for(int index = 1;index<size;index++){
            index_len = triangle.get(index).size();
            index_array = new int[index_len];
            index_array[0] = triangle.get(index).get(0)+mini[0];
            for(int i = 1;i< index_len-1;i++){
                   index_array[i] = triangle.get(index).get(i)+Math.min(mini[i], mini[i-1]);
            }
            index_array[index_len-1] = triangle.get(index).get(index_len-1)+ mini[index_len-2];
            mini = index_array;
        }
        int min = mini[0];
        for(int i = 1;i<mini.length;i++){
            min = Math.min(min,mini[i]);
        }
        return min;
    }

    public void out(int [] x){
//        for(int i= 0;i<x.size();i++){
//            System.out.print(x.get(i));
//            System.out.print(",");
//
//        }
        for(int i= 0;i<x.length;i++){
            System.out.print(x[i]);
            System.out.print(",");
        }
        System.out.println("");
    }

}