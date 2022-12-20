package be.technifutur.decouverte.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class problem11 {
    public static void main(String[] args) {
        int[][] tab = createTab("src/be/technifutur/decouverte/euler/ressources/problem11.txt");
    }

    private static int[][] createTab(String s) {
        File file = new File(s);
        List<Integer> newTab = new ArrayList<>();
        int[] test = new int[5];

        try (Scanner scan = new Scanner(file)) {

//            while (scan.hasNextLine()) {
//                newTab.addAll(Arrays.asList(
//                        stringNumToArr(scan.nextLine())
//                );
//            }

        } catch (FileNotFoundException fnf) {
            System.out.printf("Fichier à l'emplacement %s non trouvé", s);
        }

        int[][] returnTab = new int[newTab.size()][];

        return returnTab;
    }

//    private static int[] stringNumToArr(String nextLine) {
//    }
//
//    private static int[] stringNumbersToArray(String nextLine) {
//    }
}
