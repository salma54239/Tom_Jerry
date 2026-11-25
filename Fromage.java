public class Fromage extends Element {

    private int soin;

    public Fromage(int x, int y, int soin) {
        super(x, y);
        this.soin = soin;
    }

    // La souris gagne des points de vie
    @Override
    public void interagir(Souris souris) {
        for (int i = 0; i < soin; i++) {
            souris.GainLife();
        }
    }

    @Override
    public char getSymbole() {
        return 'F';
    }
}