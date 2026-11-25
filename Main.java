import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

    private static final int TAILLE = 50;

    private Labyrinthe jeu;
    private String message = "Ramasse les clés puis va à la porte";

    public Main(Labyrinthe jeu){
        this.jeu = jeu;
        setPreferredSize(new Dimension(12 * TAILLE, 10 * TAILLE + 60));
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ev){
                int touche = ev.getKeyCode();
                if (touche == KeyEvent.VK_UP || touche == KeyEvent.VK_W) bouger(0, -1);
                if (touche == KeyEvent.VK_DOWN || touche == KeyEvent.VK_S) bouger(0, 1);
                if (touche == KeyEvent.VK_LEFT || touche == KeyEvent.VK_A) bouger(-1, 0);
                if (touche == KeyEvent.VK_RIGHT || touche == KeyEvent.VK_D) bouger(1, 0);
            }
        });
    }

    // Fait jouer un tour au labyrinthe, puis met à jour le message et redessine
    private void bouger(int dx, int dy){
        if (jeu.estGagne() || jeu.estPerdu()) {
            return;
        }
        int levelAvant = jeu.getLevelActuel().getNumero();
        String erreur = jeu.jouerTour(dx, dy);

        if (!erreur.equals("")) {
            message = erreur;
        } else if (jeu.getLevelActuel().getNumero() != levelAvant) {
            message = "Level " + levelAvant + " terminé ! Voici le level " + jeu.getLevelActuel().getNumero();
        } else {
            message = "Clés : " + jeu.getSouris().getCles();
        }

        if (jeu.estGagne()) {
            message = "Bravo, Jerry a gagné !";
        } else if (jeu.estPerdu()) {
            message = "Perdu, Jerry n'a plus de vie...";
        }
        repaint();
    }

    // Dessine le level en cours : une couleur par type de case
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Level level = jeu.getLevelActuel();
        Souris souris = jeu.getSouris();

        for (int y = 0; y < level.getHeight(); y++) {
            for (int x = 0; x < level.getWidth(); x++) {
                Element e = level.getElement(x, y);
                if (e instanceof Mur) g.setColor(new Color(60, 60, 70));
                else if (e instanceof Porte) g.setColor(new Color(150, 90, 40));
                else g.setColor(new Color(235, 230, 215));
                g.fillRect(x * TAILLE, y * TAILLE, TAILLE, TAILLE);
                g.setColor(new Color(200, 195, 180));
                g.drawRect(x * TAILLE, y * TAILLE, TAILLE, TAILLE);

                if (e instanceof Cle) {
                    g.setColor(new Color(230, 180, 20));
                    g.fillOval(x * TAILLE + 15, y * TAILLE + 15, 20, 20);
                }
            }
        }

        g.setColor(new Color(130, 130, 140));
        g.fillOval(souris.getxPosition() * TAILLE + 8, souris.getyPosition() * TAILLE + 8, TAILLE - 16, TAILLE - 16);

        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.BOLD, 16));
        int bas = level.getHeight() * TAILLE;
        g.drawString("Level " + level.getNumero() + "    Points de vie : " + souris.getPointsDeVie(), 10, bas + 25);
        g.drawString(message, 10, bas + 48);
    }

    public static void main(String[] args){
        Labyrinthe jeu = new Labyrinthe(new Random());

        JFrame fenetre = new JFrame("Jerry et le Labyrinthe");
        Main vue = new Main(jeu);
        fenetre.add(vue);
        fenetre.pack();
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        vue.requestFocusInWindow();
    }
}