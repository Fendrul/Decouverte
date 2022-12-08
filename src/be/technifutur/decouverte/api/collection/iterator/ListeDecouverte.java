package be.technifutur.decouverte.api.collection.iterator;

import be.technifutur.decouverte.api.collection.data.Personne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListeDecouverte {

    public static void main(String[] args) {

        Personne[] dataTest = Personne.dataTest();
        List<Personne> maListe = new ArrayList<>(Arrays.asList(dataTest));
        maListe = new LinkedList<>(Arrays.asList(dataTest));

        maListe.size();
        maListe.add(2, dataTest[5]);
        List<Personne> sousList = maListe.subList(3, 7);


        for (Personne p :
                maListe) {
            System.out.println(p);
        }

        System.out.println("-----------------------");
        for (Personne p :
                sousList) {
            System.out.println(p);
        }


    }
}
