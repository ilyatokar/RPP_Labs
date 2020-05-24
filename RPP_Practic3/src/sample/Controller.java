package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    Parent ByteWindow;
    Parent SinglePrecisionWindow;
    Parent DoublePrecisionWindow;
    Parent CharWindow;
    Stage ByteWindowStage = new Stage();
    Stage SinglePrecisionWindowStage = new Stage();
    Stage DoublePrecisionWindowStage = new Stage();
    Stage CharWindowStage = new Stage();

    @FXML
    void ByteButton_Click(ActionEvent event) {
        try{
            ByteWindowStage.setScene(new Scene(ByteWindow, 463, 331));
        }catch (Exception e)
        {
            ByteWindowStage.show();
        }
        finally {
            ByteWindowStage.setTitle("Byte");
            ByteWindowStage.setResizable(false);
            ByteWindowStage.show();
        }
    }



    @FXML
    void SinglePrecision_Click(ActionEvent event) {
        try{
            SinglePrecisionWindowStage.setScene(new Scene(SinglePrecisionWindow, 1331, 331));
        }catch (Exception e)
        {
            SinglePrecisionWindowStage.show();
        }
        finally {
            SinglePrecisionWindowStage.setTitle("Float");
            SinglePrecisionWindowStage.setResizable(false);
            SinglePrecisionWindowStage.show();
        }
    }

    @FXML
    void DoublePrecision_Click(ActionEvent event) {
        try{
            DoublePrecisionWindowStage.setScene(new Scene(DoublePrecisionWindow, 463, 331));
        }catch (Exception e)
        {
            DoublePrecisionWindowStage.show();
        }
        finally {
            DoublePrecisionWindowStage.setTitle("Double");
            DoublePrecisionWindowStage.setResizable(false);
            DoublePrecisionWindowStage.show();
        }
    }

    @FXML
    void Char_Click(ActionEvent event) {
        try{
            CharWindowStage.setScene(new Scene(CharWindow, 703, 228));
        }catch (Exception e)
        {
            CharWindowStage.show();
        }
        finally {
            CharWindowStage.setTitle("Char");
            CharWindowStage.setResizable(false);
            CharWindowStage.show();
        }
    }


    @FXML
    void initialize() throws IOException {
        ByteWindow = FXMLLoader.load(getClass().getResource("ByteWindow.fxml"));
        SinglePrecisionWindow = FXMLLoader.load(getClass().getResource("SinglePrecisionWindow.fxml"));
        DoublePrecisionWindow = FXMLLoader.load(getClass().getResource("DoublePrecisionWindow.fxml"));
        CharWindow = FXMLLoader.load(getClass().getResource("CharWindow.fxml"));
    }
}
