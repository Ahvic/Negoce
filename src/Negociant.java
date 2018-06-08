import java.util.Dictionary;

public class Negociant {
    private String nom;
    private int or;
    private Dictionary<Ville,Integer> garnisons;
    private int nbConvois;

    public Negociant(String nom){
        this.nom = nom;
        or = 0;
        garnisons = null;
        nbConvois = 0;
    }

    public String toString(){
        return nom;
    }
}
