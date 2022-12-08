package be.technifutur.decouverte.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem8 {
    public static void main(String[] args) {
        TableauNombre tableauNombre = new TableauNombre();

        tableauNombre.ajoutNombres("73167176531330624919225119674426574742355349194934");
        tableauNombre.ajoutNombres("96983520312774506326239578318016984801869478851843");
        tableauNombre.ajoutNombres("85861560789112949495459501737958331952853208805511");
        tableauNombre.ajoutNombres("12540698747158523863050715693290963295227443043557");
        tableauNombre.ajoutNombres("66896648950445244523161731856403098711121722383113");
        tableauNombre.ajoutNombres("62229893423380308135336276614282806444486645238749");
        tableauNombre.ajoutNombres("30358907296290491560440772390713810515859307960866");
        tableauNombre.ajoutNombres("70172427121883998797908792274921901699720888093776");
        tableauNombre.ajoutNombres("65727333001053367881220235421809751254540594752243");
        tableauNombre.ajoutNombres("52584907711670556013604839586446706324415722155397");
        tableauNombre.ajoutNombres("53697817977846174064955149290862569321978468622482");
        tableauNombre.ajoutNombres("83972241375657056057490261407972968652414535100474");
        tableauNombre.ajoutNombres("82166370484403199890008895243450658541227588666881");
        tableauNombre.ajoutNombres("16427171479924442928230863465674813919123162824586");
        tableauNombre.ajoutNombres("17866458359124566529476545682848912883142607690042");
        tableauNombre.ajoutNombres("24219022671055626321111109370544217506941658960408");
        tableauNombre.ajoutNombres("07198403850962455444362981230987879927244284909188");
        tableauNombre.ajoutNombres("84580156166097919133875499200524063689912560717606");
        tableauNombre.ajoutNombres("05886116467109405077541002256983155200055935729725");
        tableauNombre.ajoutNombres("71636269561882670428252483600823257530420752963450");

        int result = tableauNombre.findGreatestProduct(13);
    }

    private static class TableauNombre {
        private List<Integer> nombres = new ArrayList<>();

        public void ajoutNombres(String s) {
            int taille = s.length();
            List<Integer> nouveauxNombres = new ArrayList<>();

            for (int i = 0; i < taille; i++) {
                nouveauxNombres.add(Character.getNumericValue(s.charAt(i)));
            }

            nombres.addAll(nouveauxNombres);
        }

        public int findGreatestProduct(int quantiteNombresAdjacents) {
            int result = 0;
            int calc = 0;
            int lengthNumbers = nombres.size();

            for (int i = 0; i < lengthNumbers; i++) {
                calc = ProductFromArray(nombres.subList(i, i + quantiteNombresAdjacents).toArray());
            }
            
            return result;
        }

        private int ProductFromArray(Object[] toArray) {
        }

        @Override
        public String toString() {
            return "Tableaunombre{" +
                    "tableauNombre=" + nombres +
                    '}';
        }
    }
}
