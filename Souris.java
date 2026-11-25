public class Souris extends Personnage {
    private int nombreclé;

    public Souris(String p_nom, int p_pointsDeVie, int p_xPosition, int p_yPosition, int p_nombreclé) {
        super(p_nom, p_pointsDeVie, p_xPosition, p_yPosition);
        this.nombreclé = p_nombreclé;
    }

    public int getNombreclé() {
        return nombreclé;
    }

    public void setNombreclé(int p_nombreclé) {
        this.nombreclé = p_nombreclé;
    }

    public void MouvementAvant() {
        xPosition += 1;
    }

    public void MouvementArriere() {
        xPosition -= 1;
    }

    public void MouvementGauche() {
        yPosition -= 1;
    }

    public void MouvementDroite() {
        yPosition += 1;
    }

    public void GrabKey() {
        nombreclé += 1;
    }

    public void LoseKey() {
        nombreclé -= 1;
    }

    public void LoseLife() {
        PointsDeVie -= 1;
    }

    public void GainLife() {
        PointsDeVie += 1;
    }

    public String toString() {
        return "Souris{" +
                "Nom='" + Nom + '\'' +
                ", PointsDeVie=" + PointsDeVie +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", nombreclé=" + nombreclé +
                '}';
    }

    public int getCles() {
        return nombreclé;
    }
}