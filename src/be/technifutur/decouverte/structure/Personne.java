
package be.technifutur.decouverte.structure;
public class Personne {
    public String nom;
    public String prenom;
    public MaDate naissance;

    Personne() {}

    Personne(String prenomSaisi, String nomSaisi, int jourSaisi, int moisSaisi, int anneeSaisie) {
        prenom = prenomSaisi;
        nom = nomSaisi;

        naissance = new MaDate(jourSaisi, moisSaisi, anneeSaisie);
    }

    public void AffichagePersonne() {
        System.out.print("Le prénom de la personne est ");
        System.out.print(prenom);
        System.out.print(" et son nom est ");
        System.out.println(nom);
        System.out.print("Cette personne est née le ");
        naissance.AffichageDate();
        System.out.println();
        System.out.println();
    }

    public void ModifPrenom(String nouveauPrenom) {
        prenom = nouveauPrenom;
    }

    public void ModifNom(String nouveauNom) {
        nom = nouveauNom;
    }

    public void ModifDate(int nouveauJour, int nouveauMois, int nouveleAnnee) {
        naissance.ModifDate(nouveauJour, nouveauMois, nouveleAnnee);
    }
}