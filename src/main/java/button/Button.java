package button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
public class Button extends Application {

    public Button(String play) {
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox message = new VBox();
        // creating new scene:
        Scene scene = new Scene(message,400,4000);
        stage.setScene(scene);
        Button speak = new Button("Play");
    }
}
