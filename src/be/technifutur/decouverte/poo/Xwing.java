package be.technifutur.decouverte.poo;

public class Xwing extends VaisseauAncetre {

    public Xwing(int nbMissiles) {
        super(nbMissiles);
    }

    @Override
    public void afficherCamp() {
        System.out.println("Je suis un vaisseau de l'empire !");
    }
}
