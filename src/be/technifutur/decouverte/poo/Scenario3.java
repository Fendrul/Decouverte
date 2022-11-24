package be.technifutur.decouverte.poo;

public class Scenario3 {

    public static void main(String[] args) {
        Millenium v1 = new Millenium();
        Xwing v2 = new Xwing(16);
        VaisseauAncetre v3 = v1;
        VaisseauAncetre v4 = new VaisseauAncetre(28);
        v4 = v1;
        DeathStar ds = new DeathStar();

//        v1.tirer();
//        v2.tirer();
//
//        v1.vitesseLumiere();

//        v1.vitesseLumiere().tirerFort().vitesseLumiere().tirerFort().autoDestruction();

//        v1.afficherCamp();
//        v2.afficherCamp();
//        v3.afficherCamp();
//        v4.afficherCamp();

        ds.attirerVaisseau(v3);
        System.out.println();
        ds.attirerVaisseau(v1);


    }
}
