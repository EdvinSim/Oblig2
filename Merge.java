//Kjoretid O(n log(n))

/*
Splitte i 2, sortere de mindre delene ved rekursjon til hvert array har et element. 
Deretter flette sammen. med metoden merge.
*/

public class Merge extends SorterParent{

    @Override
    public int[] sort(int[] arr) {

        int size = arr.length;

        compares++;
        if(size <= 1) {

            return arr;
        }
        else {
            int middle = size/2;
            int[] left = new int[middle];
            int[] right = new int[(size+1)/2];

            //Splitt i to arrays.
            for(int i = 0; i < size; i++) {
                compares++;
                
                compares++;
                if(i < middle) left[i] = arr[i];
                else right[i-middle] = arr[i];
            }
             
            int[] arr1 = sort(left);
            int[] arr2 = sort(right);
            return merge(arr1, arr2, arr);
        }
    }

    private int[] merge(int[] arr1, int[] arr2, int[] array) {
        int i = 0;
        int j = 0;

        compares += 2;//Siden vi ikke gaar inn i whileblokken siste gang.
        while(i < arr1.length && j < arr2.length) {
            compares += 2;

            compares++;
            if(arr1[i] <= arr2[j]) {

                array[i+j] = arr1[i];
                i++;
            }
            else {
                array[i+j] = arr2[j];
                j++;
            }
        }


        //Naar j er out of range
        compares++;
        while(i < arr1.length) {
            compares++;

            array[i+j] = arr1[i];
            i++;
        }

        //Naar i er out of range
        compares++;
        while(j < arr2.length) {
            compares++;
            
            array[i+j] = arr2[j];
            j++;
        }

        return array;
    }

    @Override
    public String getName() {
        return "Merge";
    }
}
