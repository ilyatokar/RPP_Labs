package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import sample.DataStructure.DigitInput;
import sample.DataStructure.OutDataFor_DoublePrecisionWindow;

import java.math.BigInteger;

public class DoublePrecisionWindow {

    @FXML
    private TableView<DigitInput> InsertTable;

    @FXML
    private TableColumn<DigitInput, String> InsertTableColumn;

    @FXML
    private TableView<OutDataFor_DoublePrecisionWindow> OutTable;

    @FXML
    private TableColumn<OutDataFor_DoublePrecisionWindow, String> outCol_0;

    @FXML
    private TableColumn<OutDataFor_DoublePrecisionWindow, String> outCol_1;

    @FXML
    private TableColumn<OutDataFor_DoublePrecisionWindow, String> outCol_2;

    @FXML
    private TextField OutField;

    @FXML
    void InsertCommit(TableColumn.CellEditEvent<DigitInput, String> event) {
        InputData.get(0).setInputCol(event.getNewValue());
        InsertTable.refresh();

        String bits = Long.toBinaryString(
                Double.doubleToLongBits(
                        Double.parseDouble(
                                event.getNewValue())));
        if(bits.length()<64)
        {
            bits = "0".repeat(64-bits.length()) + bits;
        }
        OutputData.get(0).setCol_0(
                Integer.parseInt(
                        Character.toString(bits.charAt(0))));
        OutputData.get(0).setCol_1(
                Integer.parseInt(
                        bits.substring(1,12),2));
        OutputData.get(0).setCol_2(
                Double.longBitsToDouble(
                        Long.parseLong(
                                bits.substring(13),2)));
        OutTable.refresh();

        OutField.setText(Double.toString(
                Double.longBitsToDouble(
                        new BigInteger(bits,2).longValue()
                )
        ));
    }
    /*Tables Data*/
    private ObservableList<DigitInput> InputData = FXCollections.observableArrayList(
            new DigitInput(0)
    );

    private ObservableList<OutDataFor_DoublePrecisionWindow> OutputData = FXCollections.observableArrayList(
            new OutDataFor_DoublePrecisionWindow(0,0,0)
    );
    /**/

    @FXML
    void initialize() {

        InsertTable.itemsProperty().setValue(InputData); ;
        InsertTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DigitInput, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DigitInput, String> param) {
                return new SimpleStringProperty(param.getValue().getInputColString_Float());
            }
        });
        InsertTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        OutTable.itemsProperty().setValue(OutputData);
        outCol_0.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_DoublePrecisionWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_DoublePrecisionWindow, String> param) {
                return new SimpleStringProperty(Double.toString(param.getValue().getCol_0()));
            }
        });
        outCol_1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_DoublePrecisionWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_DoublePrecisionWindow, String> param) {
                return new SimpleStringProperty(Double.toString(param.getValue().getCol_1()));
            }
        });
        outCol_2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_DoublePrecisionWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_DoublePrecisionWindow, String> param) {
                return new SimpleStringProperty(Double.toString(param.getValue().getCol_2()));
            }
        });
    }
}
