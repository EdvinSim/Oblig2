//Kjoretid O(n^2)
public class Bubble extends SorterParent{

    @Override
    public int[] sort(int[] arr) {
        int tmp;

        for(int i = 0; i < arr.length -1; i++) {
            for(int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }

    @Override
    public String getName() {
        return "bubble";
    }
}
