import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//En klasse med statiske metoder.

public class SortAnalyzer {

    
    // String inputFile;
    // int[] array;

    // SortAnalyzer(String fileName) {
    //     inputFile = fileName;
    // }

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

    public static void writeFile(int[] array, String fileName, String sortingMethod) {
        
        try {
            File newFile = new File(fileName + "_" + sortingMethod + ".out");
            if(newFile.createNewFile()) {
                System.out.println("Fil laget");
            } else {
                System.out.println("Filen finnes fra foer");
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
    }

    public static void output(int[] array, String fileName, String sortingMethod) {
        if(checkSorted(array)) {
            System.out.println("Hurra! Denne arrayen er sortert :D");
            writeFile(array, fileName, sortingMethod);
        } else {
            System.out.println("Denne arrayen er ikke sortert >:(");
        }
    }

    //Gjoer en analyse av en sorteringsalgoritme.
    public static void analyze(String filename, SorterParent sorter) {
        int[] array = readFile(filename);

        long t = System.nanoTime();
        sorter.sort(array);
        long time = (System.nanoTime()-t)/1000;

        output(array, filename, sorter.getName());

        System.out.println(
            "\n" + (sorter.getName() + "sort").toUpperCase()
            + "\nArray size:\t" + array.length
            + "\nTid:\t\t" + time + " mikrosek."
        );
    }


}
