// Node class
class Node { // 2pt
    int data;
    Node left, right;

    public Node(int data) {// 3pt
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// BinarySearchTree class
class BinarySearchTree {// 2pt
    Node root;

    public BinarySearchTree() {// 3pt
        this.root = null;
    }

    // Method to insert a new value into the tree 15pt
    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // Method to perform in-order traversal 10pt
    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    // Wrapper method for insertion
    public void add(int value) {
        this.root = insert(this.root, value);
    }

    // Wrapper method for in-order traversal
    public void printInOrder() {
        inOrderTraversal(this.root);
        System.out.println();
    }

    // Main class to test the implementation
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // Inserting values into the BST
        bst.add(10);
        bst.add(5);
        bst.add(20);
        bst.add(3);
        bst.add(7);
        bst.add(15);
        // Printing the in-order traversal
        System.out.println("In-order traversal of the BST:");
        bst.printInOrder();
    }
}

//e. Insert Method:

//Time Complexity: O(h), where h is the height of the tree. For a balanced tree, this is O(log n); for a skewed tree, it is O(n).//5pt
//f. Recursively visits the left subtree, prints the current node, and then visits the right subtree.
//Time Complexity: O(n), where n is the number of nodes in the tree. //5pt