package be.technifutur.decouverte.poo;

public class Clone extends Empire {
    public Clone() {
        this("Clone");
    }

    public Clone(String nom){
        super(nom);
    }

    @Override
    public void combattre() {
        System.out.println("je combat comme Clone");
    }
}
