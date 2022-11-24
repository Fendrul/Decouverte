package be.technifutur.decouverte.poo;

import java.util.Objects;

public class VaisseauAncetre {
    private static int nbVaisseauxEnVol = 0;
    private int nbMissile = 5;
    private boolean enVol = false;
    boolean Daniyal = false;

    VaisseauAncetre() {
    }

    VaisseauAncetre(int missilesAInserer) {
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

    public boolean isEnVol() {
        return enVol;
    }

    public void afficherCamp() {
        System.out.println("Je suis neutre !");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaisseauAncetre that = (VaisseauAncetre) o;
        return nbMissile == that.nbMissile && enVol == that.enVol && Daniyal == that.Daniyal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbMissile, enVol, Daniyal);
    }
}
