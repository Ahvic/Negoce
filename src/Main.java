import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.Group;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    private static Gestionnaire_partie g;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();

        //Propriété de la fenêtre
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Negoce");
        primaryStage.setResizable(false);

        //L'icone de la fenêtre
        try {
            primaryStage.getIcons().add(new Image(new FileInputStream("sprites/icon.png")));
        } catch (FileNotFoundException e) {
            System.out.println("Terrain|" + e);
        }

        //La grille
        GridPane grid = new GridPane();

        Case[][] l = g.getC().getEnsembleCase();

        for(int i = 0; i < l.length; i++){
            for(int j = 0; j < l[0].length; j++){
                grid.add(l[i][j],i,j);
            }
        }

        root.getChildren().add(grid);
        primaryStage.show();
    }


    public static void main(String[] args) {
        g = new Gestionnaire_partie(50,1,16,12);
        launch(args);
    }
}
