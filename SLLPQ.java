// Node class 2pt
class Node {
    int data;
    Node next;

    public Node(int data) {// 3pt
        this.data = data;
        this.next = null;
    }
}

// SinglyLinkedList class 2pt
class SinglyLinkedList {
    Node head;

    public SinglyLinkedList() {// 3pt
        this.head = null;
    }
}

// SLLPQ class (Singly Linked List Priority Queue)
class SLLPQ { // 2pt
    SinglyLinkedList list;

    public SLLPQ() {// 3pt
        this.list = new SinglyLinkedList();
    }
    // Method to insert a node with the given value at the head 10pt

    public Node insert(int addedValue) {
        Node newNode = new Node(addedValue);
        newNode.next = list.head;
        list.head = newNode;
        return list.head;
    }

    // Method to remove the element with the highest priority (minimum value) 10pt
    public int removeMin() {
        if (list.head == null) {
            throw new IllegalStateException("Priority queue is empty.");
        }
        Node temp = list.head;
        Node prev = null;
        Node minNode = list.head;
        Node minPrev = null;
        while (temp != null) {
            if (temp.data < minNode.data) {
                minNode = temp;
                minPrev = prev;
            }
            prev = temp;
            temp = temp.next;
        }
        if (minPrev == null) {
            list.head = list.head.next;
        } else {
            minPrev.next = minNode.next;
        }
        return minNode.data;
    }

    public int Min() {// 10pt
        if (list.head == null) {
            throw new IllegalStateException("Priority queue is empty.");
        }
        Node temp = list.head;
        int minValue = temp.data;
        while (temp != null) {
            if (temp.data < minValue) {
                minValue = temp.data;
            }
            temp = temp.next;
        }
        return minValue;
    }

    // Main class to test the implementation
    public static void main(String[] args) {
        SLLPQ pq = new SLLPQ();
        pq.insert(1);
        pq.insert(3);
        pq.insert(5);
        pq.insert(2);
        System.out.println("Priority Queue after inserts: ");

        Node temp = pq.list.head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
        pq.insert(6);
        System.out.println("Priority Queue after inserting 6: ");
        temp = pq.list.head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("Min value: " + pq.Min());
        System.out.println("Removed min value: " + pq.removeMin());
        System.out.println("Priority Queue after removeMin: ");
        temp = pq.list.head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}


// c. Insert (Node insert(int addedValue)): Complexity: O(1) (Constant time) because we
// are always inserting the node at the head of the list.
// f. RemoveMin (int removeMin()): Complexity: O(n) (Linear time) because we must
// traverse the entire list to find the node with the minimum value. //2.5 pt

// Min (int Min()): Complexity: O(n) (Linear time) because we traverse the entire list to find
// the node with the minimum value. //2.5 pt