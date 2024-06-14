import java.util.Random; 

public class StdRandom {
    private static final Random random = new Random();

    public static int uniform(int n) {
        return random.nextInt(n);
    }

    //Method to shuffle the array
    public static void shuffle(Object[] a){
        int N = a.length;
        for (int i = 0; i < N; i++){
            int r = uniform(i + 1);
            exch(a ,i ,r);
        }
    }

    // Helper method to exchange two elements in the array
    private static void exch(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

     // Main method to test the shuffle functionality
     public static void main(String[] args) {
        Integer[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Original array:");
        printArray(testArray);

        shuffle(testArray);

        System.out.println("Shuffled array:");
        printArray(testArray);
    }

    // Method to print the array
    private static void printArray(Object[] a) {
        for (Object item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    
}
