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

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class soal2Controller extends dataController {
    @FXML
    private Button goSoal3;
    @FXML
    private TextField answ2;

    @FXML
    private void goSoal3Action(ActionEvent event) {
        String jawaban = answ2.getText();
        String s1 = "consult('D:/UM/Kuylah/S04/Pemrograman Deklaratif/TA/Tes Logika/src/sample/soal.pl')";
        Query q1 = new Query(s1);
        System.out.println(s1+""+(q1.hasSolution()? "Success" : "Failed"));

        Query q2 = new Query(s1);
        q2.hasSolution();
        q2 = new Query("findLast(" + jawaban + ", [132, 213, 223, 232, 233])");
        if (q2.hasSolution() == true) {
            System.out.println("Benar");
        }
        else System.out.println("Salah");
        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("soal3.fxml"));
            Parent root = loader.load();
            Stage stage1 = new Stage();
            stage1.setTitle("Tes Logika");
            stage1.setScene(new Scene(root));
            stage1.show();
        } catch (IOException e) {
            System.out.println("error saat change stages");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {    }
}
