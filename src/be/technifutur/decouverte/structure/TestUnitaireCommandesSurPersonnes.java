package be.technifutur.decouverte.structure;

public class TestUnitaireCommandesSurPersonnes {

    public static void main(String[] args) {
        GPersonnes GUsers = new GPersonnes(20);

        System.out.println("-------------------------------Test des commandes sur les usagers-------------------------------");
        Personne usager;
        System.out.println();

        usager = new Personne("Simon", "Strykers", 28, 10, 1997);
        GUsers.AjoutPersonne(usager);
        usager = new Personne("Mimi", "Mati", 8, 7, 1957);
        GUsers.AjoutPersonne(usager);
        usager = new Personne("Mimi", "Stronghold", 28, 9, 1975);
        GUsers.AjoutPersonne(usager);
        usager = new Personne("Chantal", "Goya", 10, 6, 1942);
        GUsers.AjoutPersonne(usager);
        usager = new Personne("Johnny", "Hallyday", 15, 6, 1943);
        GUsers.AjoutPersonne(usager);
        usager = new Personne("Daniyal", "Yunusau", 1, 3, 1996);
        GUsers.AjoutPersonne(usager);

        GUsers.AffichageListePersonnes();

        /*System.out.println("-------------------------------Test de la suppression-------------------------------");
        System.out.println();

        GUsers.SupressionPersonne(4);
        GUsers.AffichageListePersonnes();*/

        /*System.out.println("-------------------------------Test de la modification-------------------------------");
        System.out.println();

        usager = GUsers.RetourPersonne(0);
        usager.ModifNom("bestboi");

        usager = GUsers.RetourPersonne(1);
        usager.ModifDate(9, 9, 9999);

        usager = GUsers.RetourPersonne(2);
        usager.ModifPrenom("chupachups");

        GUsers.AffichageListePersonnes();*/

        /*System.out.println("-------------------------------Test de la recherche-------------------------------");
        System.out.println();

        GUsers.recherche("Mimi");*/
    }
}