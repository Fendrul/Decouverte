package be.technifutur.decouverte.poo;

public abstract class Empire extends Personnage{
    public Empire(String nom) {
        super(nom);
    }

    @Override
    public Object afficheCamps() {
        System.out.println("Je suis fidèle à l'empire");
        return null;
    }
}
