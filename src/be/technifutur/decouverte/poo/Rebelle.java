package be.technifutur.decouverte.poo;

public abstract class Rebelle extends Personnage {
    public Rebelle(String nom) {
        super(nom);
    }

    @Override
    public Object afficheCamps() {
        System.out.println("je suis un rebelle");
        return null;
    }
}
