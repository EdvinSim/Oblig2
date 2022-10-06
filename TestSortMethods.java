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

        SorterParent sorters[] = {
            new Bubble(), 
            new Heap(),
            new Merge(),
            new MyInsertion(),
            new MyQuick(),
            new Selection(),

        };

        for(SorterParent sorter: sorters) {
            smallTest(sorter);
        }

        System.out.println("\n");
        for(SorterParent sorter: sorters) {
            bigTest(sorter);
        }

    }

    public static void smallTest(SorterParent sorter) {
        int size = 10;
        int max = size*10;

        System.out.println("\n" + sorter.getName());
        int[] array = newRandomArray(size, 0, max);
        System.out.println("Foer sortering: " + Arrays.toString(array));
        // System.out.println(sorter.getName() + "sort: " + checkSorted(array));
        sorter.sort(array);
        System.out.println("Etter sortering: " + Arrays.toString(array));
        System.out.println("Er sortert: " + checkSorted(array));
    }

    public static void bigTest(SorterParent sorter) {
        int size = 100000;
        int max = size*10;

        int[] array = newRandomArray(size, 0, max);
        sorter.sort(array);
        System.out.println(sorter.getName() + " er sortert: " + checkSorted(array));
    }
}
