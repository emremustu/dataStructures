class Node<E> {
    E data;

    Node<E> left;
    Node<E> right;

    public Node(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree<E> {
    Node<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public Node<E> find(Node<E> root, E value) {
        if (root == null) {
            return null;
        }
        if (root.data.equals(value)) {
            return root;
        }
        Node<E> leftResult = find(root.left, value);
        if (leftResult != null) {

            return leftResult;
        }
        return find(root.right, value);
    }

    public void insertLeft(Node<E> root, E value, E parentValue) {
        Node<E> parent = find(root, parentValue);

        if (parent == null) {
            System.out.println("Parent node with value " + parentValue + " not found");
            return;
        }
        if (parent.left != null) {
            System.out.println("Left child already exists for parent with value " + parentValue);
            return;
        }
        parent.left = new Node<>(value);
    }

    public void insertRight(Node<E> root, E value, E parentValue) {
        Node<E> parent = find(root, parentValue);

        if (parent == null) {
            System.out.println("Parent node with value " + parentValue + " not found");
            return;
        }
        if (parent.right != null) {
            System.out.println("Right child already exists for parent with value " + parentValue);
            return;
        }
        parent.right = new Node<>(value);

    }

    public void delete(Node<E> root, E value) {
        Node<E> nodeToDelete = find(root, value);
        if (nodeToDelete == null) {
            System.out.println("Node with value " + value + " not found.");
            return;
        }
        nodeToDelete.data = null;
        nodeToDelete.left = null;
        nodeToDelete.right = null;
    }

    public void inOrderTraversal(Node<E> root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        if (root.data != null) {
            System.out.print(root.data + " ");
        }
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Create the root node 10pt
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = new Node<>(40);
        // Add nodes to the tree
        tree.insertLeft(tree.root, 30, 40); // test insertleft 2 pt
        tree.insertRight(tree.root, 50, 40);// test insertright 2 pt
        tree.insertLeft(tree.root, 25, 30);
        tree.insertRight(tree.root, 35, 30);
        tree.insertLeft(tree.root, 45, 50);
        tree.insertRight(tree.root, 60, 50);

        // Print the tree structure
        System.out.println("Tree in-order traversal before deletion:");
        tree.inOrderTraversal(tree.root);

        System.out.println();
        // Test delete method 2pt
        System.out.println("\nDeleting node with value 50...");
        tree.delete(tree.root, 50); // deletion may differ, here we delete the node along with the children
        System.out.println("Tree in-order traversal after deletion:");
        tree.inOrderTraversal(tree.root);
    }
}
