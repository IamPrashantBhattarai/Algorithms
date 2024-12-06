public class ThreeWayQuickSort {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return; //Base case: array size 1 or empty

        int lt = lo, gt = hi;
        Comparable v = a[lo];  //Partitioning item
        int i = lo + 1;

        // Partitioning phase 
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);  // Move item smaller than pivot to the left
            else if (cmp > 0) exch(a, i, gt--); // // Move item larger than pivot to the right
            else i++;
        }
        // Recursively sort the partitions
        sort(a, lo, lt - 1); // Sort left part (less than pivot)
        sort(a, gt + 1, hi); // Sort right part (greater than pivot)
    }
    // Helper method to swap two elements in the array
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Main method to test the sorting algorithm
    public static void main(String[] args) {
        String[] testArray = {"banana", "apple", "orange", "apple", "kiwi", "banana", "banana", "orange"};
        ThreeWayQuickSort.sort(testArray);
        for (String item : testArray) {
            System.out.print(item + " ");
        }
    }
}
    
