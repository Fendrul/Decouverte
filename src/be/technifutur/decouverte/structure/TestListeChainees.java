package be.technifutur.decouverte.structure;

public class TestListeChainees {

    public static void main(String[] args) {
        /*ListeChainee liste = new ListeChainee(15);

        liste.ajoutValeur( -63);
        liste.ajoutValeur(26);
        liste.ajoutValeur(42);
        liste.ajoutValeur(99);
        liste.ajoutValeur(523);
        liste.ajoutValeur(777);

        System.out.println("Voici la liste : ");
        liste.affichage();
        System.out.println();

        System.out.print("Nombre d'éléments dans la liste : ");
        System.out.println(liste.longueur());
        System.out.println();

        liste.modifValeur(1, 1234);
        liste.modifValeur(3, 5678);

        System.out.println("Voici la liste avec les modification  : ");
        liste.affichage();
        System.out.println();

        liste = liste.supprValeur(1);
        liste.affichage();
        System.out.println();*/

        ListeChaineePasObjet listeChainee = new ListeChaineePasObjet();
        ajoutValeur(listeChainee, 15);
        ajoutValeur(listeChainee, 26);
        ajoutValeur(listeChainee, 852);
        ajoutValeur(listeChainee, 42);
        ajoutValeur(listeChainee, 777);
        ajoutValeur(listeChainee, 9632);
        ajoutValeur(listeChainee, 666);

        System.out.println("Voici la liste de base : ");
        affichage(listeChainee);
        System.out.println();

        System.out.print("Dans cette liste, je peux compter ");
        System.out.print(longueur(listeChainee));
        System.out.println(" éléments");
        System.out.println();

        modifValeur(listeChainee, 1, 1234);
        modifValeur(listeChainee, 3, 5678);

        System.out.println("Voici les modifications : ");
        affichage(listeChainee);
        System.out.println();

        System.out.println("Voici la suppression : ");
        listeChainee = suppr(listeChainee, 3);
        affichage(listeChainee);
        System.out.println();

//        renversement(listeChainee);
    }

    /*private static ListeChaineePasObjet renversement(ListeChaineePasObjet listeChainee) {
        if (listeChainee.suivant != null)
            listeChainee.suivant = renversement(listeChainee.suivant);
        else {
            return listeChainee;
        }
    }*/

    private static int longueur(ListeChaineePasObjet listeChainee) {
        if (listeChainee.suivant != null)
            return 1 + longueur(listeChainee.suivant);
        else
            return 0;
    }

    public static void ajoutValeur(ListeChaineePasObjet liste, int valeurSaisie) {
        if (liste.suivant == null) {
            liste.valeur = valeurSaisie;
            liste.suivant = new ListeChaineePasObjet();
        } else
            ajoutValeur(liste.suivant, valeurSaisie);
    }

    private static ListeChaineePasObjet suppr(ListeChaineePasObjet listeChainee, int index) {
        if (index == 1)
            return listeChainee.suivant;
        else
            suppr(listeChainee.suivant, index - 1, false);
            return listeChainee;
    }

    /**
     * Surcharge de suppr, utilisée lorsque l'en-tête n'est pas modifiéé
     * @param entete Pas utilisé dans la fonction, sert juste à savoir si on a dépassé l'en-tête
     */
    private static void suppr(ListeChaineePasObjet listeChainee, int index, boolean entete) {
        if (index > 1)
            suppr(listeChainee, index - 1, false);
        else
            listeChainee.suivant = listeChainee.suivant.suivant;
    }

    private static void modifValeur(ListeChaineePasObjet listeChainee, int index, int valeurInseree) {
        if (index > 2) // Comme la suppression se fait par le remplacement de la référence, on doit l'index + 1
            modifValeur(listeChainee.suivant, index - 1, valeurInseree);
        else
            listeChainee.valeur = valeurInseree;
    }

    private static void affichage(ListeChaineePasObjet listeChainee) {
        if (listeChainee.suivant != null) {
            System.out.println(listeChainee.valeur);
            affichage(listeChainee.suivant);
        }
    }
}