public class Piege extends Element {

    private int degats;

    public Piege(int x, int y, int degats) {
        super(x, y);
        this.degats = degats;
    }

    // La souris perd des points de vie
    @Override
    public void interagir(Souris souris) {
        for (int i = 0; i < degats; i++) {
            souris.LoseLife();
        }
    }

    @Override
    public char getSymbole() {
        return 'X';
    }
}