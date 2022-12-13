package be.technifutur.decouverte.euler;

import be.technifutur.decouverte.console.ConsoleViaFichier;

import java.io.IOException;

public class problem67 {
    public static void main(String[] args) throws IOException {
        ConsoleViaFichier cons = new ConsoleViaFichier("src\\be\\technifutur\\decouverte\\euler\\ressources\\problem67.txt");

        int[][] tab = cons.intTab(" ");
        int tabLength = tab.length;

        for (int depth = tabLength - 2; depth >= 0; depth--) {
            for (int length = 0; length <= depth; length++) {
                tab[depth][length] = sumNodes(tab, depth, length);
            }
        }

        System.out.println(tab[0][0]);
    }

    private static int sumNodes(int[][] tab, int depth, int length) {
        int result;
        int tempResult;

        result = tab[depth][length] + tab[depth + 1][length];
        tempResult = tab[depth][length] + tab[depth + 1][length + 1];

        if (tempResult > result)
            result = tempResult;

        return result;
    }


}
