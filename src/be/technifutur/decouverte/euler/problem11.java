package be.technifutur.decouverte.euler;

import be.technifutur.decouverte.console.ConsoleViaFichier;

import java.io.IOException;

public class problem11 {

    public static final int DIRECTION_SIZE = 4;

    public static void main(String[] args) throws IOException {
        ConsoleViaFichier cons = new ConsoleViaFichier("src\\be\\technifutur\\decouverte\\euler\\ressources\\problem11.txt");
        int[][] tab = cons.intTab(" ");
        int tabLength = tab.length;
        int tabWidth = tab[0].length;
        int maxProduct = 0;

        for (int i = 0; i < tabLength - DIRECTION_SIZE; i++) {
            for (int j = 0; j < tabWidth; j++) {
                    int[] products = new int[4];
                
                if (j < tabWidth - DIRECTION_SIZE) {
                    products[0] = verifRight(tab, i, j);
                    products[1] = verifDiagRight(tab, i, j);
                }
                if (j >= DIRECTION_SIZE)
                    products[2] = verifDiagLeft(tab, i, j);
                
                products[3] = verifDown(tab, i, j);

                for (int product :
                        products) {
                    maxProduct = Math.max(product, maxProduct);
                }
            }
        }

        System.out.println(maxProduct);
    }

    private static int verifDown(int[][] tab, int i, int j) {
        int result = 1;

        for (int k = 0; k < DIRECTION_SIZE; k++) {
            result *= tab[i+k][j];
        }

        return result;
    }

    private static int verifDiagLeft(int[][] tab, int i, int j) {
        int result = 1;

        for (int k = 0; k < DIRECTION_SIZE; k++) {
            result *= tab[i+k][j-k];
        }

        return result;
    }

    private static int verifDiagRight(int[][] tab, int i, int j) {
        int result = 1;

        for (int k = 0; k < DIRECTION_SIZE; k++) {
            result *= tab[i+k][j+k];
        }

        return result;
    }

    private static int verifRight(int[][] tab, int i, int j) {
        int result = 1;

        for (int k = 0; k < DIRECTION_SIZE; k++) {
            result *= tab[i][j+k];
        }
        return result;
    }
}
