package be.technifutur.decouverte.structure;

public class MaDate {
    public int jour;
    public int mois;
    public int annee;

    MaDate() {}
    MaDate(int jourSaisi, int moisSaisi, int anneeSaisie) {
        jour = jourSaisi;
        mois = moisSaisi;
        annee = anneeSaisie;
    }

    public void AffichageDate() {
        System.out.print(jour);
        System.out.print("/");
        System.out.print(mois);
        System.out.print("/");
        System.out.print(annee);
    }

    public void ModifDate(int nouveauJour, int nouveauMois, int nouveleAnnee) {
        jour = nouveauJour;
        mois = nouveauMois;
        annee = nouveleAnnee;
    }
}