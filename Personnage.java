public abstract class Personnage {
    protected String Nom;
    protected int PointsDeVie;
    protected int xPosition;
    protected int yPosition;

public Personnage(String p_nom, int p_pointsDeVie, int p_xPosition, int p_yPosition) {
        this.Nom = p_nom;
        this.PointsDeVie = p_pointsDeVie;
        this.xPosition = p_xPosition;
        this.yPosition = p_yPosition;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String p_nom) {
        Nom = p_nom;
    }

    public int getPointsDeVie() {
        return PointsDeVie;
    }

    public void setPointsDeVie(int p_pointsDeVie) {
        PointsDeVie = p_pointsDeVie;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int p_xPosition) {
        this.xPosition = p_xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int p_yPosition) {
        this.yPosition = p_yPosition;
    }  
     // Place le personnage sur la case (x, y)
     public void setPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    // Avance de dx en x et de dy en y
    public void deplacer(int dx, int dy) {
        this.xPosition += dx;
        this.yPosition += dy;
    }

    // Vrai s'il reste des points de vie
    public boolean estVivant() {
        return PointsDeVie > 0;
    }
}