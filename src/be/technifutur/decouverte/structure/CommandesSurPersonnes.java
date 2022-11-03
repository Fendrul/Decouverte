package be.technifutur.decouverte.structure;

public class CommandesSurPersonnes {
    private static final int nbMaxPersonnes = 20;

    public static void main(String[] args) {
        GPersonnes GUsagers = new GPersonnes(nbMaxPersonnes);
        Console cons = new Console();
        boolean continueProcessus = true;
        int input = 0;

        Personne simon = new Personne("Simon", "Strykers", 28, 10, 1997);
        GUsagers.AjoutPersonne(simon);

        while (continueProcessus) {
            System.out.println("Quelle opération voulez-vous faire ?");
            System.out.println("0 - sortie");
            System.out.println("1 - ajouter une personne");
            System.out.println("2 - lister les personnes");
            System.out.println("3 - supprimer une personne");
            System.out.println("4 - modifier une personne");

            while (!cons.iScanBorne(0, 4)) {
                System.out.println("Mauvaise saisie, recommencez.");
            }
            input = cons.ReturniInput();

            switch (input) {
                case 0:
                    continueProcessus = false;
                    break;

                case 1:
                    AjoutUsager(GUsagers);
                    break;

                case 2:
                    if (GUsagers.NbPersonnes() == 0) {
                        System.out.println("Aucune personne à afficher, tu espérais quoi ?");
                    } else {
                        GUsagers.AffichageListePersonnes();
                    }
                    break;

                case 3:
                    if (GUsagers.NbPersonnes() == 0) {
                        System.out.println("Aucune personne à supprimer, tu espérais quoi ?");
                    } else {
                        System.out.println("Entrez le numéro de la personne à supprimer");

                        while (!cons.iScanBorne(1, GUsagers.NbPersonnes())) {
                            System.out.println("Vous avez entré une coordonnée invalide");
                        }
                        input = cons.ReturniInput();

                        GUsagers.SupressionPersonne(input);
                    }
                    break;

                case 4:
                    if (GUsagers.NbPersonnes() == 0) {
                        System.out.println("Aucune personne à modifier, tu espérais quoi ?");
                    } else {
                        System.out.println("Entrez le numéro de la personne à modifier");

                        while (!cons.iScanBorne(1, GUsagers.NbPersonnes())) {
                            System.out.println("Vous avez entré une coordonnée invalide");
                        }
                        input = cons.ReturniInput();

                        ModifPersonne(GUsagers, input - 1);
                    }
                    break;
            }
        }
    }

    private static void AjoutUsager(GPersonnes GUsager) {
        Console cons = new Console();
        Personne usager;
        String nom;
        String prenom;
        int jour;
        int mois;
        int annee;

        System.out.println("Entrez son prénom");
        prenom = cons.sInput();
        System.out.println("Entrez son nom");
        nom = cons.sInput();

        System.out.println("Quel jour est-il né ?");

        while (!cons.iScanBorne(1, 31)) {
            System.out.println("Ne soyez pas trop stupides quand même, entrez un jour un minimum valide au moins dans un cas posible.");
        }
        jour = cons.ReturniInput();

        System.out.println("Quel mois est-il né ?");
        while (!cons.iScanBorne(1, 12)) {
            System.out.println("Ne soyez pas trop stupides quand même, entrez un moi un minimum valide au moins dans un cas posible.");
        }
        mois = cons.ReturniInput();

        System.out.println("Quelle année est-il né ?");
        while (!cons.iScanBorne(1900, 2022)) {
            System.out.println("Ne soyez pas trop stupides quand même, entrez une année un minimum valide au moins dans un cas posible.");
        }
        annee = cons.ReturniInput();

        usager = new Personne(prenom, nom, jour, mois, annee);
        GUsager.AjoutPersonne(usager);
    }

    private static void ModifPersonne(GPersonnes GUsagers, int indiceUsager) {
        Personne usager = GUsagers.RetourPersonne(indiceUsager);
        boolean modifications = true;
        int input = 0;
        Console cons = new Console();

        usager.AffichagePersonne();

        while (modifications) {
            System.out.println("Que voulez-vous modifier ?");
            System.out.println("1 - le prénom");
            System.out.println("2 - le nom");
            System.out.println("3 - la date");

            while (!cons.iScanBorne(1, 3)) {
                System.out.println("Mauvaise saisie, recommencez.");
            }
            input = cons.ReturniInput();

            switch (input) {
                case 1:
                    System.out.println("Entrez le nouveau prénom");
                    usager.ModifPrenom(cons.sInput());
                    break;

                case 2:
                    System.out.println("Entrez le nouveau nom");
                    usager.ModifNom(cons.sInput());
                    break;

                case 3:
                    int jour;
                    int mois;
                    int annee;

                    System.out.println("Entrez la nouvelle date");
                    System.out.print("jour : ");
                    jour = cons.iScan();
                    System.out.println();

                    System.out.print("mois : ");
                    mois = cons.iScan();
                    System.out.println();

                    System.out.print("annee : ");
                    annee = cons.iScan();
                    System.out.println();

                    usager.ModifDate(jour, mois, annee);
            }

            System.out.println("Voulez-vous encore apporter des modifications ? 0: NON / 1: Oui");

            while (!cons.iScanBorne(0, 1)) {
                System.out.println("mauvaise entrée");
            }
            input = cons.ReturniInput();

            if (input == 0)
                modifications = false;
        }
    }
}