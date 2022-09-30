
public class InsertionSort{
    
    //Returnerer den ingenting???
    public static void insertionSort(int[] array) {
        int length = array.length;
        for(int i = 1; i < length; i++) {
            int j = i;
            while(j > 0 && array[j-1] > array[j]) {
                int tmp = array[j-1];
                array[j-1] = array[j];
                array[j] = tmp;
                j--;
            }
        }
    }
}

//Test oppdatering git??
