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

public class soal10Controller extends dataController {
    public String name;
    public int score;

    @FXML
    private Button goHasil;
    @FXML
    private TextField answ10;

    @FXML
    private void goHasilAction(ActionEvent event) {
        String jawaban = answ10.getText() + ".0";
        String s1 = "consult('D:/UM/Kuylah/S04/Pemrograman Deklaratif/TA/Tes Logika/src/sample/soal.pl')";
        Query q1 = new Query(s1);
        System.out.println(s1+""+(q1.hasSolution()? "Success" : "Failed"));

        Query q2 = new Query(s1);
        q2.hasSolution();
        q2 = new Query("soal10(99," + jawaban + ")");
        if (q2.hasSolution() == true) {
            score++;
            System.out.println("Benar");
        }
        else System.out.println("Salah");

        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hasil.fxml"));
            Parent root = loader.load();
            hasilController hasilController = loader.getController();
            hasilController.sendData(name, score);
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


