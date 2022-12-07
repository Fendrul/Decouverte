package be.technifutur.decouverte.poo2;


public abstract class Personnage {
    private String nom;

    public void Personnage(String nomInsere) {
        nom = nomInsere;
    }

    public String getNom() {
        return nom;
    }

    abstract void afficheCamp();

    abstract void combattre();
}
