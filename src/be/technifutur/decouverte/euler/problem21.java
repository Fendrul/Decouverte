package be.technifutur.decouverte.euler;

import java.util.HashMap;
import java.util.Objects;

public class problem21 {

    public static final int LIMIT_AMICABLE_NUMBER = 10000;

    public static void main(String[] args) {
        HashMap<Integer, Integer> amicableMap = new HashMap<>();

        for (int amicableNum = 1; amicableNum <= LIMIT_AMICABLE_NUMBER; amicableNum++) {
            int sumDivisors = 0;

            for (int divisor = 1; divisor <= Math.sqrt(amicableNum); divisor++) {
                if (amicableNum % divisor == 0) {
                    sumDivisors += divisor;
                    sumDivisors += amicableNum / divisor; // Ajoute chaque diviseurs en miroir comme ils peuvent être trouvé à partir du premier diviseur
                }
            }
            sumDivisors -= amicableNum; // retire le nombre lui-même qui se retrouve ajouté par les diviseurs miroirs

            if (Math.sqrt(amicableNum) % 1 == 0)
                sumDivisors -= Math.sqrt(amicableNum);

            amicableMap.put(amicableNum, sumDivisors);
        }

        int sumAmicable = 0;
        for (int reference = 1; reference < LIMIT_AMICABLE_NUMBER; reference++) {
            boolean amicableNumFound = false;

            if (amicableMap.get(reference) != 0) { // Pas besoin de procéder à la vérification du nombre si celui-ci a déjà été comtpé dans les nombres amicaux

                for (int compare = reference + 1; compare <= LIMIT_AMICABLE_NUMBER; compare++) {
                    if (Objects.equals(amicableMap.get(reference), compare) && Objects.equals(amicableMap.get(compare), reference)) {
                        sumAmicable += compare + reference;
                        amicableMap.put(compare, 0); // Passe la valeur à 0 afin de ne plus avoir d'impact dans le calcul
                    }
                }
            }
        }

        System.out.println(sumAmicable);
    }
}