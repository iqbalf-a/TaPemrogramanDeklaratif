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

public class soal9Controller extends dataController {
    public String name;
    public int score;

    @FXML
    private Button goSoal10;
    @FXML
    private TextField answ9;

    @FXML
    private void goSoal10Action(ActionEvent event) {
        String jawaban = answ9.getText();
        String s1 = "consult('D:/UM/Kuylah/S04/Pemrograman Deklaratif/TA/Tes Logika/src/sample/soal.pl')";
        Query q1 = new Query(s1);
        System.out.println(s1+""+(q1.hasSolution()? "Success" : "Failed"));

        Query q2 = new Query(s1);
        q2.hasSolution();
        q2 = new Query("equal(1," + jawaban + ")");
        if (q2.hasSolution() == true) {
            score++;
            System.out.println("Benar");
        }
        else System.out.println("Salah");

        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("soal10.fxml"));
            Parent root = loader.load();
            soal10Controller soal10Controller = loader.getController();
            soal10Controller.sendData(name, score);
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
        score = hasil;
    }
}


