import java.util.Arrays;

public class TestSortMethods {

    public static boolean checkSorted(int[] array) {
        boolean sorted = true;

        for(int i = 0; i < array.length -1; i++) {
            if (array[i] >  array[i+1]) {
                System.out.println(array[i] + " er ikke mindre enn " + array[i+1]);
                sorted = false;
            }
        }
        
        return sorted;
    }

    public static int[] newRandomArray(int size, int min, int max) {
        int[] array = new int[size];

        for(int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * (max-min) + min);
        }

        return array;
    }

    public static void main(String[] args) {

        //Test insertionSort
        int[] array = newRandomArray(1000, 0, 10000);
        //System.out.println("Foer sortering: " + checkSorted(array));
        InsertionSort.insertionSort(array);
        System.out.println("Insertion sort: " + checkSorted(array));

        //Test quicksort
        array = newRandomArray(100, 0, 1000);
        // System.out.println("Foer sortering: " + checkSorted(array));
        QuickSort.quicksort(array);
        System.out.println("Quick Sort: " + checkSorted(array));

        //Test mergeSort
        array = newRandomArray(1000, 0, 10000);
        //System.out.println("Foer sortering: " + checkSorted(array));
        MergeSort.mergeSort(array);
        System.out.println("Merge Sort: " + checkSorted(array));

        //Test bubbleSort
        array = newRandomArray(1000, 0, 10000);
        BubbleSort.bubbleSort(array);
        System.out.println("Bubble Sort: " + checkSorted(array));

        //Test selectionSort
        array = newRandomArray(1000, 0, 10000);
        //System.out.println("Foer sortering: " + checkSorted(array));
        SelectionSort.selectionSort(array);
        System.out.println("Selection Sort: " + checkSorted(array));

        //Test heapsort
        array = newRandomArray(10, 0, 100);
        //System.out.println("Foer sortering: " + checkSorted(array));
        Heapsort.heapsort(array);
        System.out.println("HeapSort: " + checkSorted(array));

        //Test radixSort
        array = newRandomArray(100, 0, 10000);
        RadixSort.radixSort(array);

    }
}
