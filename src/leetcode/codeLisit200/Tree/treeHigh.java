package leetcode.codeLisit200.Tree;

import java.util.*;

public class treeHigh {

    public static void main(String[] args) {
        String[] array = {"3", "9", "20", "#", "#", "15", "7"};
        binaryTree binaryTree = new binaryTree();
        binaryTree.buildTree(array);
        binaryTree.preLoop();
        System.out.printf("TreeHigh: %d ", binaryTree.treeHigh());

        System.out.printf("isBalanced: %b ", binaryTree.isBalanced());
        System.out.println();

         binaryTree.invertTree();
         binaryTree.preLoop();
    }
}

/*
二叉树的数组存储
求解二叉树的高度
 */
class binaryTree {
    Node root;

    public void buildTree(String[] array) {
        if (array.length == 0) {
            System.out.println("为空树！");
            return;
        }
        root = new Node(array[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node p;
        int i = 1;
        while (queue.size() > 0 && i < array.length) {
            int size = queue.size();
            while (size >= 0 && i < array.length) {
                p = queue.poll();

                Node left = new Node(array[i]);
                if (array[i].equals("#")) {
                    left = null;
                }
                if (p != null) {
                    p.setLeft(left);
                }
                if (left != null) {
                    queue.add(left);
                }
                i += 1;
                if (i < array.length) {
                    Node right = new Node(array[i]);
                    if (array[i].equals("#")) {
                        right = null;
                    }
                    if (p != null) {
                        p.setRight(right);
                    }
                    if (right != null) {
                        queue.add(right);
                    }
                }
                i += 1;
                size--;
            }
        }
    }

    public void preLoop() {
        if (root == null) {
            System.out.println("为空树！");
        } else {
            root.preLoop();
        }
    }

    public void infixLoop() {
        if (root == null) {
            System.out.println("为空树！");
        } else {
            root.infixLoop();
        }
    }

    public void postLoop() {
        if (root == null) {
            System.out.println("为空树！");
        } else {
            root.postLoop();
        }
    }

    public Node preSearch(String data) {
        if (root == null) {
            System.out.println("为空树！");
            return null;
        } else {
            return root.preSearch(data);
        }
    }

    public void preDelete(String data) {
        if (root.getData().equals(data)) {
            root = null;
        } else {
            root.preDelete(data);
        }
    }

    public int treeHigh() {
        if (root == null) {
            return 0;
        } else {
            return root.treeHigh();
        }
    }

    public Boolean isBalanced() {
        if (root == null) {
            return true;
        } else {
            int x = root.isBalanced();
            System.out.printf("x %d:",x);
           return x>=0;
        }
    }

    public void invertTree(){
        if(root==null){
            return;
        }

        root.invertTree();
    }


    public boolean isSymmetric() {
        if(root==null){
            return false;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size()>0){
            int s  = queue.size();
            List<String> list = new ArrayList<>();
            List<Boolean> isexsit = new ArrayList<>();
            for (int i = 0;i<s;i++){
                Node node = queue.poll();
                list.add(node.getData());
                if(node.getLeft()!=null){isexsit.add(true);queue.add(node.getLeft());}else{isexsit.add(false);}
                if(node.getRight()!=null){isexsit.add(true);queue.add(node.getRight());}else{isexsit.add(false);}
            }
            System.out.println(isexsit.toString());
            System.out.println(list.toString());

            for (int i = 0;i<isexsit.size()/2;i++){
                if(!isexsit.get(i) == isexsit.get(isexsit.size()-i-1)){
                    return false;
                }
            }
            for (int i = 0;i<list.size()/2;i++){
                if(!list.get(i).equals(list.get(list.size()-i-1))){
                    return false;
                }
            }

        }
        return true;
    }



    public boolean isSymmetric2(Node root1,Node root2) {
        if(root1==null && root2==null){
            return true;
        } else if(root1 == null || root2==null){
            return false;
        }else if(!root1.getData().equals(root2.getData())){
            return false;
        }
        return isSymmetric2(root1.getLeft(),root2.getRight()) && isSymmetric2(root1.getRight(),root2.getLeft());
    }



    // 小偷
//    public int rob() {
//        if(root==null){
//            return 0;
//        }
//        return Math.max(rob2(root,true),rob2(root,false));
//    }
//
//    public int rob2(Node root,Boolean is_rob) {
//        int sum = 0;
//        if(is_rob){
//            sum+=Integer.parseInt(root.getData());
//            System.out.printf("sum:%d\n",sum);
//            if(root.getLeft()!=null){
//                sum += rob2(root.getLeft(),false);
//            }
//            if(root.getRight()!=null){
//                sum += rob2(root.getRight(),false);
//            }
//        }else {
//            if(root.getLeft()!=null){
//                sum += Math.max(rob2(root.getLeft(),false),rob2(root.getLeft(),true));
//            }
//            if(root.getRight()!=null){
//                sum += Math.max(rob2(root.getRight(),false),rob2(root.getRight(),true));
//            }
//        }
//        return sum;
//    }
    int a = Integer.MAX_VALUE;
    long b = a+1;
    int c = (int) b;
    HashMap<Node,Integer> yes = new HashMap<>();
    HashMap<Node,Integer> no = new HashMap<>();
    public int rob() {
        if(root==null){
            return 0;
        }
        rob2(root);
        return Math.max(yes.get(root),no.get(root));
    }

    public void rob2(Node root) {
        if(root == null){
            return ;
        }
        rob2(root.getLeft());
        rob2(root.getRight());
        yes.put(root,Integer.parseInt(root.getData())+ no.getOrDefault(root.getLeft(),0) + no.getOrDefault(root.getRight(),0));
        no.put(root,Math.max(no.getOrDefault(root.getLeft(),0),yes.getOrDefault(root.getLeft(),0))+
                        Math.max(no.getOrDefault(root.getRight(),0),yes.getOrDefault(root.getRight(),0))
                );
    }
}

class Node {
    private final String data;
    private Node left = null;
    private Node right;

    {
        right = null;
    }

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft(){
        return left;
    }
    public Node getRight(){
        return right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public void preLoop() {
        System.out.println(this);
        if (left != null)
            left.preLoop();
        if (right != null)
            right.preLoop();
    }

    public void infixLoop() {

        if (left != null)
            left.preLoop();
        System.out.println(this);
        if (right != null)
            right.preLoop();
    }

    public void postLoop() {
        if (left != null)
            left.preLoop();
        if (right != null)
            right.preLoop();
        System.out.println(this);
    }


    public Node preSearch(String data) {
        if (this.data.equals(data)) {
            return this;
        }
        Node ans = null;
        if (left != null)
            ans = left.preSearch(data);

        if (ans != null) {
            return ans;
        }

        if (right != null)
            ans = right.preSearch(data);

        return ans;
    }

    public void preDelete(String data) {
        if (left != null) {
            if (left.getData().equals(data)) {
                left = null;
                return;
            } else {
                left.preDelete(data);
            }
        }

        if (right != null) {
            if (right.getData().equals(data)) {
                right = null;
            } else {
                right.preDelete(data);
            }
        }
    }

    public int treeHigh() {
        int rh = 1;
        int lh = 1;
        if (left != null) {
            lh += left.treeHigh();
        }
        if (right != null) {
            rh += right.treeHigh();
        }
        return Math.max(lh, rh);
    }

    public int isBalanced() {
        int rh = 1;
        int lh = 1;
        if (left != null) {
            int l = left.isBalanced();
            if (l == -1) {
                return -1;
            } else {
                lh += l;
            }
        }
        if (right != null) {
            int r = right.isBalanced();
            if (r == -1) {
                return -1;
            } else {
                rh += r;
            }
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh);

    }

    public void invertTree() {

        Node t;
        t = left;
        left = right;
        right  = t;

        if(left!=null){
            left.invertTree();
        }
        if(right!=null){
            right.invertTree();
        }

    }

}