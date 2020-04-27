package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class hasilController extends dataController implements Initializable {

    public String name;
    public int score;

    @FXML
    private Label yourName;
    @FXML
    private Label yourScore;
    @FXML
    private Button exit;

    @FXML
    private void exitAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ulangAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = loader.load();
            Stage stage1 = new Stage();
            stage1.setTitle("Tes Logika");
            stage1.setScene(new Scene(root));
            stage1.show();
        } catch (IOException e) {
            System.out.println("error saat change stages");
        }
    }

    public void sendData(String namaFromHome, int hasil) {
        name = namaFromHome;
        score = hasil*100;
        yourName.setText(name);
        yourScore.setText(String.valueOf(score));
    }

    public void setLabel() {
        yourName.setText(name);
        yourScore.setText(String.valueOf(score));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLabel();
    }
}
