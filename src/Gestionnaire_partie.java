
public class Gestionnaire_partie {

    private int dateActuelle;
    private int dateFin;
    private Negociant[] Joueurs;
    private Carte c;

    public Gestionnaire_partie(int duree, int nbJoueurs, int tailleCarteL, int tailleCarteH){
        c = new Carte();
    }

    public Carte getC() {
        return c;
    }
}
