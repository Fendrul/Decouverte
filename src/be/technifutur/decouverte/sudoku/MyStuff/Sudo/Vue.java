package be.technifutur.decouverte.sudoku.MyStuff.Sudo;

public class Vue {
    public static void AfficherSudoku(Sudoku[][] tab) {
        int i = 0, j = 0, taille = tab.length, max = (int) Math.sqrt(tab.length), longueurLigne = 0;
        String ligne = "";

        if (taille == 9)
            ligne = "-------";
        else
            ligne = "-------------";

        for (; i < taille; i++) {
            for (j = 0; j < taille; j++) {

                if (j % max == max - 1 && j != taille - 1)
                    System.out.print(Sudoku.AfficheVideSiZero(tab[i][j].nombre, taille) + " | ");
                else
                    System.out.print(Sudoku.AfficheVideSiZero(tab[i][j].nombre, taille) + " ");


            }

            System.out.println();
            if (i % max == max - 1 && i != taille - 1) {
                for (longueurLigne = 0; longueurLigne < max; longueurLigne++)
                    System.out.print(ligne);

                System.out.println();

            }

        }

    }
}
