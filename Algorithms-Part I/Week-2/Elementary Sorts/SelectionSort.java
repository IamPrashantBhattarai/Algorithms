public class SelectionSort {

    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++){
            int min = i;
            for( int j = i+1; j < N; j++){
                if (less(a[j] , a[min])){
                    min = j;
                }
                exch(a, i, min);  // Swap the found minimum element with the current element
            }
        }
    }

    private static boolean less( Comparable v, Comparable w) {
        return v.compareTo(w) < 0; // Return true if v is less than w
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

     // Main method to test the selection sort
     public static void main(String[] args) {
        String[] array1 = {"z", "e", "a", "b", "y", "x", "c"};
        String[] array2 = {"2", "1", "5", "7", "4"};

        sort(array1); // Sort the array
        for (String s : array1) {
            System.out.print(s + " "); // Print the sorted array
        }

        sort(array2); // Sort the array
        for (String s : array2) {
            System.out.print(s+ " "); // Print the sorted array
        }
    }

}