public class FixedSizePriorityQueue<T extends Comparable<T>> {
    private Object[] array;
    private int size;
    private int capacity;

    public FixedSizePriorityQueue(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.size = 0;
    }

    public void add(T addedValue) {
        if (size >= capacity) { // if queue is full
            return; 
        }

        int i;
        for (i = size - 1; i >= 0; i--) {
            T current = (T) array[i];
            if (addedValue.compareTo(current) >= 0) {
                break;
            }
            array[i + 1] = current;
        }
        array[i + 1] = addedValue;
        size++;
    }

    public T removeMin() {
        if (size == 0) {
            return null; // if queue is empty
        }
        T minValue = (T) array[0];
        for (int i = 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        return minValue;
    }

    public int size() {
        return size;
    }

    public void printPriorityQueue() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FixedSizePriorityQueue<Integer> pq = new FixedSizePriorityQueue<>(10);
        
        pq.add(5);
        pq.add(4);
        pq.add(6);
        pq.add(7);
        pq.add(8);
        pq.add(9);

        System.out.println("Initial Priority Queue:");
        pq.printPriorityQueue();

        System.out.println("Removed Min: " + pq.removeMin());
        System.out.println("Priority Queue after removing min:");
        pq.printPriorityQueue();

        System.out.println("Size of Priority Queue: " + pq.size());
    }
}
