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

    public int NbPersonnes() {
        return nbPersonnes;
    }
}
