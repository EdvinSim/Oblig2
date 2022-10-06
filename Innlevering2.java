class Innlevering2 {

    //---MAIN---
    public static void main(String[] args) {
        String filename = args[0];

        SortAnalyzer.analyze(filename, new Bubble());
    }
}