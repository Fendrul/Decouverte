package be.technifutur.decouverte.console;

import java.util.Scanner;

public interface Console {



    public static final Scanner scan = new Scanner(System.in);

    public int iScan()
            throws ScanValueException;

    public boolean iScanBorne(int borneInferieure, int borneSuperieure)
            throws ScanValueException;

    public int ReturniInput();

    public String sInput()
            throws ScanValueException;

    public char cInput()
            throws ScanValueException;

    public void affichage(String... values);
}