package be.technifutur.decouverte.poo;

public class VaisseauMethode {
    private static int nbVaisseauxEnVol = 0;
    private int nbMissile = 5;
    private boolean enVol = false;
    boolean Daniyal = false;

    VaisseauMethode() {
    }

    VaisseauMethode(int missilesAInserer) {
        if (missilesAInserer >= 0)
            nbMissile = missilesAInserer;
    }


    public static int getNbVaisseauxEnVol() {
        return nbVaisseauxEnVol;
    }

    public void tirer() {
        if (nbMissile <= 0) {
            System.out.println("clic clic clic");
        } else {
            System.out.println("piou piou piou !");
            nbMissile--;
        }
    }

    public void recharger() {
        nbMissile++;

        if (nbMissile < 0)
            nbMissile--;
        else
            System.out.println("crack crack - rechargement");
    }

    public void recharger(int qttRecharge) {
        nbMissile += qttRecharge;

        if (nbMissile < 0)
            nbMissile -= qttRecharge;
        else
            System.out.println("crack crack - rechargement de " + qttRecharge + " missiles");
    }

    public int qttMissiles() {
        return nbMissile;
    }

    public void decoller() {
        if (enVol)
            System.out.println("JE VOLE DEJA COMME UN OISEAU");
        else {
            System.out.println("JE DECOLLE");
            enVol = true;
            nbVaisseauxEnVol++;
        }
    }

    public void atterrir() {
        if (!enVol)
            System.out.println("JE SUIS DEJA AU SOL, TOUT COMME TA REPARTIE");
        else {
            System.out.println("ATTENTION, J'ATTERRIS");
            enVol = false;
            nbVaisseauxEnVol--;
        }
    }

    public void fctDaniyal() {
        if (!Daniyal)
            System.out.println("haha, il est vraiment trop négatif comme mec mdrrrrrrr xptdr trololol ce normie");
        else {
            System.out.println("wtf pourquoi il est positif, arrêtons ça");
            Daniyal = false;
        }

        System.out.println("haha il est trop roasté");
    }
}
