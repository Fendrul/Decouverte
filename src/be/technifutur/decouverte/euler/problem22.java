package be.technifutur.decouverte.euler;

import be.technifutur.decouverte.console.ConsoleViaFichier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class problem22 {
    public static void main(String[] args) {
        List<String> prenoms;
        ConsoleViaFichier cons = new ConsoleViaFichier("src/be/technifutur/decouverte/euler/ressources/problem22.txt");
        int totalSum = 0;

        prenoms = Arrays.asList(cons.string().split("\",\""));

        Collections.sort(prenoms);


        for (int i = 0; i < prenoms.size(); i++) {
            int sumLetters = prenoms.get(i)
                    .chars() // Transforme le String en une chaine de int avec la valeur du caractère pour chaque élément
                    .map(x -> x - 64)
                    .sum();
            totalSum += sumLetters * (i+1);
        }

        System.out.println(totalSum);
    }
}
