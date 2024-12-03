import java.util.Arrays;
import java.util.Random;

public class quickSort {

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        Comparable pivot = a[0];
        
        while (true) {
            //find the item on the left to swap
            while (less(a[++i], pivot)) {
                if (i == hi) break;
            }
            //find item on the right to swap
            while (less(pivot, a[--j])) {
                if (j == lo) break;
            }
            //Check if the pointers cross
            if (i >= j) break;
            exch(a, i, j);  //Helps to swap out of place items
        }
        //Swap pivot with the partitioning element
        exch(a, lo, j);
        return j;  //Return the index of the pivot now in place 
        
    }

    //Sort method: Recursively sort the array
    public static void sort(Comparable a[]){
        StdRandom.shuffle(a);  //Shuffles for the performance guarantees
        sort(a , 0, a.length-1);  //Start sorting
    }

    private static void sort (Comparable a[], int lo, int hi) {
        if (hi <= lo) return; //Base case: Subarray is already being sorted 
        int j = partition(a, lo, hi); // partition around the pivot
        sort(a, lo, j - 1); // Sort the left part 
        sort(a, j + 1, hi); //Sort the right part
    }
    
    //Helper method to Check if one item is less than the other
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //Helper method : Swap two elements in the array
    private static void exch(Comparable a[], int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Main method for testing
    public static void main(String[] args) {
        Integer[] array = {7538,3875,282,9791,2947,6100,1313,501,8314,5983,8646,6623,31,6958,6840,9156,6672,5745,2147,1845,8065,8260,7293,3656,9087,8194,3237,8062,8680,3255,9679,7521,8349,8871,2370,6646,9475,2529,3706,6444,247,8694,6956,8205,3578,5355,459,8356,4513,9936,6912,6572,8016,2098,4555,2093,4696,9715,899,9383,506,6780,4163,1941,8026,6698,4620,2666,8858,6510,7267,5923,815,6348,1680,3492,9885,7412,5177,3610,4711,5066,4635,1889,2235,1985,1250,5514,7102,3099,9455,8764,3953,7917,3353,1156,93,446,5817,8328,3389,6960,9167,4366,3803,8548,3173,6164,7628,7514,6909,5477,8865,3852,8115,4643,181,9703,9482,6291,7721,9942,8975,1225,1799,3566,6443,830,8164,1668,2378,7934,2220,3916,7926,103,1475,358,1470,526,8995,8382,1712,2685,4749,2602,66,9782,6716,2732,4168,6388,3222,8913,176,5067,730,3244,4324,4961,9424,9323,8563,3397,1110,333,1597,439,6833,5541,6863,3268,6647,3309,3871,2837,1226,4683,9403,3545,969,8547,3774,6320,297,7453,2245,4995,5334,5796,3905,9982,8723,1134,7070,9192,427,720,6199,6943,4202,948,2240,756,2344,2048,6102,4611,5352,783,7840,1429,8187,1392,2802,6034,7781,4057,9919,5705,4644,167,3735,284,9926,4562,7545,3197,6763,1146,6363,7139,1280,5884,5632,5525,7529,2743,4588,911,1003,3706,2452,3958,4781,629,8134,2275,9897,4172,1218,4714,5935,902,6934,9615,7026,186,4893,5202,5532,1987,6133,2603,7615,7132,9000,1488,6900,6659,2993,2488,86,4553,6852,8041,7547,2863,6032,1586,6288,8987,331,5142,4765,7243,1008,9855,4594,319,2795,6965,1775,5385,7568,8426,6082,2383,6883,7796,8942,1265,9287,8548,8641,3728,4899,7808,7970,165,6940,9728,9695,6902,2557,8919,954,3991,5580,502,5996,1706,6264,6100,2502,3587,7192,6148,1124,8405,2534,6263,7384,1454,6301,100,8381,4233,6786,4332,6098,1237,4731,1533,2488,4374,6077,3702,1770,9936,4725,7843,9549,8390,2255,2055,7109,4574,908,8686,3551,1909,2032,5383,1100,4214,4049,207,4739,2053,8396,3924,1103,1596,599,9641,2530};
        System.out.println("Before sorting: " + Arrays.toString(array));
        quickSort.sort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }

}

//Random Shuffle Implementation 
class StdRandom {
    private static final Random random = new Random();

    public static void shuffle(Object[] array) {
    for (int i = array.length -1; i > 0; i--) {
        int index = random.nextInt(i + 1);
        Object temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }
    }
}
