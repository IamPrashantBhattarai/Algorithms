public class MergeSort {

    //Merge function
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, mid);

        //Copying to the auxiliary array
        for ( int k= lo; k <= mid; k++) {
            aux[k] = a[k];
        }

        //Merge back to a[]
        int i = lo, j = mid+1;
        for  (int k = lo; k <= hi; k++){
            if (i >  mid)  a[k] = aux[j++];
            else if (j > hi)  a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else  a[k] = aux[i++];
        }     

        assert isSorted(a, lo, hi);  
    } //postcondition: a[lo....hi] sorted

        //Recursive sort function
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1 , hi);
        merge(a, aux, lo, mid, hi);
    }

        //public sort function
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a , aux, 0, a.length -1);
    }

    //Helper function for less
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //Helper function to find if the array is sorted or not
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++){
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    // Main function to test the sort implementation
    public static void main(String[] args) {
        // Sample array of integers
        Integer[] array = {34, 7, 23, 32, 5, 62};
        
        // Print array before sorting
        System.out.println("Before sorting:");
        printArray(array);

        // Sort the array
        MergeSort.sort(array);

        // Print array after sorting
        System.out.println("After sorting:");
        printArray(array);
    }

    // Utility function to print an array
    private static void printArray(Comparable[] array) {
        for (Comparable item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}

    

