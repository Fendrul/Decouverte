package be.technifutur.decouverte.structure;

import java.util.Scanner;

public class Console {
    int iInput;
    Scanner scan = new Scanner(System.in);

    public int iScan() {
        return Integer.parseInt(scan.nextLine());
    }

    public boolean iScanBorne(int borneInferieure, int borneSuperieure) {
        iInput = Integer.parseInt(scan.nextLine());

        if (iInput < borneInferieure || iInput > borneSuperieure) {
            return false;
        }
        return true;
    }

    public int ReturniInput() {
        int tempIIinput = iInput;
        iInput = 0;
        return tempIIinput;
    }

    public String sInput() {
        return scan.nextLine() ;
    }
}