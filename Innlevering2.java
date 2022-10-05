class Innlevering2 {

    //---MAIN---
    public static void main(String[] args) {
        String filnavn = args[0];

        int[] array = SortAnalyzer.readFile(filnavn);
        // SortAnalyzer.output(array, filnavn, "quick");
        QuickSort.quicksort(array);
        SortAnalyzer.output(array, filnavn, "quick");
    }
}