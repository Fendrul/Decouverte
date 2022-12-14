package be.technifutur.decouverte.euler;

import be.technifutur.decouverte.console.Console;
import be.technifutur.decouverte.console.ConsoleBuilder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class problem26 {

    public static final int DECIMALS_SCALE = 1000;

    public static void main(String[] args) {
        Console cons = new ConsoleBuilder();
        HashMap<Integer, Integer> cycles = new HashMap<>();
        List<Integer> listPrimeNumber = listPrimeNumber(DECIMALS_SCALE);
        listPrimeNumber.removeIf(p -> p >= DECIMALS_SCALE);

        for (Integer i: listPrimeNumber) {
            BigDecimal dividend = new BigDecimal(1);
            BigDecimal divisor = new BigDecimal(i);
            BigDecimal result = dividend.divide(divisor, DECIMALS_SCALE, RoundingMode.HALF_UP).stripTrailingZeros();

            if (result.toString().length() == DECIMALS_SCALE + 2) {
                boolean cycleFound = false;
                int cycleLength = 0;

                while (result.compareTo(BigDecimal.valueOf(1)) < 0)
                    result = result.scaleByPowerOfTen(1);

                BigDecimal number1 = bigDecimalTruncate(new BigDecimal(String.valueOf(result)), 1);
                BigDecimal number2 = bigDecimalTruncate(result, 1);
                while (cycleLength < DECIMALS_SCALE - 10 && !cycleFound) {
                    cycleLength++;
                    number1 = number1.scaleByPowerOfTen(1);
                    number2 = bigDecimalTruncate(number2, 1);

                    if (number1.subtract(number2).remainder(BigDecimal.valueOf(2)).compareTo(BigDecimal.valueOf(0)) == 0) {
                        System.out.printf("%d: cycle de %d\n", i, cycleLength);
                        cycles.put(i, cycleLength);
                        cycleFound = true;
                    }
                }
            }
        }
        System.out.println(cycles.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey());

    }

    public static List<Integer> listPrimeNumber(int length) {
        List<Integer> listeNombrePremier = new ArrayList<>();

        int compteur = 3;
        int sizeList = 1;
        while (sizeList <= length) {
            boolean isPremier = true;
            Iterator<Integer> iterator = listeNombrePremier.iterator();

            while (isPremier && iterator.hasNext()) {
                if (compteur % iterator.next() == 0)
                    isPremier = false;
            }

            if (isPremier) {
                listeNombrePremier.add(compteur);
                sizeList++;
            }

            compteur+=2;
        }

        return listeNombrePremier;
    }

    private static BigDecimal bigDecimalTruncate(BigDecimal bigD, int truncate) {
        String s = bigD.toString();
        s = s.substring(0, s.length() - truncate);
        return new BigDecimal(s);
    }
}
