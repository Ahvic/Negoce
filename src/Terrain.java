import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Terrain extends Case {
    private String type;

    public Terrain(String type){
        this.type = type;

        changementType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        changementType(type);
    }

    public void changementType(String type){
        switch(type){
            case "Plaine" : super.etatChemin = 3;
                break;
            case "Route" : super.etatChemin = 4;
                break;
            case "Montagne" : super.etatChemin = 1;
                break;
            case "Rivière" : super.etatChemin = 0;
                break;
            case "Ocean" : super.etatChemin = 0;
                break;
            case "Pont" : super.etatChemin = 4;
                break;
            default: super.etatChemin = 2;
                break;
        }

        if(!type.contains("Mine")) {
            try {
                super.setImage(new Image(new FileInputStream("sprites/" + type + ".png"), super.hCase, super.lCase, true, true));
            } catch (FileNotFoundException e) {
                System.out.println("Terrain|" + e);
            }
        }
    }

    public String toString(){
        return " type: " + type + " etat chemin: " + super.etatChemin;
    }
}
