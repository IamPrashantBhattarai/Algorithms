public class QuickFindUF {
    private int[] id;

    // Constructor to initialize N sites with integers 0 to N-1
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // Check if p and q are connected (i.e., have the same id)
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // Connect p and q by changing all entries with id[p] to id[q]
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    // Main method for testing the QuickFindUF class
    public static void main(String[] args) {
        QuickFindUF uf = new QuickFindUF(10); // create a QuickFindUF object with 10 sites
        
        // Test the union method
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        
        // Test the connected method
        System.out.println("1 and 2 connected: " + uf.connected(1, 2)); // true
        System.out.println("4 and 8 connected: " + uf.connected(4, 8)); // true
        System.out.println("5 and 0 connected: " + uf.connected(5, 0)); // false
        
        // Additional unions and connectivity checks
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        
        System.out.println("0 and 7 connected: " + uf.connected(0, 7)); // true
        System.out.println("8 and 9 connected: " + uf.connected(8, 9)); // true
    }
}
