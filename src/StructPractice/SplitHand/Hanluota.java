package structpractice.SplitHand;


import javax.xml.soap.Node;
import java.util.*;

public class Hanluota {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        A.add(3);

//        A.add(1);

        solution.hanota();

//        solution.print(A,B,C);

    }
}
class Solution {
    List <Integer> A = new ArrayList<>();
    List<Integer> B = new ArrayList<>();
    List<Integer> C = new ArrayList<>();


    int num = 0;
    public void hanota() {
        A.add(3);
        A.add(2);
        A.add(1);
        move(A.size(), A, B, C);
    }

    private void move(int n, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (n == 0) return;
        move(n - 1, a, c, b);
        c.add(a.get(a.size() - 1));
        a.remove(a.size() - 1);
        num++;
        print();
        move(n - 1, b, a, c);
        Queue<Node> queue = new ArrayDeque<>();
//        queue.
    }


    public void print(){
        System.out.printf("第：%d次\n",num);
        System.out.print("[");
        for(int i =0;i<A.size();i++){
            System.out.printf("%d,",A.get(i));
        }
        System.out.println("]");

        System.out.print("[");
        for(int i =0;i<B.size();i++){
            System.out.printf("%d,",B.get(i));
        }
        System.out.println("]");

        System.out.print("[");
        for(int i =0;i<C.size();i++){
            System.out.printf("%d,",C.get(i));
        }
        System.out.println("]");
    }
}