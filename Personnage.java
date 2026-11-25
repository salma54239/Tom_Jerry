public abstract class Personnage {
    protected String Nom;
    protected int PointsDeVieMax;
    protected int xPosition;
    protected int yPosition;
    protected int PointsDeVie;

    public Personnage(String p_nom, int p_pointsDeVieMax, int p_xPosition, int p_yPosition) {

        if (p_nom == null || p_nom.isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide.");
        }

        if (p_pointsDeVieMax < 0) {
            throw new IllegalArgumentException("Les points de vie max ne peuvent pas être négatifs.");
        }

        this.Nom = p_nom;
        this.PointsDeVieMax = p_pointsDeVieMax;
        this.PointsDeVie = p_pointsDeVieMax;
        this.xPosition = p_xPosition;
        this.yPosition = p_yPosition;
    }

    public void deplacer(int p_dx, int p_dy) {
        xPosition += p_dx;
        yPosition += p_dy;
    }

    public void subirDegats(int p_degats) {
        if (p_degats > 0) {
            PointsDeVie = PointsDeVie - p_degats;

            if (PointsDeVie < 0) {
                PointsDeVie = 0;
            };
        }
    }

    public void soigner(int p_soin) {
        if (p_soin > 0 && estVivant()) {
            PointsDeVie = PointsDeVie + p_soin;
            if (PointsDeVie > PointsDeVieMax) {
                PointsDeVie = PointsDeVieMax;
            }
        }
    }

    public boolean estVivant() {
        return PointsDeVie > 0;
    }

    public abstract void attaquer(Personnage cible);

    public String getNom() {
        return Nom;
    }

    public int getPointsDeVie() {
        return PointsDeVie;
    }

    public int getPointsDeVieMax() {
        return PointsDeVieMax;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    // Setters
    public void setNom(String nom) {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Nom invalide.");
        }
        this.Nom = nom;
    }

    public void setPointsDeVie(int pointsDeVie) {
        if (pointsDeVie < 0) {
            throw new IllegalArgumentException("Points de vie invalides.");
        }
        this.PointsDeVie = pointsDeVie;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
