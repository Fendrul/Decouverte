package be.technifutur.decouverte.sudoku.MyStuff;

import be.technifutur.decouverte.sudoku.MyStruct.*;
import be.technifutur.decouverte.sudoku.MyStuff.Sudo.Sudoku;
import be.technifutur.decouverte.sudoku.MyStuff.Sudo.Vue;

public class Main {

    public static void main(String[] args) {
        IdentifiantMinPossible plusPetit = new IdentifiantMinPossible();
        int i = 0, j = 0, testJ = 0, temp = 0, compteurErreur = 0, taille = 0, difficulte = 0, input = 0;

        System.out.println("Je vous propose de choisir la taille de votre sudoku. \nJe peux faire un 3 x 3 ou un 4 x 4.");
        taille = (int) Verif.Input(3, 4, taille);
        taille *= taille;
        Sudoku[][] tableau = new Sudoku[taille][taille], correction = new Sudoku[taille][taille];
        System.out.println("Quelle difficult� voulez-vous ?");
        System.out.println("1: Facile \n2: Moyen \n3: Difficile \n4: Au secours");
        difficulte = (int) Verif.Input(1, 4, difficulte);

        Sudoku.Initialiser(tableau, taille);
        Sudoku.Initialiser(correction, taille);

        while (i < taille) {

            j = 0;
            while (j < taille) {

                testJ = 0;
                plusPetit.j = 0;
                plusPetit.valeur = 0;
                while (testJ < taille) { // Teste toutes les cases d'une ligne pour voir celle o� il y a le moins de possibilit�s

                    if (tableau[i][testJ].nombre == 0) {

                        for (temp = 1; temp <= taille; temp++) {

                            if (!Sudoku.VerifDoublon(tableau, i, testJ, temp)) { // Ajoute dans les valeurs possibles de la case si le programme ne trouve pas de doublon
                                Sudoku.AjoutPossibler(tableau, i, testJ, temp);
                                tableau[i][testJ].quantitePossible++;
                            }

                        }

                        if (tableau[i][testJ].quantitePossible > plusPetit.valeur) { // l'indice colonne (plusPetit.j) prendra la valeur de la case avec le moins de possisbilit�
                            plusPetit.valeur = tableau[i][testJ].quantitePossible;
                            plusPetit.j = testJ;

                        }

                    }

                    testJ++;
                }

                if (plusPetit.valeur == 0) { // S'il y a une case sans solution possible, r�initialise la ligne
                    Sudoku.ReinitialiserLigne(tableau, i);
                    j = 0;
                    compteurErreur = compteurErreur + 1;

                    if (taille == 9 && compteurErreur == 50 || taille == 16 && compteurErreur == 200) { // Si cette r�initialisation �choue � donner une solution pour x fois, r�initialise tout le tableau
                        Sudoku.ReinitialiseSudoku(tableau);
                        compteurErreur = 0;
                        i = 0;

                    }

                } else {
                    do {
                        tableau[i][plusPetit.j].nombre = (int) (Math.random() * (taille) + 1);
                    } while (!Sudoku.VerifPosssible(tableau, i, plusPetit.j, tableau[i][plusPetit.j].nombre)); // Choisi un nombre au hasard correspondant � la liste des nombres possibles
                    j++;

                }

                Sudoku.ReinitialisePossible(tableau, i); // R�initialise la valeur possible des cases apr�s avoir trouv� un nombre ou r�initialis� la ligne

            }

            compteurErreur = 0;
            i++;
        }

        Sudoku.CopieSudoku(tableau, correction);
        Sudoku.CacherNombres(tableau, (int) difficulte);
        Vue.AfficherSudoku(tableau);
        System.out.println();

        System.out.println("Voulez-vous la solution ? 1: Oui 2: Non");
        input = (int) Verif.Input(1, 2, input);

        switch (input) {
            case 1 -> Vue.AfficherSudoku(correction);
            case 2 -> System.out.println("Au revoir !");
        }

    }

}
