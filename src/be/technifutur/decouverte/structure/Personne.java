
package be.technifutur.decouverte.structure;
public class Personne {
    public String nom;
    public String prenom;
    public MaDate naissance;

    Personne() {}

    Personne(String nomSaisi, String prenomSaisi, int jourSaisi, int moisSaisi, int anneeSaisie) {
        nom = nomSaisi;
        prenom = prenomSaisi;

        naissance = new MaDate(jourSaisi, moisSaisi, anneeSaisie);
    }

    public void AffichagePersonne() {
        System.out.print("Le prénom de la personne est ");
        System.out.print(prenom);
        System.out.print(" et son nom est ");
        System.out.println(nom);
        System.out.print("Cette personne est née le ");
        System.out.print(naissance.jour);
        System.out.print("/");
        System.out.print(naissance.mois);
        System.out.print("/");
        System.out.println(naissance.annee);
        System.out.println();
    }

}
