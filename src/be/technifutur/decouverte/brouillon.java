package be.technifutur.decouverte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class brouillon {
    public static void main(String[] args) {
        List<Integer> digitList = Arrays.asList(1, 2, 3, 4, 5);
        int digit = 3;

        if (digitList.contains(digit)) {
            digitList.remove(digit);
        }

        System.out.println(digitList);
    }
}
