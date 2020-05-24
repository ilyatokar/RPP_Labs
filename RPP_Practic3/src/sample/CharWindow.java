package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import sample.DataStructure.CharInput;
import sample.DataStructure.DigitInput;
import sample.DataStructure.OutDataFor_CharWindow;

public class CharWindow {

    @FXML
    private TableView<CharInput> InTable;

    @FXML
    private TableColumn<CharInput, String> inCol_0;

    @FXML
    private TableColumn<CharInput, String> inCol_1;

    @FXML
    private TableView<OutDataFor_CharWindow> OutTable;

    @FXML
    private TableColumn<OutDataFor_CharWindow, String> outCol_0;

    @FXML
    private TableColumn<OutDataFor_CharWindow, String> outCol_1;

    @FXML
    private TableColumn<OutDataFor_CharWindow, String> outCol_2;

    @FXML
    private TableColumn<OutDataFor_CharWindow, String> outCol_3;

    @FXML
    private TableColumn<OutDataFor_CharWindow, String> outCol_4;

    @FXML
    void inCol_Commit(TableColumn.CellEditEvent<DigitInput, String> event) {
        switch (event.getTableColumn().getId())
        {
            case "inCol_0":
                if(event.getNewValue().length()!=1){return;}
                InputData.get(0).setCol_0(event.getNewValue().charAt(0));
                InputData.get(0).setCol_1(event.getNewValue().charAt(0));
                break;
            case "inCol_1":
                if(!event.getNewValue().matches("\\d*")){return;}
                InputData.get(0).setCol_0(Character.toChars(Integer.parseInt(event.getNewValue()))[0]);
                InputData.get(0).setCol_1(Integer.parseInt(event.getNewValue()));
                break;
        }
        InTable.refresh();

        String bits = Integer.toBinaryString(InputData.get(0).getCol_0());
        bits = "0".repeat(16-bits.length()) + bits;

        OutputData.get(0).setCol_1(bits.substring(0,4));
        OutputData.get(0).setCol_2(bits.substring(4,8));
        OutputData.get(0).setCol_3(bits.substring(8,12));
        OutputData.get(0).setCol_4(bits.substring(12));

        OutputData.get(1).setCol_1(Integer.toHexString(
                Integer.parseInt(bits.substring(0,4),2)));
        OutputData.get(1).setCol_2(Integer.toHexString(
                Integer.parseInt(bits.substring(4,8),2)));
        OutputData.get(1).setCol_3(Integer.toHexString(
                Integer.parseInt(bits.substring(8,12),2)));
        OutputData.get(1).setCol_4(Integer.toHexString
                (Integer.parseInt(bits.substring(12),2)));
        OutTable.refresh();

    }

    /*Tables Data*/
    private ObservableList<CharInput> InputData = FXCollections.observableArrayList(
            new CharInput('a', ('a'))
    );

    private ObservableList<OutDataFor_CharWindow> OutputData = FXCollections.observableArrayList(
            new OutDataFor_CharWindow("Биты в тетраде","0","0","0","0"),
            new OutDataFor_CharWindow("16-чная цифра","0","0","0","0")
    );

    @FXML
    void initialize() {

        InTable.itemsProperty().setValue(InputData);
        inCol_0.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CharInput, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CharInput, String> param) {
                return new SimpleStringProperty(Character.toString(param.getValue().getCol_0()));
            }
        }); ;
        inCol_1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CharInput, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CharInput, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getCol_1()));
            }
        });  ;
        inCol_0.setCellFactory(TextFieldTableCell.forTableColumn());
        inCol_1.setCellFactory(TextFieldTableCell.forTableColumn());

        OutTable.itemsProperty().setValue(OutputData);
        outCol_0.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_CharWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_CharWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_0());
            }
        });
        outCol_1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_CharWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_CharWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_1());
            }
        });
        outCol_2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_CharWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_CharWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_2());
            }
        });
        outCol_3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_CharWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_CharWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_3());
            }
        });
        outCol_4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_CharWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_CharWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_4());
            }
        });

    }
}
