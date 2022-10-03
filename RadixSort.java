public class RadixSort {
    public static void radixSort(int[] arr) {
        int digits = maxDigits(arr);
        
        for(int i = digits-1; i >= 0; i--) {
            bucketSort(arr, i);
        }
    }

    public static void bucketSort(int[] arr, int digitNum) {
        int[] bucket = new int[10];

        for(int num: bucket) {
            num = 0;
        }

        for(int num: arr) {
            //TODO Her maa vi se paa hvert siffer og sortere
        }
    }

    private static int maxDigits(int[] arr) {
        int max = 0;
        for(int num: arr) {
            if(num > max) {
                max = num;
            }
        }
        return String.valueOf(max).length();
    }
}
