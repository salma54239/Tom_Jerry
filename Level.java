import java.util.ArrayList;
import java.util.Random;

public class Level {

    /** Attribut */
    private int numero; // numero du level
    private int width;
    private int heigth;
    private int departx;
    private int departy;
    private ArrayList<Element> elements = new ArrayList<>();
    // private Chat chat;

    /** Méthode */
    public Level(int num, int lar, int lon){
        this.numero = num;
        this.width = lar;
        this.heigth = lon;
        // this.chat = null;
    }

    /*
    // Met le chat dans le level (seulement au level 3)
    public void setChat(Chat c){
        this.chat = c;
    }
    */

    public int getNumero(){
        return numero;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return heigth;
    }

    /*
    public Chat getChat(){
        return chat;
    }
    */

    // Fixe la case où la souris commence le level
    public void setDepart(int x, int y){
        this.departx = x;
        this.departy = y;
    }

    // Ajoute un élément sur la carte
    public void ajouterElement(Element e){
        elements.add(e);
    }

    // Retire un élément de la carte
    public void removeElement(Element e){
        elements.remove(e);
    }

    // Check si les coordonnées sont dans la carte
    public boolean estDansLaCarte(int x, int y){
        return (x >= 0 && x < width && y >= 0 && y < heigth);
    }

    // Renvoie l'élément sur la case (x, y), ou null si la case est vide
    public Element getElement(int x, int y){
        for (Element e : elements) {
            if (e.getX() == x && e.getY() == y) {
                return e;
            }
        }
        return null;
    }

    // Place un élément sur une case vide choisie au hasard
    public void placerAuHasard(Element e, Random r){
        int x = r.nextInt(width);
        int y = r.nextInt(heigth);
        while (getElement(x, y) != null || (x == departx && y == departy)) {
            x = r.nextInt(width);
            y = r.nextInt(heigth);
        }
        e.setPosition(x, y);
        ajouterElement(e);
    }

    // Place la souris sur la case de départ du level
    public void ajouterSouris(Souris s){
        s.setPosition(departx, departy);
    }

    // Déclenche l'effet de l'élément sur lequel la souris vient d'arriver
    public void interagirAvec(Souris s){
        Element e = getElement(s.getxPosition(), s.getyPosition());
        if (e != null) {
            e.interagir(s);
            if (e instanceof Cle) {
                removeElement(e);
            }
        }
    }

    // Vrai si la souris est sur une porte ouverte et que le chat (s'il existe) est vaincu
    public boolean niveauTermine(Souris s){
        /*
        if (chat != null && chat.estVivant()) {
            return false;
        }
        */
        Element e = getElement(s.getxPosition(), s.getyPosition());
        if (e instanceof Porte) {
            Porte p = (Porte) e;
            return p.estOuverte();
        }
        return false;
    }

    // Affiche la carte dans la console : S = souris, C = chat, . = case vide
    public void afficher(Souris s){
        for (int y = 0; y < heigth; y++) {
            String ligne = "";
            for (int x = 0; x < width; x++) {
                Element e = getElement(x, y);
                if (s.getxPosition() == x && s.getyPosition() == y) {
                    ligne += "S ";
                // } else if (chat != null && chat.estVivant() && chat.getxPosition() == x && chat.getyPosition() == y) {
                //     ligne += "C ";
                } else if (e != null) {
                    ligne += e.getSymbole() + " ";
                } else {
                    ligne += ". ";
                }
            }
            System.out.println(ligne);
        }
        System.out.println("Points de vie : " + s.getPointsDeVie() + "   Cles : " + s.getCles());
    }

    // Met des murs sur tout le bord de la carte
    private void entourerDeMurs(){
        for (int x = 0; x < width; x++) {
            ajouterElement(new Mur(x, 0));
            ajouterElement(new Mur(x, heigth - 1));
        }
        for (int y = 1; y < heigth - 1; y++) {
            ajouterElement(new Mur(0, y));
            ajouterElement(new Mur(width - 1, y));
        }
    }

    // Remplace le mur à la position de la porte par la porte
    private void placerPorte(Porte p){
        Element mur = getElement(p.getX(), p.getY());
        if (mur != null) {
            removeElement(mur);
        }
        ajouterElement(p);
    }

    // Level 1 : 3 clés au hasard
    public static Level creerLevel1(Random r){
        Level l = new Level(1, 10, 10);
        l.setDepart(1, 1);
        l.entourerDeMurs();
        l.placerPorte(new Porte(9, 8, 3));
        for (int i = 0; i < 3; i++) {
            l.placerAuHasard(new Cle(0, 0), r);
        }
        return l;
    }

    /*
    // Level 2 : 5 pièges et 3 fromages au hasard, la porte est ouverte
    public static Level creerLevel2(Random r){
        Level l = new Level(2, 12, 10);
        l.setDepart(1, 1);
        l.entourerDeMurs();
        l.placerPorte(new Porte(11, 8, 0));
        for (int i = 0; i < 5; i++) {
            l.placerAuHasard(new Piege(0, 0, 1), r);
        }
        for (int i = 0; i < 3; i++) {
            l.placerAuHasard(new Fromage(0, 0, 1), r);
        }
        return l;
    }

    // Crée le combat entre la souris et le chat du level
    public Combat lancerCombat(Souris s){
        return new Combat(s, chat);
    }

    // Level 3 : le chat garde la dernière porte
    public static Level creerLevel3(Random r){
        Level l = new Level(3, 10, 10);
        l.setDepart(1, 1);
        l.entourerDeMurs();
        l.placerPorte(new Porte(9, 8, 0));
        Chat c = new Chat("Tom", 10, 8, 8);
        l.setChat(c);
        return l;
    }
    */
}