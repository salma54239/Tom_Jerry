import java.util.ArrayList;
import java.util.Random;

public class Labyrinthe {

    /** Attribut */
    private ArrayList<Level> niveaux = new ArrayList<>();
    private Souris souris;
    private int actuellevel;
    private Random random;

    /** Méthode */

    // Crée la souris une seule fois, puis les levels, et place la souris au départ
    public Labyrinthe(Random random){
        this.random = random;
        this.souris = new Souris("Jerry", 5, 0, 0, 0);
        niveaux.add(Level.creerLevel1(random));
        niveaux.add(Level.creerLevel2(random));
        // niveaux.add(Level.creerLevel3(random));
        this.actuellevel = 0;
        getLevelActuel().ajouterSouris(souris);
    }

    // Renvoie le level en cours
    public Level getLevelActuel(){
        return niveaux.get(actuellevel);
    }

    public Souris getSouris(){
        return souris;
    }
    

    // Un tour de jeu : renvoie "" si la souris a avancé, sinon le message d'erreur
    public String jouerTour(int dx, int dy){
        Level level = getLevelActuel();
        int nx = souris.getxPosition() + dx;
        int ny = souris.getyPosition() + dy;

        if (!level.estDansLaCarte(nx, ny)) {
            return "Impossible : hors de la carte";
        }

        Element e = level.getElement(nx, ny);
        if (e instanceof Mur) {
            return "Impossible : il y a un mur";
        }
        if (e instanceof Porte && !e.estTraversable(souris)) {
            return "La porte est fermée : il faut 3 clés";
        }

        // Chat chat = level.getChat();
        // if (chat != null && chat.estVivant() && chat.getxPosition() == nx && chat.getyPosition() == ny) {
        //     Combat combat = level.lancerCombat(souris);
        //     while (!combat.estTermine()) {
        //         combat.jouerTour();
        //     }
        //     return "Combat contre Tom !";
        // }

        souris.deplacer(dx, dy);
        level.interagirAvec(souris);
        if (level.niveauTermine(souris) && !estGagne()) {
            levelSuivant();
        }
        return "";
    }

    public void levelSuivant(){
        if (actuellevel < niveaux.size() - 1) {
            actuellevel++;
            getLevelActuel().ajouterSouris(souris);
        }
    }

    // Gagné quand le dernier level est terminé
    public boolean estGagne(){
        return actuellevel == niveaux.size() - 1 && getLevelActuel().niveauTermine(souris);
    }

    // Perdu quand la souris n'a plus de points de vie
    public boolean estPerdu(){
        return !souris.estVivant();
    }
}