package be.technifutur.decouverte.euler;

import java.util.ArrayList;
import java.util.List;

public class problem30 {

    public static final int EXP = 5;
    public static final int MAX_NUMBER = 1000000;

    public static void main(String[] args) {
        int sum = 0;
        List<Integer> digits = new ArrayList<>();
        digits.add(2);
        boolean isHighestPossibleNumber = false;

        while (!isHighestPossibleNumber) {
            int numberVerified = 0;
            int expSum = 0;

            for (int i = 0; i < digits.size(); i++) {
                numberVerified += digits.get(i) * Math.pow(10, i);
            }

            for (Integer digit : digits) {
                expSum += Math.pow(digit, EXP);
            }

            if (numberVerified == expSum)
                sum += numberVerified;

            if (numberVerified > MAX_NUMBER)
                isHighestPossibleNumber = true;

            increment(digits);
        }
        System.out.println(sum);
    }

    private static void increment(List<Integer> digits) {
        boolean incrementing = true;
        int cursor = 0;

        while (incrementing) {
            if (cursor > digits.size() - 1) {
                digits.add(1);
                incrementing = false;
            } else if (digits.get(cursor) == 9) {
                digits.set(cursor, 0);
                cursor++;
            } else {
                digits.set(cursor, digits.get(cursor) + 1);
                incrementing = false;
            }
        }
    }
}
