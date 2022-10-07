public class Heap extends SorterParent {

    private void buildMaxHeap(int[] arr, int size) {

        for(int i = size/2; i >= 0; i--) {
            compares++;

            bubbleDown(arr, i, size);
        }
    }

    private void bubbleDown(int[] arr, int root, int size) {
        int largest = root;
        int left = 2*root+1;
        int right = 2*root+2;

        int tmp;

        compares += 2;
        if(left < size && arr[largest] < arr[left]) {
            tmp = largest;
            largest = left;
            left = tmp;

            swaps++;
        }

        compares += 2;
        if(right < size && arr[largest] < arr[right]) {
            tmp = largest;
            largest = right;
            right = tmp;

            swaps++;
        }

        compares++;
        if(root != largest) {
            tmp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = tmp;

            swaps++;

            bubbleDown(arr, largest, size);
        }
    }

    @Override
    public int[] sort(int[] arr) {
        buildMaxHeap(arr, arr.length);
        for(int i = arr.length-1; i >= 0; i--) {
            compares++;

            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            swaps++;

            bubbleDown(arr, 0, i);
        }

        return arr;
    }

    @Override
    public String getName() {
        return "Beap";
    }
}
