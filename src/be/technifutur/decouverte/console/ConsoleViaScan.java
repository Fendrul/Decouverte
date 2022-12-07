package be.technifutur.decouverte.console;

public class ConsoleViaScan implements Console {

    public int iInput = 0;
    @Override
    public int iScan() {
        int returnValue;

        try {
            returnValue = Integer.parseInt(scan.nextLine());
        } catch (IllegalArgumentException iae) {
            throw iae;
        }

        return returnValue;
    }

    public boolean iScanBorne(int borneInferieure, int borneSuperieure) {
        iInput = Integer.parseInt(scan.nextLine());

        return iInput >= borneInferieure && iInput <= borneSuperieure;
    }

    @Override
    public int ReturniInput() {
        int tempIIinput = iInput;
        iInput = 0;
        return tempIIinput;
    }

    @Override
    public String sInput() {
        return scan.nextLine() ;
    }

    @Override
    public char cInput() {
        return scan.next().charAt(0);
    }

    @Override
    public void affichage(String... values) {

    }
}
