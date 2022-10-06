
//Heter SorterParent for aa ikke forveksle med Sorter-klassen i Prekoden.
public abstract class SorterParent {
    int compares = 0;
    int swaps = 0;

    public abstract int[] sort(int[] array);

    public abstract String getName();
}
