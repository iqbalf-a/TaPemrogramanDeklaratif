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

public class soal6Controller {
    public String name;
    public int score;
    @FXML
    private Button goSoal7;
    @FXML
    private TextField answ6;

    @FXML
    private void goSoal7Action(ActionEvent event) {
        String jawaban = answ6.getText();
        if (jawaban.isEmpty()) {
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
        } else {
            Boolean z = Boolean.valueOf(jawaban);
            String s1 = "consult('D:/UM/Kuylah/S04/Pemrograman Deklaratif/TA/Tes Logika/src/sample/soal.pl')";
            Query q1 = new Query(s1);
            System.out.println(s1+""+(q1.hasSolution()? "Success" : "Failed"));

            Query q2 = new Query(s1);
            q2.hasSolution();
            q2 = new Query("isTree(t(7, t(6,nil,nil), t(8,nil,nil)))");
            if (q2.hasSolution() == z) {
                score++;
                System.out.println("Benar");
            }
            else System.out.println("Salah");

            Node source = (Node) event.getSource();
            Stage stage = (Stage)  source.getScene().getWindow();
            stage.close();

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("soal7.fxml"));
                Parent root = loader.load();
                soal7Controller soal7Controller = loader.getController();
                soal7Controller.sendData(name, score);
                Stage stage1 = new Stage();
                stage1.setTitle("Tes Logika");
                stage1.setScene(new Scene(root));
                stage1.show();

            } catch (IOException e) {
                System.out.println("error saat change stages");
            }
        }
    }
    public void sendData(String namaFromHome, int hasil) {
        name = namaFromHome;
        score = hasil;
    }
}
