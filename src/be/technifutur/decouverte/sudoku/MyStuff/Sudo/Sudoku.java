package be.technifutur.decouverte.sudoku.MyStuff.Sudo;

public class Sudoku implements SudokuModel {

    public int nombre, quantitePossible;
    public int[] possible = new int[16];

    public static boolean VerifDoublon(Sudoku[][] tableau, int i, int j, int verif) {

        return DoublonLigneColonne(tableau, i, j, verif) || DoublonMatrice(tableau, i, j, verif);
    }

    public static boolean DoublonLigneColonne(Sudoku[][] tableau, int i, int j, int verif) {
        int testI = 0, testJ = 0, taille = tableau.length;

        for (testI = 0; testI < taille; testI++) {
            if (tableau[testI][j].nombre == verif)
                return true;

        }

        for (testJ = 0; testJ < taille; testJ++) {
            if (tableau[i][testJ].nombre == verif)
                return true;

        }
        return false;


    }

    public static boolean DoublonMatrice(Sudoku[][] tab, int i, int j, int verif) {
        int max = (int) Math.sqrt(tab.length);
        i = i - (i % max);
        int iniJ = j - (j % max);
        int maxI = i + 3, maxJ = iniJ + max;

        for (; i < maxI; i++) {
            for (j = iniJ; j < maxJ; j++) {
                if (verif == tab[i][j].nombre)
                    return true;
            }

        }

        return false;
    }

    public static void Initialiser(Sudoku[][] tab, int taille) {

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                tab[i][j] = new Sudoku();
                tab[i][j].nombre = 0;
                tab[i][j].quantitePossible = 0;
                for (int k = 0; k < taille; k++) {
                    tab[i][j].possible[k] = 0;

                }

            }

        }

    }

    public static boolean VerifPosssible(Sudoku[][] tab, int i, int j, int verif) {
        int k = 0, taille = tab.length;

        for (; k < taille; k++) {
            if (tab[i][j].possible[k] == verif)
                return true;
        }

        return false;
    }

    public static void AjoutPossibler(Sudoku tab[][], int i, int j, int ajout) {
        int k = 0, taille = tab.length;

        while (k < taille) {
            if (tab[i][j].possible[k] == 0) {
                tab[i][j].possible[k] = ajout;
                k = taille;
            }

            k++;
        }

    }

    public static void ReinitialisePossible(Sudoku tab[][], int i) {
        int j = 0, k = 0, taille = tab.length;

        for (j = 0; j < taille; j++) {
            tab[i][j].quantitePossible = 0;

            for (k = 0; k < taille; k++)
                tab[i][j].possible[k] = 0;
        }

    }

    public static void ReinitialiserLigne(Sudoku tab[][], int i) {
        int j = 0, taille = tab.length;

        for (j = 0; j < taille; j++)
            tab[i][j].nombre = 0;
    }

    public static void ReinitialiseSudoku(Sudoku tab[][]) {
        int i = 0, j = 0, taille = tab.length;

        for (i = 0; i < taille; i++) {
            for (j = 0; j < taille; j++)
                tab[i][j].nombre = 0;

        }

    }

    public static void CacherNombres(Sudoku tab[][], int difficulte) {
        int i = 0, j = 0, k = 0, l = 0, suppression = 0, taille = tab.length;
        if (taille > 9)
            difficulte *= 4;

        // Enl�ve dans les matrices

        for (suppression = 0; suppression < difficulte && suppression < 4; suppression++) {
            int max = (int) Math.sqrt(tab.length);
            for (i = 0; i < max; i++) {
                for (j = 0; j < max; j++) {
                    if (!VerifMatriceVide(tab, i, j)) {
                        do {
                            k = (int) (Math.random() * max);
                            l = (int) (Math.random() * max);
                        } while (tab[(i * max) + k][(j * max) + l].nombre == 0);

                    }

                    tab[(i * max) + k][(j * max) + l].nombre = 0;

                }

            }

        }

        suppression = 0;

        while (suppression < difficulte - 2 || suppression == 0) {


            // Enl�ve dans les lignes

            for (i = 0; i < taille; i++) {
                if (!VerifLigneVide(tab, i)) {
                    do {
                        j = (int) (Math.random() * taille);
                    } while (tab[i][j].nombre == 0);

                    tab[i][j].nombre = 0;

                }

                suppression++;

            }

            //Enl�ve dans les colonnes

            for (j = 0; j < taille; j++) {
                if (!VerifColonneVide(tab, j)) {
                    do {
                        i = (int) (Math.random() * taille);
                    } while (tab[i][j].nombre == 0);

                    tab[i][j].nombre = 0;

                }

            }

            suppression++;

        }


    }

    public static String AfficheVideSiZero(int nombre, int taille) {
        String resultat = String.valueOf(nombre);

        if (nombre != 0)
            if (nombre < 10 && taille > 9)
                return " " + resultat;
            else
                return resultat;
        else if (taille > 9)
            return "  ";
        else
            return " ";

    }

    public static boolean VerifLigneVide(Sudoku tab[][], int i) {
        int j = 0, taille = tab.length;
        ;

        for (j = 0; j < taille; j++) {
            if (tab[i][j].nombre != 0)
                return false;
        }

        return true;
    }

    public static boolean VerifColonneVide(Sudoku tab[][], int j) {
        int i = 0, taille = tab.length;

        for (i = 0; i < taille; i++) {
            if (tab[i][j].nombre != 0)
                return false;
        }

        return true;
    }

    public static boolean VerifMatriceVide(Sudoku tab[][], int i, int j) {
        int max = (int) Math.sqrt(tab.length);
        i = i - (i % max);
        int iniJ = j - (j % max);
        int maxI = i + max, maxJ = iniJ + max;

        for (; i < maxI; i++) {
            for (j = iniJ; j < maxJ; j++) {
                if (tab[i][j].nombre != 0)
                    return false;
            }

        }

        return true;

    }

    public static void CopieSudoku(Sudoku tab1[][], Sudoku tab2[][]) {
        int i = 0, j = 0, taille = tab1.length;

        for (i = 0; i < taille; i++) {
            for (j = 0; j < taille; j++) {
                tab2[i][j].nombre = tab1[i][j].nombre;

            }

        }

    }
}
