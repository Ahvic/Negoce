import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Mine extends Terrain{
    Ressource minerai;

    public Mine(int posX, int posY, Ressource minerai){
        super(posX,posY,"Mine");

        try {
            super.setImage(new Image(new FileInputStream("sprites/Mine " + minerai.getNom() + ".png"),super.hCase,super.lCase,true,true));
        }catch (FileNotFoundException e){
            System.out.println("Mine|" + e);
        }

        this.minerai = minerai;
        super.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onClick();
            }
        });
    }

    public String toString(){
        return super.toString() + " minerai: " + minerai;
    }

    public void onClick(){
        System.out.println("Je suis une mine de " + minerai +  " et je vais bien");
    }
}
