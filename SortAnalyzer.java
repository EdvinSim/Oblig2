import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//En klasse med statiske metoder.

public class SortAnalyzer {

    static int width = 12;

    public static int[] readFile(String filename) {
        int [] array;

        try {
            String[] fileSplited = filename.split("_");
            int quantite = Integer.parseInt(fileSplited[fileSplited.length-1]);
            
            array = new int[quantite];
    
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            for(int i = 0; sc.hasNextLine(); i++) {
                array[i] = Integer.parseInt(sc.nextLine());
            }

            sc.close();

            return array;

        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("Fant ikke fil: " + filename);
            //e.printStackTrace();
            return null;
        }
    }

    public static boolean checkSorted(int[] array) {
        boolean sorted = true;

        for(int i = 0; i < array.length -1; i++) {
            if (array[i] >  array[i+1]) {
                System.out.println(array[i] + " er ikke mindre enn " + array[i+1]);
                sorted = false;
            }
        }
        
        return sorted;
    }

    public static String writeFile(int[] array, String file, String sortingMethod) {

        String fileName = file.split("_")[1];
        String status = "Noe galt i writeFile???!!!";
        
        try {
            String nameNewFile = fileName + "_" + sortingMethod + ".out";
            File newFile = new File("outputs/" + nameNewFile);

            if(newFile.createNewFile()) {
                status = "Fil laget";
            } else {
                status = "Filen finnes fra foer!";
            }

            FileWriter writer = new FileWriter(newFile);

            for(int num: array) {
                writer.write(String.valueOf(num) + "\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Det skjedde noe feil i writeFile-metoden!");
            e.printStackTrace();
        }

        return status;
    }

    public static String output(int[] array, String fileName, String sortingMethod) {

        String status;

        if(checkSorted(array)) {
            status = writeFile(array, fileName, sortingMethod);
            // status += "\tHurra! Sortert med " + sortingMethod + "sort :D";
        } else {
            status = "Sortering med" + sortingMethod + " funket ikke >:(";
        }

        return status;
    }

    //Gjoer en analyse av en sorteringsalgoritme.
    public static void analyze(String filename, SorterParent sorter) {
        int[] array = readFile(filename);

        long t = System.nanoTime();
        sorter.sort(array);
        long time = (System.nanoTime()-t)/1000;

        String status = output(array, filename, sorter.getName());


        //Vertical print
        
        // System.out.println(
        //     "\n" + (sorter.getName() + "sort").toUpperCase()
        //     + "\nArray size:\t" + array.length
        //     + "\nTime:\t\t" + time + " mikrosek."
        //     + "\nSwaps:\t\t" + sorter.swaps
        //     + "\nCompares:\t" + sorter.compares
        //     + "\n" + Status
        // );


        //Horizontal print
        String linje = String.format("%-"+width+"s%-"+width+"d%-"+width+"d%-"+width+"d%-"+width+"d%-"+width+"s", sorter.getName(), array.length, time, sorter.swaps, sorter.compares, status);
        System.out.println(linje);
    }

    public static String header() {
        String[] titles = {"Sorter", "Array size", "compares", "Swaps", "Time", "Status"};
        String header = "\n";

        for(String s: titles) {
            header += String.format("%-"+ width +"s", s);
        }

        header += "\n";

        return header;
    }
}
