package be.technifutur.decouverte.euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class problem32 {

    public static final String PANDIGITAL_NUMBER = "123456789";

    public static void main(String[] args) {



        for (int i = 0; i < factorial(PANDIGITAL_NUMBER.length()).intValue(); i++) {
            int[] values = permutedNumber(PANDIGITAL_NUMBER, i);
            for (int value :
                    values) {
                System.out.printf("%d", value);
            }
            System.out.println();
        }
    }

    public static int[] permutedNumber(String number, int NUM_OF_PERMUTATIONS) {
        List<Character> object = orderedCharList(number);
        int length = object.size();
        int[] objectPermuted = new int[length];
        LinkedList<Integer> lehmerCode = new LinkedList<>();
        BigInteger numberLeft = new BigInteger(String.valueOf(NUM_OF_PERMUTATIONS));

// crée le ccode de Lehmer permettant de retrouver l'index de chaque élément à la xème permutation
        for (int i = length - 1; i >= 0; i--) {
            BigInteger factorial = factorial(i);
            lehmerCode.add(numberLeft.divide(factorial).intValue());
            numberLeft = numberLeft.subtract(factorial.multiply(intToBigInt(lehmerCode.get(length - 1 - i))));
        }

//remplace les élements en fonction du code de Lehmer
        for (int i = 0; i < length; i++) {
            objectPermuted[i] = object.get(lehmerCode.get(i)) - 48; // le nombre étant représenté en ASCII, on retire la valeur de ce tableau
            object.remove((int) lehmerCode.get(i));
        }

        return objectPermuted;
    }

    private static BigInteger factorial(int n) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            result = result.multiply(intToBigInt(i));
        }
        return result;
    }

    private static BigInteger intToBigInt(int num) {
        return new BigInteger(Integer.toString(num));
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
