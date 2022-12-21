package be.technifutur.decouverte.euler;

import java.math.BigInteger;

import static be.technifutur.decouverte.euler.problem32.intToBigInt;

public class problem34 {
    public static void main(String[] args) {
        for (int i = 0; i < 99; i++) {
            System.out.println(i+" "+factorial(i));
        }
    }

    private static BigInteger factorial(int n) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            result = result.multiply(intToBigInt(i));
        }
        return result;
    }
}
