package be.technifutur.decouverte.poo;

public class DeathStar {

    public void attirerVaisseau(VaisseauAncetre v) {
        if (v instanceof Millenium) {
            this.attireVaisseau((Millenium)v);
        } else
        System.out.println("DeathStar.attirerVaisseau");
        v.atterrir();
        v.afficherCamp();
        v.tirer();
        v.decoller();
    }

    public void attireVaisseau(Millenium m) {
        m.atterrir();
        m.afficherCamp();
        System.out.println("ALED OBI WAN");
        m.decoller();
        m.vitesseLumiere();
    }
}
