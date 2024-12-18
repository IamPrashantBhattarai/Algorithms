public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;   // pq[i] = ith element on pq
    private int N;      // number of elements on pq

    // Constructor
    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        //here is some problem to be addressed
        N = 0;
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return N == 0;
    }

    // Insert a key into the priority queue
    public void insert(Key x) {
        pq[N++] = x;
    }

    // Delete and return the maximum key
    public Key delMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue underflow");
        }

        int max = 0;
        for (int i = 1; i < N; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        exch(max, N - 1);       // Swap the max item with the last item
        return pq[--N];         // Return the max item and decrement N
    }

    // Helper function: less comparison
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // Helper function: exchange elements
    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}

