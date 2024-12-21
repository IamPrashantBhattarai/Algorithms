public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;  // Binary heap using 1-based indexing
    private int N;     // No of elements in the priority queue

    // Constructor to initialize the priority queue with a fixed capacity
    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1]; // Use 1-based indexing
        N = 0; // Initially, the priority queue is empty
    }

    //Check if PQ is empty or not
    public boolean isEmpty(){
        return N == 0;
    }

    //Insert a key into the priority queue
    public void insert(Key key) {
        pq[++N] = key;    // Adding the key at the last
        swim(N);          // Restore heap order by swimming up
    }

    //Delete and return the max key
    public Key delMax() {
        Key max = pq[1];   // The root of the heap (index 1) is the max
        exch(1, N--);      // Exchange root with the last element
        sink(1);           // Restore heap order by sinking down
        pq[N+1] = null;    // Avoid loitering
        return max;
    }

    // Helper function to maintain heap order by swimming up
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)){
            exch(k, k / 2);
            k = k / 2;
        }
    }

    // Helper function to maintain heap order by sinking down
    private void sink(int k) {
        while (2 * k <= N) { // While there's at least one child
            int j = 2 * k;   // Left child index
            if (j < N && less(j, j + 1)) { // Choose larger child
                j++;
            }
            if (!less(k, j)) { // If the parent is not less than the larger child
                break;
            }
            exch(k, j);       // Exchange parent with the larger child
            k = j;            // Move down to the child index
        }
    }

    //Helper function to compare both elements
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    //Helper function to exchange the elements in the array
    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}

