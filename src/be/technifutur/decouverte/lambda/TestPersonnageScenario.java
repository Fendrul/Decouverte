package be.technifutur.decouverte.lambda;

import be.technifutur.decouverte.poo.Jedi;
import be.technifutur.decouverte.poo.Personnage;
import be.technifutur.decouverte.poo.Soldat;

import java.util.function.BiConsumer;

public class TestPersonnageScenario {

    public static void main(String[] args) {
        Soldat soldat = new Soldat("Léon");
        Jedi jedi = new Jedi("Luc");

        PersonnageScenario scenario = new PersonnageScenario(soldat, jedi);

        scenario.addScennette(new BiConsumer<Personnage, Personnage>() {
            @Override
            public void accept(Personnage personnage, Personnage personnage2) {
                System.out.printf("Attention, ");
                personnage.afficheCamps();
                System.out.printf("En garde, ");
                personnage2.afficheCamps();

                System.out.println("\nUn combat à mort se lança entre ces deux protagonistes\n");

                personnage.combattre();
                personnage2.combattre();
                personnage.combattre();

                personnage.combattre();
                System.out.println("et j'ai gagné !");
            }
        });
        //scenario.addScennette();

        scenario.run();
    }
}
