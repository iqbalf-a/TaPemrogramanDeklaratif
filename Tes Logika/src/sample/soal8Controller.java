package sample;

import com.sun.org.apache.xpath.internal.operations.Bool;
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

public class soal8Controller extends dataController {
    public String name;
    public int score;

    @FXML
    private Button goSoal9;
    @FXML
    private TextField answ8;

    @FXML
    private void goSoal9Action(ActionEvent event) {
        String jawaban = answ8.getText();
        Boolean z = Boolean.valueOf(jawaban);
        String s1 = "consult('D:/UM/Kuylah/S04/Pemrograman Deklaratif/TA/Tes Logika/src/sample/soal.pl')";
        Query q1 = new Query(s1);
        System.out.println(s1+""+(q1.hasSolution()? "Success" : "Failed"));

        Query q2 = new Query(s1);
        q2.hasSolution();
        q2 = new Query("soal8(230, 220, 1, 120)");
        if (q2.hasSolution() == z) {
            score++;
            System.out.println("Benar");
        }
        else System.out.println("Salah");

        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("soal9.fxml"));
            Parent root = loader.load();
            soal9Controller soal9Controller = loader.getController();
            soal9Controller.sendData(name, score);
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


