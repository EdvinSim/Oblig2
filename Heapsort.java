public abstract class Heapsort {

    private static void buildMaxHeap(int[] arr, int size) {

        for(int i = size/2; i >= 0; i--) {
            bubbleDown(arr, i, size);
        }
    }

    private static void bubbleDown(int[] arr, int root, int size) {
        int largest = root;
        int left = 2*root+1;
        int right = 2*root+2;

        if(left < size && arr[largest] < arr[left]) {
            int tmp = largest;
            largest = left;
            left = tmp;
        }
        if(right < size && arr[largest] < arr[right]) {
            int tmp = largest;
            largest = right;
            right = tmp;
        }

        if(root != largest) {
            int tmp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = tmp;
            bubbleDown(arr, largest, size);
        }
    }

    public static void heapsort(int[] arr) {
        buildMaxHeap(arr, arr.length);
        for(int i = arr.length-1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            bubbleDown(arr, 0, i);
        }
    }
}
