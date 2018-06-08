import java.awt.*;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gestionnaire_partie {
    private int dateActuelle;
    private int dateFin;
    private Negociant[] Joueurs;

    public Gestionnaire_partie(int duree, int nbJoueurs){

    }

    public void Affichage(){

        JFrame fenetre = new JFrame();
        fenetre.setTitle("Negoce");
        fenetre.setVisible(true);
        fenetre.setSize(800,600);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);

        JPanel pan = new JPanel();

        fenetre.setContentPane(pan);
    }
}
