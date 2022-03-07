package structpractice.tree;

public class newTree {
    public static void main(String[] args) {

        Node node1 = new Node(1, "张三");
        Node node2 = new Node(2, "里斯");
        Node node3 = new Node(3, "王二");
        Node node4 = new Node(4, "码字");

        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);


        binaryTree binaryTree = new binaryTree(node1);
        System.out.println("前序遍历");
        binaryTree.preLoop();
        System.out.println("中序遍历");
        binaryTree.infixLoop();
        System.out.println("后序遍历");
        binaryTree.postLoop();

        System.out.println("前序搜索");
        System.out.println(binaryTree.preSearch(2));
        binaryTree.preDelete(2);
        System.out.println(binaryTree.preSearch(2));
        binaryTree.preLoop();
    }


}

class binaryTree {
    Node root;

    public binaryTree(Node root) {
        this.root = root;
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

    public Node preSearch(int id) {
        if (root == null) {
            System.out.println("为空树！");
            return null;
        } else {
            return root.preSearch(id);
        }
    }

    public void preDelete(int id) {
        if (root.getId() == id) {
            root = null;
        } else {
            root.preDelete(id);
        }
    }


}

class Node {
    private final int id;
    private final String name;
    private Node left = null;
    private Node right;

    {
        right = null;
    }

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name=" + name +
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


    public Node preSearch(int id) {
        if (this.id == id) {
            return this;
        }
        Node ans = null;
        if (left != null)
            ans = left.preSearch(id);

        if (ans != null) {
            return ans;
        }

        if (right != null)
            ans = right.preSearch(id);

        return ans;
    }

    public void preDelete(int id) {
        if (left != null) {
            if (left.getId() == id) {
                left = null;
                return;
            } else {
                left.preDelete(id);
            }
        }

        if (right != null) {
            if (right.getId() == id) {
                right = null;
            } else {
                right.preDelete(id);
            }
        }
    }
}