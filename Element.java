public abstract class Element {

    protected int x;
    protected int y;

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Change la position de l'élément
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Vrai si la souris peut marcher sur cette case
    public boolean estTraversable(Souris souris) {
        return true;
    }

    public abstract void interagir(Souris souris);

    public abstract char getSymbole();

}