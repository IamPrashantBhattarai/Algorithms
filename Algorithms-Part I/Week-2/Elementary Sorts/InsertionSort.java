public class InsertionSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++){
            for (int j =i; j > 0; j--){
                if (less((a[j]) , a[j-1])) {
                    exch(a , j , j-1);
                }
                else break;
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main (String[] args) {
        Integer[] array = {5, 2, 4, 6, 1, 3};
        InsertionSort.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    
}
