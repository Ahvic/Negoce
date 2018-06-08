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

        this.nom = nom;
        this.population = 20;
        this.stabilite = 5;
        this.puissance = 5;

        for(int i = 0; i < joueurs.length; i++)
            confiance.put(joueurs[i],20);
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
}
