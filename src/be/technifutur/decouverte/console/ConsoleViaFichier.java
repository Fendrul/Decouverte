package be.technifutur.decouverte.console;

import java.io.*;

/**
 * Toutes les fonctions de scan de console vont boucler jusqu'à avoir le type de valeur voulue
 */
public class ConsoleViaFichier implements Console {

    BufferedReader br;

    @Override
    public String toString() {
        return "ConsoleViaFichier{" +
                "br=" + br +
                '}';
    }

    ConsoleViaFichier(String cheminFichier) {
        try {
            br = new BufferedReader(new FileReader(new File(cheminFichier)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Fichier non trouvé - " + e);
        }
    }

    public void close() {
        if (br != null) {
            try {
                System.out.println("fermeture du fichier");
                br.close();
            } catch (IOException ex) {
                System.out.println("Échec dans la fermeture de fichier");
            }
        }
    }

    @Override
    public int integer() {
        String st;

        try {
            if ((st = br.readLine()) != null)
                return Integer.parseInt(st);

        } catch (IllegalArgumentException ignored) {
            print("ConsoleViaFichier.integer : mauvais nombre inséré, un long était attendu");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    @Override
    public boolean integerEdge(int borneInferieure, int borneSuperieure) {
        String st;

        try {
            if ((st = br.readLine()) != null)
                return Integer.parseInt(st) >= borneInferieure && Integer.parseInt(st) <= borneSuperieure;

        } catch (IllegalArgumentException ignored) {
            print("ConsoleViaFichier.integer : mauvais nombre inséré, un long était attendu");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public int ReturniInput() {
        return 0;
    }

    @Override
    public String string() {
        return null;
    }

    @Override
    public char character() {
        return 0;
    }

    @Override
    public long longer() {
        return 0;
    }

    @Override
    public double doubled() {
        return 0;
    }

    @Override
    public void print(Object... values) {

    }
}
