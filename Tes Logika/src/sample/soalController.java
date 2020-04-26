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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.jpl7.Query;
import sun.misc.JavaAWTAccess;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class soalController extends dataController implements Initializable {


    public int noSoal = 0;
    public int hasil = 0;
    public String nama;
    public String jawaban = "";
//    public ImageView imgSoal;

    @FXML
    private ImageView imgSoal;
    @FXML
    private Label soalKe;
    @FXML
    private Label alertT;
    @FXML
    private Label alertF;
    @FXML
    private TextField answ;
    @FXML
    private Button nextBtn;
    @FXML
    private void nextBtnAction(ActionEvent event){
        noSoal++;
        System.out.println(noSoal);
        jawaban = "";
        switch (noSoal) {
            case 0:
                break;
            case 1:
                System.out.println(noSoal);
                soal1();
                break;
            case 2:
                System.out.println(noSoal);
                soal2();
                break;
            case 3:
                System.out.println(noSoal);
                soal3();
                break;
            case 4:
                System.out.println(noSoal);
                soal4();
                break;
            case 5:
                System.out.println(noSoal);
                soal5();
                break;
            case 6:
                System.out.println(noSoal);
                soal6();
                break;
            case 7:
                System.out.println(noSoal);
                soal7();
                break;
            case 8:
                System.out.println(noSoal);
                soal8();
                break;
            case 9:
                System.out.println(noSoal);
                soal9();
                break;
            case 10:
                System.out.println(noSoal);
                soal10();
                break;
            default:
                Node source = (Node) event.getSource();
                Stage stage = (Stage)  source.getScene().getWindow();
                stage.close();
                hasil();

        }
    }


    public void soal1() {
        soalKe.setText("Soal 1");
        jawaban = answ.getText();
        if (jawaban.isEmpty()) noSoal--;

        String s1 = "consult('D:/UM/Kuylah/S04/Pemrograman Deklaratif/TA/Tes Logika/src/sample/soal.pl')";
        Query q1 = new Query(s1);
        System.out.println(s1+""+(q1.hasSolution()? "Success" : "Failed"));

        Query q2 = new Query(s1);
        q2.hasSolution();
        q2 = new Query("ayah(darsono, " + jawaban + ")");
        if (q2.hasSolution() == true) {
            System.out.println("Benar");
            jawabanBenar();
        }
        else {
            System.out.println("Salah");
            jawabanSalah();
        }
        System.out.println(jawaban);

    }
    private void soal2() {
        imgSoal.setImage(new Image(String.valueOf(this.getClass().getResource("2.jpg"))));
        alertD();
        soalKe.setText("Soal 2");
        jawaban = answ.getText();
        if (jawaban.isEmpty()) noSoal--;

        String s1 = "consult('D:/UM/Kuylah/S04/Pemrograman Deklaratif/TA/Tes Logika/src/sample/soal.pl')";
        Query q2 = new Query(s1);
        System.out.println(s1+""+(q2.hasSolution()? "Success" : "Failed"));

        Query q3 = new Query(s1);
        q3.hasSolution();
        q3 = new Query("findLast(" + jawaban + ", [132, 213, 223, 232, 233])");
        if (q3.hasSolution() == true) {
            System.out.println("Benar");
            jawabanBenar();
        }
        else {
            System.out.println("Salah");
            jawabanSalah();
        }
    }
    private void soal3() {
        alertD();
        soalKe.setText("Soal 3");
        answ.clear();
    }
    private void soal4() {
        soalKe.setText("Soal 4");
        answ.clear();
    }
    private void soal5() {
        soalKe.setText("Soal 5");
        answ.clear();
    }
    private void soal6() {
        soalKe.setText("Soal 6");
        answ.clear();
    }
    private void soal7() {
        soalKe.setText("Soal 7");
        answ.clear();
    }
    private void soal8() {
        soalKe.setText("Soal 8");
        answ.clear();
        noSoal++;
    }
    private void soal9() {
        soalKe.setText("Soal 9");
        answ.clear();
    }
    private void soal10() {
        soalKe.setText("Soal 10");
        answ.clear();
    }

    private void jawabanBenar() {
        alertT.setVisible(true);
        alertF.setVisible(false);
        hasil++;
    }
    private void jawabanSalah() {
        alertF.setVisible(true);
        alertT.setVisible(false);
    }
    private void alertD() {
        alertF.setVisible(false);
        alertT.setVisible(false);
    }

    private void hasil() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hasil.fxml"));
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
    public void initialize(URL location, ResourceBundle resources) {
        imgSoal.setImage(new Image(String.valueOf(this.getClass().getResource("1.jpg"))));
    }
}
