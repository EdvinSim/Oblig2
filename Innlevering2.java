class Innlevering2 {

    //___MAIN___
    public static void main(String[] args) {
        
        String filename = args[0];

        SorterParent[] sorters = {new Bubble(), new Heap(), new Merge(), new MyInsertion(), new MyQuick(), new Selection()};

        System.out.println(SortAnalyzer.header());

        for(SorterParent s: sorters) SortAnalyzer.analyze(filename, s);
    }
}