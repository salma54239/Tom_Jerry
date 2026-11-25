public abstract class Personnage {
    protected String Nom;
    protected int PointsDeVie;
    protected int xPosition;
    protected int yPosition;
    Personnage(String nom, int pointsDeVie) {
        if (nom == null) {
            System.out.print("Le nom ne peut pas être null.");
        }
        if (pointsDeVie < 0) {
             System.out.print("Les points de vie ne peuvent pas être négatifs.");
        }
        public void deplacer(int dx, int dy) {
            xPosition += dx;
            yPosition += dy;
        }

    public void subirDegats(int degats) {
        if (degats > 0) {
            pointsDeVie = Math.max(0, pointsDeVie - degats);
        }
    }

    public void soigner(int soin) {
        if (soin > 0 && estVivant()) {
            pointsDeVie = (int) Math.min(Integer.MAX_VALUE, (long) pointsDeVie + soin);
        }
    }

    public boolean estVivant() {
        return pointsDeVie > 0;
    }

    public abstract void attaquer(Personnage cible);

        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
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
    
}
