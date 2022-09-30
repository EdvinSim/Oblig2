
public class MergeSort {
    public static int[] mergeSort(int[] arr) {

        int size = arr.length;

        if(size <= 1) {
            return arr;
        }
        else {
            int middle = size/2;
            int[] left = new int[middle];
            int[] right = new int[(size+1)/2];

            //Splitt i to arrays.
            for(int i = 0; i < size; i++) {
                if(i < middle) left[i] = arr[i];
                else right[i-middle] = arr[i];
            }
             
            int[] arr1 = mergeSort(left);
            int[] arr2 = mergeSort(right);
            return merge(arr1, arr2, arr);
        }
    }

    private static int[] merge(int[] arr1, int[] arr2, int[] array) {
        int i = 0;
        int j = 0;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) {
                array[i+j] = arr1[i];
                i++;
            }
            else {
                array[i+j] = arr2[j];
                j++;
            }
        }

        while(i < arr1.length) {
                array[i+j] = arr1[i];
                i++;
        }
        while(j < arr2.length) {
                array[i+j] = arr2[j];
                j++;
        }

        return array;
    }
}
