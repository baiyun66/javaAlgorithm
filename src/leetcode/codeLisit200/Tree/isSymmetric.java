package leetcode.codeLisit200.Tree;


public class  isSymmetric{

    public static void main(String[] args) {
        String[] array = {"1", "2", "2", "3", "4", "3", "4"};
        binaryTree binaryTree = new binaryTree();
        binaryTree.buildTree(array);
        binaryTree.preLoop();
        System.out.printf("isSymmetric: %b ",binaryTree.isSymmetric());

        boolean isS = binaryTree.isSymmetric2(binaryTree.root.getLeft(),binaryTree.root.getRight());
        System.out.printf("isSymmetric: %b ",isS);
    }
}
