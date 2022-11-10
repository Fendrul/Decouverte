package be.technifutur.decouverte.poo;

public class Scenario2 {

    public static void main(String[] args) {
        VaisseauMethode v1 = new VaisseauMethode(18);
        VaisseauMethode v2 = new VaisseauMethode();
        VaisseauMethode v3 = new VaisseauMethode();

        v1.tirer();
        v1.tirer();
        v1.tirer();
        v1.tirer();
        v1.tirer();
        v1.tirer();
        v1.tirer();
        v1.recharger();
        v1.recharger(3);
        System.out.println(v1.qttMissiles());

        v1.decoller();
        v1.decoller();
        v1.atterrir();
        v1.atterrir();

        System.out.println(VaisseauMethode.getNbVaisseauxEnVol());
        v2.decoller();
        System.out.println(VaisseauMethode.getNbVaisseauxEnVol());
        v3.decoller();
        System.out.println(VaisseauMethode.getNbVaisseauxEnVol());
        v1.decoller();
        System.out.println(VaisseauMethode.getNbVaisseauxEnVol());


    }
}
