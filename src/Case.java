import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Case extends ImageView {
    protected int etatChemin;
    protected int nourriture;
    protected int lCase = 50;
    protected int hCase = 50;

    public int getNourriture() {
        return nourriture;
    }

    public int getlCase() {
        return lCase;
    }

    public int gethCase() {
        return hCase;
    }

    public int getEtatChemin() {
        return etatChemin;
    }

    public void setEtatChemin(int etatChemin) {
        this.etatChemin = etatChemin;
    }

    public abstract String toString();
}
