package be.technifutur.decouverte.api.collection.iterator;

import be.technifutur.decouverte.api.collection.data.Personne;
import com.sun.source.tree.Tree;

import java.util.*;

public class MapDecouverte {

    public static void main(String[] args) {
        Map<Integer, Personne> maMap = new LinkedHashMap<>();

        for (Personne p :
                Personne.dataTest()) {
            maMap.put(p.getAge(), p);
        }

//        for (Integer i :
//                maMap.keySet()) {
//            System.out.printf("age: %s, personne: %s",i,maMap.get(i));
//        }


        Map<Integer, Set<Personne>> calendrier = new TreeMap<>();
        for (Personne p :
                Personne.dataTest()) {
            int age = p.getAge();
            Set<Personne> set = calendrier.computeIfAbsent(age, k -> new HashSet<>());
            set.add(p);

        }

        for (Integer i :
                calendrier.keySet()) {
            System.out.printf("age : %s, personne : %s\n", i, calendrier.get(i));
        }

    }
}
