package leetcode.codeLisit200.Tree;

import java.util.*;

public class rob {

    public static void main(String[] args) {
        
//        String [] array = {"79","99","77","#","#","#","69","#","60","53","#","73","11","#","#","#","62","27","62","#","#","98","50","#","#","90","48",
//                "82","#","#","#","55","64","#","#","73","56","6","47","#","93","#","#","75","44","30","82","#","#","#","#","#","#","57","36","89","42",
//                "#","#","76","10","#","#","#","#","#","32","4","18","#","#","1","7","#","#","42","64","#","#","39","76","#","#","6","#","66","8","96",
//                "91","38","38","#","#","#","#","74","42","#","#","#","10","40","5","#","#","#","#","28","8","24","47","#","#","#","17","36","50","19",
//                "63","33","89","#","#","#","#","#","#","#","#","94","72","#","#","79","25","#","#","51","#","70","84","43","#","64","35","#","#","#",
//                "#","40","78","#","#","35","42","98","96","#","#","82","26","#","#","#","#","48","91","#","#","35","93","86","42","#","#","#","#","0",
//                "61","#","#","67","#","53","48","#","#","82","30","#","97","#","#","#","1","#","#"}; //
        String[] array = {"1","3","1","1","1","#","5"};

//        3","2","3","#","3","#","1
        binaryTree binaryTree = new binaryTree();
        binaryTree.buildTree(array);
        binaryTree.preLoop();

        int sum = binaryTree.rob();
        System.out.printf("sum: %d\n",sum);

        Queue<Integer> stack = new ArrayDeque<>();

        Set<Integer> set = new HashSet<>();
        int x = Integer.MAX_VALUE;


        List<Integer> ans = new ArrayList<>();
        ans.add(1);

        Integer [] y = new Integer[ans.size()];
        ans.toArray(y);
        String b = "knkn";



        b.charAt(1);
        int z = (int)'5'-(int)'0';
        System.out.println(z);


    }




}
