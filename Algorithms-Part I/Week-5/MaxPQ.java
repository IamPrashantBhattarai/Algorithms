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

    
}
