package be.technifutur.decouverte.structure;

public class GPersonnes {
    int nbPersonnes;
    static Personne[] listePersonne;

    GPersonnes(int nbMaxPersonnes) {
        nbPersonnes = 0;
        listePersonne = new Personne[nbMaxPersonnes];
    }

    public void AjoutPersonne(Personne personne) {
        listePersonne[nbPersonnes] = personne;
        nbPersonnes++;
    }

    public void AffichageListePersonnes() {
        for (int i = 0; i < nbPersonnes; i++) {
            listePersonne[i].AffichagePersonne();
        }
    }

    public void SupressionPersonne(int personneASupprimer) {
        for (int i = personneASupprimer; i < nbPersonnes - 1; i++) { // On démarre l'écrasement depuis l'index spécifié par l'utilisateur jusqu'à la fin, pour tout décaler d'une case
            listePersonne[i] = listePersonne[i + 1];
        }

        nbPersonnes--;
    }

    public static Personne RetourPersonne(int indiceUsager) {
        return listePersonne[indiceUsager];
    }

    public void recherche(String recherche) {
        for (int i = 0; i < nbPersonnes; i++) {
            if (listePersonne[i].recherche(recherche)) {
                listePersonne[i].AffichagePersonne();
            }
        }
    }

    public int NbPersonnes() {
        return nbPersonnes;
    }

    /**
     * Trie la liste des utilisateurs suivant le style de tri demandé par le paramètre
     * @param typeTri 1: tri par prénom, 2: tri par nom, 3: tri par date
     */
    public void tri(int typeTri) {
        Personne tempSwap;

        for (int i = 0; i < nbPersonnes; i++) {

        }
    }
}