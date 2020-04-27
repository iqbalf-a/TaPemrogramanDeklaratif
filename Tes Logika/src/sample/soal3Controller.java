package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class soal3Controller  {
    public String name;
    public int score;

    @FXML
    private Button goSoal4;
    @FXML
    private TextField answ3;

    @FXML
    private void goSoal4Action(ActionEvent event) {
        String jawaban = answ3.getText();
        String s1 = "consult('D:/UM/Kuylah/S04/Pemrograman Deklaratif/TA/Tes Logika/src/sample/soal.pl')";
        Query q1 = new Query(s1);
        System.out.println(s1+""+(q1.hasSolution()? "Success" : "Failed"));

        Query q2 = new Query(s1);
        q2.hasSolution();
        q2 = new Query("kali(9999, 111," + jawaban + ")");
        if (q2.hasSolution() == true) {
            score++;
            System.out.println("Benar");
        }
        else System.out.println("Salah");
        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("soal4.fxml"));
            Parent root = loader.load();
            soal4Controller soal4Controller = loader.getController();
            soal4Controller.sendData(name, score);
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
