import java.util.*;

public class Carte {
    private int largeur;
    private int hauteur;

    List<Case> ensembleCase = new ArrayList<>();

    public Carte(int tailleL, int tailleH){
        largeur = tailleL;
        hauteur = tailleH;
        Generation();
    }

    public void Generation(){
        for(int x = 0; x < largeur; x++){
            for(int y = 0; y < hauteur; y++){
                ensembleCase.add(new Terrain(x,y,"Plaine"));
            }
        }
    }

    public List<Case> getEnsembleCase() {
        return ensembleCase;
    }

    public String toString(){
        return ensembleCase.toString();
    }
}
