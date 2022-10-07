
public class MyInsertion extends SorterParent{
    
    @Override
    public int[] sort(int[] array) {
        int length = array.length;
        
        for(int i = 1; i < length; i++) {
            compares++;

            int j = i;

            compares += 2;
            while(j > 0 && array[j-1] > array[j]) {
                compares += 2;

                int tmp = array[j-1];
                array[j-1] = array[j];
                array[j] = tmp;

                swaps++;

                j--;
            }
        }

        return array;
    }

    @Override
    public String getName() {
        return "Insertion";
    }
}
