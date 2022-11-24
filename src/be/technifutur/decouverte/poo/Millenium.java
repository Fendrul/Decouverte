package be.technifutur.decouverte.poo;

public class Millenium extends VaisseauAncetre {

    public Millenium() {
        super(20);
    }

    @Override
    public void afficherCamp() {
        System.out.println("Je suis un vaisseau du bien !");
    }

    public Millenium vitesseLumiere() {
        System.out.println("Je passe à la vitesse lumière !");
        return this;
    }

    public Millenium tirerFort() {
        System.out.println("Je tire très fort, comme un millenium !");
        return this;
    }

    public Millenium autoDestruction() {
        System.out.println("Je m'auto-détruit !");
        return this;
    }
}
