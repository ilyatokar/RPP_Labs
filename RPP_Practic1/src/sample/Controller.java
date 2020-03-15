package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {
    @FXML
    private Button VerifyButton;
    @FXML
    private TextField LengthBrick;
    @FXML
    private TextField WidthBrick;
    @FXML
    private TextField HeightBrick;
    @FXML
    private TextField RadiusCircle;

    public void onClickVerifyButton(){
        double radius=0,hbrick=0,wbrick=0;
        try {
            radius = Double.parseDouble(RadiusCircle.getText());
            hbrick = Double.parseDouble(HeightBrick.getText());
            wbrick = Double.parseDouble(WidthBrick.getText());
        }catch (Exception ex){
            AlertErrorInputDateTime();
            return;
        }

        if(radius*2 > Math.sqrt(Math.pow(hbrick, 2)+Math.pow(wbrick, 2))){
            AlertSuccess();
        }else{
            AlertError();
        }
    }

    public void AlertErrorInputDateTime(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка ввода данных");
        alert.setHeaderText(null);
        alert.setContentText("Вы допустили ошибку при вводе");
        alert.showAndWait();
    }
    public void AlertSuccess(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Кирпич пройдет через круговое отверстие");
        alert.setHeaderText(null);
        alert.setContentText("Кирпич пройдет через круговое отверстие");
        alert.showAndWait();
    }

    public void AlertError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Кирпич не пройдет через круговое отверстие");
        alert.setHeaderText(null);
        alert.setContentText("Кирпич не пройдет через круговое отверстие");
        alert.showAndWait();
    }
}
