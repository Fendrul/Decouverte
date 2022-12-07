package be.technifutur.decouverte.console;

import java.io.*;

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
    public int iScan() {
        String st;

        try {
            if ((st = br.readLine()) != null)
                return Integer.parseInt(st);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    @Override
    public boolean iScanBorne(int borneInferieure, int borneSuperieure) {
        String st;

        try {
            if ((st = br.readLine()) != null)
                return Integer.parseInt(st) >= borneInferieure && Integer.parseInt(st) <= borneSuperieure;
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
    public String sInput() {
        return null;
    }

    @Override
    public char cInput() {
        return 0;
    }

    @Override
    public void affichage(String... values) {

    }
}
