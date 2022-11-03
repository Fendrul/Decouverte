package be.technifutur.decouverte.structure;

public class GPersonnes {
    int nbPersonnes;
    Personne[] listePersonne;

    GPersonnes(int nbMaxPersonnes) {
        nbPersonnes = 0;
        listePersonne = new Personne[nbMaxPersonnes];
    }

    public void AjoutPersonne(String nomSaisi, String prenomSaisi, int jourSaisi, int moisSaisi, int anneeSaisie) {
        listePersonne[nbPersonnes] = new Personne(nomSaisi, prenomSaisi, jourSaisi, moisSaisi, anneeSaisie);
        nbPersonnes++;
    }

    public void AffichageListe() {
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

    public int NbPersonnes() {
        return nbPersonnes;
    }
}
