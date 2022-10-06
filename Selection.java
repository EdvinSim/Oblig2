//minjoretid O(n^2)
public class Selection extends SorterParent {

    @Override
    public int[] sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int min = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }

        return arr;
    }

    @Override
    public String getName() {
        return "selection";
    }
}
