package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jpl7.Query;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class soal1Controller extends dataController {

    public String name;
    public int score = 0;

    @FXML
    private Button goSoal2;
    @FXML
    private TextField answ1;

    @FXML
    private void goSoal2Action(ActionEvent event) {
        String jawaban = answ1.getText();
        String s1 = "consult('D:/UM/Kuylah/S04/Pemrograman Deklaratif/TA/Tes Logika/src/sample/soal.pl')";
        Query q1 = new Query(s1);
        System.out.println(s1+""+(q1.hasSolution()? "Success" : "Failed"));
        System.out.println(name);

        Query q2 = new Query(s1);
        q2.hasSolution();
        q2 = new Query("ayah(darsono, " + jawaban + ")");
        if (q2.hasSolution() == true) {
            System.out.println("Benar");
            score++;
        }
        else System.out.println("Salah");

        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("soal2.fxml"));
            Parent root = loader.load();
            soal2Controller soal2Controller = loader.getController();
            soal2Controller.sendData(name, score);
            Stage stage1 = new Stage();
            stage1.setTitle("Tes Logika");
            stage1.setScene(new Scene(root));
            stage1.show();

        } catch (IOException e) {
            System.out.println("error saat change stages");
        }
    }

    public void sendData(String nameFromHome) {
        name = nameFromHome;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
