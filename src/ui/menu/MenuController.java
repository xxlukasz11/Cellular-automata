package ui.menu;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    public void showHelp() {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVBox = new VBox(20);
        dialogVBox.getChildren().add(new Text(aboutUs()));
        Scene dialogScene = new Scene(dialogVBox, 400, 100);
        dialog.setResizable(false);
        dialog.setTitle("About");
        dialog.setScene(dialogScene);
        dialog.show();

    }

    private String aboutUs() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tCellular automata simulation program\n");
        sb.append("\tCreated by Łukasz Bożek & Robert Jankowski\n");
        return sb.toString();
    }

}
