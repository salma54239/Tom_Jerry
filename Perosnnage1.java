public abstract class Personnage {
    private String nom;
    private int pointsDeVie;
    private int x;
    private int y;

    public Personnage(String nom, int pointsDeVie) {
        setNom(nom);
        setPointsDeVie(pointsDeVie);
        this.x = 0;
        this.y = 0;
    }

    public Personnage(String nom, int pointsDeVie, int x, int y) {
        setNom(nom);
        setPointsDeVie(pointsDeVie);
        setPosition(x, y);
    }

    public void deplacer(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void subirDegats(int degats) {
        if (degats > 0) {
            this.pointsDeVie = Math.max(0, this.pointsDeVie - degats);
        }
    }

    public void soigner(int pv) {
        if (pv > 0 && estVivant()) {
            this.pointsDeVie = (int) Math.min(Integer.MAX_VALUE, (long) this.pointsDeVie + pv);
        }
    }

    public boolean estVivant() {
        return this.pointsDeVie > 0;
    }

    public abstract void attaquer(Personnage cible);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public String getNom() {
        return nom;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void setNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être null ou vide.");
        }
        this.nom = nom;
    }

    private void setPointsDeVie(int pointsDeVie) {
        if (pointsDeVie < 0) {
            throw new IllegalArgumentException("Les points de vie ne peuvent pas être négatifs.");
        }
        this.pointsDeVie = pointsDeVie;
    }
}
