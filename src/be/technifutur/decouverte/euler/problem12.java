package be.technifutur.decouverte.euler;

import java.util.ArrayList;
import java.util.List;

public class problem12 {

    public static final int NOMBRE_DIVISEURS = 500 / 2; // à diviser par deux, comme chaque diviseur possède un diviseur parallèle

    public static void main(String[] args) {
        List<Integer> divisors = new ArrayList<>();
        boolean numberFound = false;
        int comptor = 1;
        int sum = 0;

        while (!numberFound) {
            sum += comptor;

            for (int i = 1; i <= Math.sqrt(sum); i++) {
                if (sum % i == 0) {
                    divisors.add(i);
                }
            }

            if (divisors.size() >= NOMBRE_DIVISEURS) {
                System.out.printf("Il y a %d diviseurs et le nombre est %d", divisors.size() * 2, sum);
                numberFound = true;
            }

            comptor++;
            divisors = new ArrayList<>();
        }
    }
}
