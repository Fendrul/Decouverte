package be.technifutur.decouverte.constructeur;

public class TestConstructeur {

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c);
    }
}

class C extends B {
    int cpt;

    C() {
        super(getVal());
        System.out.println("UwU");
        //texte = "Oui, bonjour";
    }

    private static int getVal() {
        return 18;
    }

    @Override
    public String toString() {
        return "C{" +
                "cpt=" + cpt +
                ", flag=" + flag +
                ", texte='" + texte + '\'' +
                '}';
    }
}

class B extends A {
    boolean not;
    boolean flag = true;

    B(int val) {
        super(val);
        System.out.println("OwO");
        texte = "Non, pas le mardi";
    }


}

class A {
    String texte = "la tarte au venin de vipère";


    A(int val) {
        System.out.println(">WO");
        texte = "Les macarons, c'est foudroyant";
    }

}
