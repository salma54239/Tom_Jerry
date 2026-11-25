public class Chat extends Personnage {
    public Chat(String p_nom, int p_pointsDeVie, int p_xPosition, int p_yPosition) {
        super(p_nom, p_pointsDeVie, p_xPosition, p_yPosition);
    }

    public void Mouvement(int p_x, int p_y) {
        this.xPosition += p_x;
        this.yPosition += p_y;
    }

    public void Attaque(Souris p_souris) {
        p_souris.LoseLife();
    }

}