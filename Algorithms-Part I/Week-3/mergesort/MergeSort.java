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

        assert isSorted(a, lo, hi);   //postcondition: a[lo....hi] sorted

        //Recursive sort function
        private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid+1 , hi);
            merge(a, aux, lo, mid, hi);

        }

    }

    
}
