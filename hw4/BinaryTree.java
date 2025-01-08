class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {

    public boolean isHeap(Node root) {
        if (root == null) {
            return true; // An empty tree is a heap
        }

        if ((root.left != null && root.left.data > root.data) ||
            (root.right != null && root.right.data > root.data)) {
            return false; // Heap property violated
        }

        return isHeap(root.left) && isHeap(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        BinaryTree bt = new BinaryTree();
        System.out.println(bt.isHeap(root));
    }
}
