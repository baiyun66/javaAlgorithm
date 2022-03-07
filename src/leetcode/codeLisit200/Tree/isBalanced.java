package leetcode.codeLisit200.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class  isBalanced{

    public static void main(String[] args) {
        String[] array = {"3", "9", "20", "#", "#", "15", "7","9","10","#","#","85"};
        binaryTree binaryTree = new binaryTree();
        binaryTree.buildTree(array);
        binaryTree.preLoop();
        System.out.printf("TreeHigh: %d ",binaryTree.treeHigh());
    }
}
