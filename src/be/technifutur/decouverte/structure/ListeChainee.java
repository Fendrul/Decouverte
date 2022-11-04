package be.technifutur.decouverte.structure;

public class ListeChainee {
    int valeur;
    ListeChainee suivant;



    ListeChainee(int valeurSaisie) {
        valeur = valeurSaisie;
        suivant = null;
    }

    public void ajoutValeur(int nouvelleValeur) {
        if (suivant != null)
            suivant.ajoutValeur(nouvelleValeur);
        else
            suivant = new ListeChainee(nouvelleValeur);
    }

    public void modifValeur(int index, int valeurInseree) {
        if (index > 1)
            suivant.modifValeur(index - 1, valeurInseree);
        else
            valeur = valeurInseree;
    }

    /*public ListeChainee supprValeur(int index) {
        if (index > 1)
            suivant.supprValeur(index - 1);
        else
            suivant = suivant.suivant;
    }*/

    public int longueur() {
        if (suivant != null)
            return 1 + suivant.longueur();
        else
            return 1;
    }

    public void affichage() {
        System.out.println(valeur);

        if (suivant != null)
            suivant.affichage();
    }
}

