import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.Group;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Main extends Application {

    private static Gestionnaire_partie g;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Negoce");

        try {
            primaryStage.getIcons().add(new Image(new FileInputStream("sprites/icon.png")));
        } catch (FileNotFoundException e) {
            System.out.println("Terrain|" + e);
        }

        GridPane grid = new GridPane();

        List<Case> l = g.getC().getEnsembleCase();

        l.forEach(item -> grid.add(item, item.posX, item.posY));

        root.getChildren().add(grid);
        primaryStage.show();
    }


    public static void main(String[] args) {
        g = new Gestionnaire_partie(50,1,16,12);
        launch(args);
    }
}
