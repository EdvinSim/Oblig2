
public abstract class QuickSort {

    private static int partition(int[] arr, int low, int high) {

        //En annen pivot er aa peke paa midten av aprtisjonen. Midten av low/high ikke lengden av arr.

        int pivot = arr[high];

        int left = low;
        int right = high - 1; //Siste index foer pivot.

        while( left <= right) {
            while(left <= right && arr[left] <= pivot) {
                left++;
            }
            while(right >= left && arr[right] >= pivot) {
                right--;
            }
            if(left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }

        int tmp = arr[left];
        arr[left] = arr[high];
        arr[high] = tmp;
        return left;
    }

    private static int[] _quicksort(int[] arr, int low, int high) {
        if(low >= high) {
            return arr;
        }
        else {
            int p = partition(arr, low, high);
            _quicksort(arr, low, p-1);
            _quicksort(arr, p+1, high);
            return arr;
        }
    }

    public static void quicksort(int[] arr) {
        _quicksort(arr, 0, arr.length-1);
    }
}
