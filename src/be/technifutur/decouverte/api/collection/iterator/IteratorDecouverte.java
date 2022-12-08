package be.technifutur.decouverte.api.collection.iterator;

import be.technifutur.decouverte.api.collection.data.Personne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorDecouverte {

    public static void main(String[] args) {
        Personne[] personneTab = Personne.dataTest();
        List<Personne> personneList = Arrays.asList(personneTab);
        List<Personne> personneListModifiable = new ArrayList<>(personneList);
        Iterator<Personne> iterator = personneList.iterator();
//        testIterator(iterator);
        testIterable(personneList);
    }


    private static void testIterator(Iterator<Personne> iterator2) {
        boolean b = iterator2.hasNext();
        System.out.println(iterator2.next());
        System.out.println(iterator2.next().getName());
    }

    private static void testIterable(Iterable<Personne> iterable) {
        for (Personne x : iterable) {
            System.out.println(x.getName() + " " + x.getPrenom());
        }
    }
}
