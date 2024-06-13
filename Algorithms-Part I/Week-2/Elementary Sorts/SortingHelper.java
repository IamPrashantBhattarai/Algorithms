public class SortingHelper {

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {5, 4, 3, 2, 1};
        String[] array3 = {"apple", "banana", "cherry"};

        System.out.println("Array1 is sorted: " + isSorted(array1)); // should print true
        System.out.println("Array2 is sorted: " + isSorted(array2)); // should print false
        System.out.println("Array3 is sorted: " + isSorted(array3)); // should print true
    }
}
