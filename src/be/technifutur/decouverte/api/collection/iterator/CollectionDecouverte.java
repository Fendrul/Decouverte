package be.technifutur.decouverte.api.collection.iterator;

import be.technifutur.decouverte.api.collection.data.Personne;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDecouverte {

    public static void main(String[] args) {
        Personne[] personneTab = Personne.dataTest();
        Collection<Personne> personneCollection = new ArrayList<>();
        personneCollection.add(personneTab[0]);
        personneCollection.add(personneTab[0]);
        personneCollection.add(personneTab[1]);

        for (Personne p :
                personneCollection) {
            System.out.println(p);
        }
    }


}
