package be.technifutur.decouverte.euler;

import be.technifutur.decouverte.console.Console;
import be.technifutur.decouverte.console.ConsoleBuilder;

import java.util.*;

public class problem24 {

    public static final String STRING = "abcdefghijklmnopqr";
    public static final int NUM_OF_PERMUTATIONS = 100000000;

    public static void main(String[] args) {
List<Character> object = orderedCharList(STRING);
        int length = object.size();
        char[] objectPermuted = new char[length];
        LinkedList<Integer> lehmerCode = new LinkedList<>();
        int numberLeft = NUM_OF_PERMUTATIONS;

// crée le ccode de Lehmer permettant de retrouver l'index de chaque élément à la xème permutation
        for (int i = length - 1; i >= 0; i--) {
            long factorial = factorial(i);
            lehmerCode.add((int) (numberLeft / factorial));
            numberLeft -= lehmerCode.get(length - 1 - i) * factorial;
        }

//replace les élements en fonction du code de Lehmer
        for (int i = 0; i < length; i++) {
            objectPermuted[i] = object.get(lehmerCode.get(i));
            object.remove((int) lehmerCode.get(i));
        }

        for (char c :
                objectPermuted) {
            System.out.printf("%s ", c);
        }
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    private static List<Character> orderedCharList(String string) {
        char[] charArray = string.toCharArray();
        List<Character> charList = new ArrayList<>();

        for (char c :
                charArray) {
            charList.add(c);
        }

        Collections.sort(charList);

        return charList;
    }
}
