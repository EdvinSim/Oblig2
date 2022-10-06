class Innlevering2 {

    //---MAIN---
    public static void main(String[] args) {
        String filename = args[0];

        // int[] array = SortAnalyzer.readFile(filnavn);
        // SortAnalyzer.output(array, filnavn, "quick");
        // MyQuick.sort(array);
        // SortAnalyzer.output(array, filnavn, "quick");

        SortAnalyzer.analyze(filename, new Bubble());
    }
}