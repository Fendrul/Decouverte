package be.technifutur.decouverte.console;

import java.io.FileNotFoundException;

public class TestConsole {

    public static void main(String[] args) throws FileNotFoundException {
        Console cons = new ConsoleBuilder();

        cons.print("Donnez un nombre");
        int test = cons.integer();

        cons.print(test, " Est la valeur de : ", test);
    }
}