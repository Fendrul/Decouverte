package be.technifutur.decouverte.euler.ressources;

import java.math.BigInteger;
import java.util.Arrays;

public class problem20 {

    public static final int NOMBRE = 100;

    public static void main(String[] args) {
        BigInteger number = new BigInteger(Integer.toString(NOMBRE));
        long sum = 0;

        for (int i = NOMBRE-1; i > 0; i--) {
            number = number.multiply(intToBigInt(i));
        }

        int[] arrayNumerals = Arrays.stream(
                number.toString()
                .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i :
                arrayNumerals) {
            sum += i;
        }
        System.out.println(sum);
    }

    private static BigInteger intToBigInt(int num) {
        return new BigInteger(Integer.toString(num));
    }
}
