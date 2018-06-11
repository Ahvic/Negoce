import javafx.event.EventHandler;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.*;

public class Ville extends Case {

    private String nom;
    private int population;
    private int stabilite;
    private int puissance;
    private Map<Negociant,Integer> confiance = new HashMap<>();

    public Ville(int posX, int posY, String nom, Negociant[] joueurs){
        super.posX = posX;
        super.posY = posY;
        super.etatChemin = 4;

        try {
            super.setImage(new Image(new FileInputStream("sprites/Ville.png"),super.hCase,super.lCase,true,true));
        }catch (FileNotFoundException e){
            System.out.println("Ville|" + e);
        }

        this.nom = nom;
        this.population = 20;
        this.stabilite = 5;
        this.puissance = 5;

        if(joueurs != null) {
            for (int i = 0; i < joueurs.length; i++)
                confiance.put(joueurs[i], 20);
        }

        super.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onClick();
            }
        });
    }

    public String toString(){
        String res = "";

        res += "X: " + super.posX + " Y: " + super.posY + " etat chemin: " + super.etatChemin + "\n";
        res += "Ville: " + nom + " pop: " + population + " stabilite: " + stabilite + " puissance: " + puissance + "\n";
        res += "Confiance :" + "\n";

        Set<Entry<Negociant, Integer>> setHm = confiance.entrySet();
        Iterator<Entry<Negociant, Integer>> it = setHm.iterator();

        while(it.hasNext()){
            Entry<Negociant, Integer> e = it.next();
            res += "   " + e.getKey().toString() + " : " + e.getValue() + "\n";
        }

        return res;
    }

    public void onClick(){
        System.out.println("Je suis la ville " + nom + " et je vais bien");
    }
}
