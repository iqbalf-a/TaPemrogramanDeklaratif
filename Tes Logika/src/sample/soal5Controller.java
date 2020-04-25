package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class soal5Controller {
    @FXML
    private Button goSoal6;

    @FXML
    private void goSoal6Action(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("soal6.fxml"));
            Parent root = loader.load();
            Stage stage1 = new Stage();
            stage1.setTitle("Tes Logika");
            stage1.setScene(new Scene(root));
            stage1.show();
        } catch (IOException e) {
            System.out.println("error saat change stages");
        }
    }
}
