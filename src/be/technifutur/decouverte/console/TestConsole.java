package be.technifutur.decouverte.console;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestConsole {

    public static void main(String[] args) throws FileNotFoundException, ScanValueException {
        Console cons = null;
        cons = new ConsoleViaFichier("C:/Formation java 2022/test.txt");
//        Console cons = new ConsoleViaScan();
//        int number;
//
//        number = cons.iScan();
//        System.out.println(number);
//
//        number = cons.iScan();
//        System.out.println(number);

        ArrayList<Character> names = new ArrayList<>(Arrays.asList('A', 'B', 'C'));
        System.out.printf("The names are: %c\n", names);
    }
}