package be.technifutur.decouverte.console;

import java.io.FileNotFoundException;

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

        int dim = 3;
        StringBuilder sb = new StringBuilder();

        sb.append(" %s ".repeat(dim));
        sb.append("|");
        sb.append(sb.toString().repeat(dim - 1));
        sb.append("\n");
        sb.append(sb.toString().repeat(dim - 1));

        sb.append(sb.toString().repeat(dim - 1));

        String str = sb.toString();
        System.out.println(str);
    }
}