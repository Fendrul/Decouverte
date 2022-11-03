package be.technifutur.decouverte.structure;
import java.util.Scanner;
import java.util.Date;

public class TestStructure {

    public static void main(String[] args) {
        Personne client = new Personne();
        /*client.nom = "Strykers";
        client.prenom = "Simon";
        client.naissance = new MaDate();
        client.naissance.annee = 1997;
        client.naissance.mois = 10;
        client.naissance.jour = 28;*/

        SaisirPersonne();

        afficherPersonne(client);

//        System.out.println(DateToString(client.naissance));

    }

    private static Personne SaisirPersonne() {
        Personne personneSaisie = new Personne();
        Scanner scan = new Scanner(System.in);

        System.out.println("Entrez son prénom");
        personneSaisie.prenom = scan.nextLine();
        System.out.println("Entrez son nom");
        personneSaisie.nom = scan.nextLine();



        return personneSaisie;
    }

    private static String DateToString(MaDate date) {
        return String.valueOf(date.jour) + "/" + String.valueOf(date.mois) + "/" + String.valueOf(date.annee);
    }

    public static void afficherPersonne(Personne p) {
        System.out.print("Le prénom de la personne est ");
        System.out.print(p.prenom);
        System.out.print(" et son nom est ");
        System.out.println(p.nom);
        System.out.print("Cette personne est née le ");
        System.out.print(p.naissance.jour);
        System.out.print("/");
        System.out.print(p.naissance.mois);
        System.out.print("/");
        System.out.print(p.naissance.annee);
    }
}
