package be.technifutur.decouverte.statment;

import be.technifutur.decouverte.console.ConsoleViaScan;

public class Alternatives {

    public static void main(String[] args) {
        ConsoleViaScan cons = new ConsoleViaScan();
        Boolean test;
        Integer iTest;
        char cTest;

        cTest = cons.character();

        if (cTest > '1' && cTest < '9') System.out.println("Ça fonctionne !!");
        else System.out.println("ça n'est pas un nombre caractère !");

    }
}
