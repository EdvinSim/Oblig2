class Innlevering2 {

    //---MAIN---
    public static void main(String[] args) {
        String filename = args[0];

        SortAnalyzer.analyze(filename, new Bubble());
        SortAnalyzer.analyze(filename, new Heap());
        SortAnalyzer.analyze(filename, new Merge());
        SortAnalyzer.analyze(filename, new MyInsertion());
        SortAnalyzer.analyze(filename, new MyQuick());
        SortAnalyzer.analyze(filename, new Selection());
    }
}