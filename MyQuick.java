
public class MyQuick extends SorterParent{

    private int partition(int[] arr, int low, int high) {

        //En annen pivot er aa peke paa midten av partisjonen. Midten av low/high ikke lengden av arr.

        int pivot = arr[high];

        int left = low;
        int right = high - 1; //Siste index foer pivot.

        compares++;
        while( left <= right) {
            compares++;

            compares += 2;
            while(left <= right && arr[left] <= pivot) {
                compares += 2;

                left++;
            }

            compares += 2;
            while(right >= left && arr[right] >= pivot) {
                compares += 2;

                right--;
            }

            compares++;
            if(left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;

                swaps++;
            }
        }

        int tmp = arr[left];
        arr[left] = arr[high];
        arr[high] = tmp;

        swaps++;
        
        return left;
    }

    private int[] _quicksort(int[] arr, int low, int high) {
        
        compares++;
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

    @Override
    public int[] sort(int[] arr) {
        _quicksort(arr, 0, arr.length-1);
        return arr;
    }
    
    @Override
    public String getName() {
        return "Quick";
    }
}
