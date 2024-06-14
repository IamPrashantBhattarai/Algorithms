public class ShellSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        //Compute the largest h value in the 3x+1 sequence that is less than N/3
        while (h < N/3 ) {
            h = 3*h + 1; 
        }
        //h-sort the array
        while ( h >= 1) {
            // Perform the insertion sort with the gap h
            for (int i = h; i < N; i++){
                for (int j = i; j >= h && less(a[j], a[j-h]); j-=h) {
                    exch(a, j, j-h);
                }
            }
            h = h/3;
        }
    }
    // Helper method to compare two elements
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // Helper method to exchange two elements in the array
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    // Method to print the array
    private static void printArray(Comparable[] a) {
        for (Comparable item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test array of integers
        Integer[] testArray = {7, 2, 9, 1, 5, 8, 6, 3, 4, 0};

        System.out.println("Original array:");
        printArray(testArray);

        sort(testArray);

        System.out.println("Sorted array:");
        printArray(testArray);
    }
}

    
    

