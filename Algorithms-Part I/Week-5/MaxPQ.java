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

    
}
