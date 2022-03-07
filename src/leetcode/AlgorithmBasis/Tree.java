package leetcode.AlgorithmBasis;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    public static void main(String[] args){
//        char [] node_list= {2,1,'#',4,'#','#',3,'#',7,'#','#'};
//        TreeFun treeFun = new TreeFun();
//        TreeNode tree = treeFun.buildTree(node_list);
//        treeFun.printTree(tree);


        char [] node_list= {1,2,4,'#','#',5,'#','#',3,6,'#','#',7,'#','#'};
        TreeFun treeFun = new TreeFun();
        TreeNode tree = treeFun.buildTree(node_list);
        treeFun.printTree(tree);
        treeFun.connect(tree);



    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }

 }

 class TreeFun{
    int i =0;
    public TreeNode buildTree(char[] node_list){
        if(node_list[i]=='#'){
            return null;
        }
        TreeNode head = new TreeNode(node_list[i]);
        if(i<node_list.length-1){
            i++;
            head.left = buildTree(node_list);
        }
        if(i<node_list.length-1){
            i++;
            head.right = buildTree(node_list);
        }
        return head;
    }
     public void printTree(TreeNode head){
         if(head!=null){
             System.out.println(head.val);
         }else{
             return;
         }
         printTree(head.left);
         printTree(head.right);
     }

     public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
         if(root1==null && root2==null){
             return null;
         }
         if(root1==null){
             return root2;
         }
         if(root2==null){
             return root1;
         }
         TreeNode head = new TreeNode(root1.val+root2.val);
         head.left = mergeTrees(root1.left,root2.left);
         head.right = mergeTrees(root2.right,root1.right);
         return head;
     }
     public TreeNode connect(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<TreeNode>();
         if(root==null)
             return null;
         queue.add(root);
         while (!queue.isEmpty()){
             int len = queue.size();
             TreeNode node;
             for(int i =0;i<len;i++){
                  node = queue.poll();
                 if(node.left!=null)
                 queue.add(node.left);
                 if(node.right!=null)
                 queue.add(node.right);
                 if(i<len-1)
                 {
                     node.next = queue.peek();
                 }else {
                     node.next =null;
                 }
             }
         }
         return root;
     }
 }