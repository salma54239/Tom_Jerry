public class Cle extends Element {

    public Cle(int x, int y) {
        super(x, y);
    }

    // La souris ramasse la clé
    @Override
    public void interagir(Souris souris) {
        souris.GrabKey();
    }

    @Override
    public char getSymbole() {
        return 'K';
    }
}