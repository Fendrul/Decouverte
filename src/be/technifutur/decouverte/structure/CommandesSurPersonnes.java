package be.technifutur.decouverte.structure;

import java.util.Scanner;

public class CommandesSurPersonnes {
    private static final int nbMaxPersonnes = 20;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GPersonnes GUsagers = new GPersonnes(nbMaxPersonnes);
        int nbUsagers = 0;
        int input = 0;

        while (input != 1) {
            System.out.println("Quelle opération voulez-vous faire ?");
            System.out.println("1 - sortie");
            System.out.println("2 - ajouter une personne");
            System.out.println("3 - lister les personnes");
            System.out.println("4 - supprimer une personne");
            System.out.println("5 - modifier une personne");

            input = Integer.parseInt(scan.nextLine());
            while (!VerifBornes(input, 1, 4)) {
                System.out.println("Mauvaise saisie, recommencez.");
                input = Integer.parseInt(scan.nextLine());
            }

            switch (input) {
                case 1:
//                    Permet de ne pas vérifier les conditions du switch si l'utilisateur veut sortir tout de suite
                    break;
                case 2:
                    AjoutUsager(GUsagers);
                    break;
                case 3:
                    if (GUsagers.NbPersonnes() == 0) {
                        System.out.println("Aucune personne à afficher, tu espérais quoi ?");
                    } else {
                        GUsagers.AffichageListe();
                    }
                case 4:
                    if (GUsagers.NbPersonnes() == 0) {
                        System.out.println("Aucune personne à supprimer, tu espérais quoi ?");
                    } else {
                        System.out.println("Entrez le numéro de la personne à supprimer");
                        input = Integer.parseInt(scan.nextLine());

                        while (!VerifBornes(input, 1, nbUsagers)) {
                            System.out.println("Vous avez entré une coorodnée invalide");
                            input = Integer.parseInt(scan.nextLine());
                        }

                        GUsagers.SupressionPersonne(input);
                    }

                    break;
                case 5:
                    if (GUsagers.NbPersonnes() == 0) {
                        System.out.println("Aucune personne à modifier, tu espérais quoi ?");
                    } else {
                        System.out.println("Entrez le numéro de la personne à modifier");
                        input = Integer.parseInt(scan.nextLine());

                        while (!VerifBornes(input, 1, nbUsagers)) {
                            System.out.println("Vous avez entré une coorodnée invalide");
                            input = Integer.parseInt(scan.nextLine());
                        }

//                        ModifPersonne(usagers, input);
                    }

                    break;
            }
        }
    }

    private static void AjoutUsager(GPersonnes GPersonne) {
        Scanner scan = new Scanner(System.in);
        String nom;
        String prenom;
        int jour;
        int mois;
        int annee;

        System.out.println("Entrez son prénom");
        prenom = scan.nextLine();
        System.out.println("Entrez son nom");
        nom = scan.nextLine();

        System.out.println("Quel jour est-il né ?");
        jour = Integer.parseInt(scan.nextLine());
        while (jour < 1 || jour > 31) {
            System.out.println("Ne soyez pas trop stupides quand même, entrez un jour un minimum valide au moins dans un cas posible.");
            jour = Integer.parseInt(scan.nextLine());
        }

        System.out.println("Quel mois est-il né ?");
        mois = Integer.parseInt(scan.nextLine());
        while (mois < 1 || mois > 12) {
            System.out.println("Ne soyez pas trop stupides quand même, entrez un moi un minimum valide au moins dans un cas posible.");
            mois = Integer.parseInt(scan.nextLine());
        }

        System.out.println("Quelle année est-il né ?");
        annee = Integer.parseInt(scan.nextLine());
        while (annee < 1900 || annee > 2022) {
            System.out.println("Ne soyez pas trop stupides quand même, entrez une année un minimum valide au moins dans un cas posible.");
            annee = Integer.parseInt(scan.nextLine());
        }

        GPersonne.AjoutPersonne(nom, prenom, jour, mois, annee);
    }

    private static boolean VerifBornes(int nombreVerifie, int borneInferieure, int borneSuperieure) {
        if (nombreVerifie < borneInferieure || nombreVerifie > borneSuperieure) {
            return false;
        }
        return true;
    }


}
