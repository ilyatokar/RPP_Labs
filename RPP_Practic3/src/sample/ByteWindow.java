package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import sample.DataStructure.DigitInput;
import sample.DataStructure.OutDataFor_ByteWindow;

public class ByteWindow {

    @FXML
    private TableView<DigitInput> InsertTable;

    @FXML
    private TableColumn<DigitInput, String> InsertTableColumn;

    @FXML
    private TextField SignField;

    @FXML
    private TextField BitsField;

    @FXML
    private TableView<OutDataFor_ByteWindow> DemoTable;

    @FXML
    private TableColumn<OutDataFor_ByteWindow, String> outCol_0;

    @FXML
    private TableColumn<OutDataFor_ByteWindow, String> outCol_1;

    @FXML
    private TableColumn<OutDataFor_ByteWindow, String> outCol_2;

    @FXML
    private TableColumn<OutDataFor_ByteWindow, String> outCol_3;

    @FXML
    private TableColumn<OutDataFor_ByteWindow, String> outCol_4;

    @FXML
    private TableColumn<OutDataFor_ByteWindow, String> outCol_5;

    @FXML
    private TableColumn<OutDataFor_ByteWindow, String> outCol_6;

    @FXML
    private TableColumn<OutDataFor_ByteWindow, String> outCol_7;

    @FXML
    private TableColumn<OutDataFor_ByteWindow, String> outCol_8;

    @FXML
    private TextField BackField;

    @FXML
    void BackButton_Click(ActionEvent event) {
        byte value = (byte) ((byte)InputData.get(0).getInputCol_Int() << 1);
        InsertTable.getItems().get(0).setInputCol(value);
        InsertTable.refresh();
        ShowDigit(value);
    }

    @FXML
    void ForwardButton_Click(ActionEvent event) {
        byte value = (byte) ((byte)InputData.get(0).getInputCol_Int() >> 1);

        if (value<0)
        {
            String str = Integer.toBinaryString(value);
            str = "0" + str.substring(str.length()-7);
            value = (byte) Integer.parseInt(str,2);
        }

        InsertTable.getItems().get(0).setInputCol(value);
        InsertTable.refresh();
        ShowDigit(value);
    }

    @FXML
    void InsertCommit(TableColumn.CellEditEvent<DigitInput, String> event) {
        InsertTable.getItems().get(0).setInputCol((byte)Integer.parseInt(event.getNewValue()));
        InsertTable.refresh();
        ShowDigit(Integer.parseInt(event.getNewValue()));
    }

    @FXML
    void ReverseTranslationButton_Click(ActionEvent event) {
        String input = BackField.getText();
        int value=0;
        if(!input.matches("[01]{1,8}")) /*Only '1' & '0' 0<length<=8*/
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Только двоичная запись!\nНе более 8 бит!");
            alert.showAndWait();
            return;
        }
        if(input.length()<8)
            input = "0".repeat(7-input.length()) + input;
        if (input.charAt(0)=='1'){
            input = input.replace('0', '?');
            input = input.replace('1','0');
            input = input.replace('?','1');
            value = ~Integer.parseInt(input,2);
        }else
        value = Integer.parseInt(input,2);
        InputData.get(0).setInputCol(value);
        ShowDigit(value);
        InsertTable.refresh();
    }

    private ObservableList<DigitInput> InputData = FXCollections.observableArrayList(
            new DigitInput((float) 0)
    );

    private ObservableList<OutDataFor_ByteWindow> OutputData = FXCollections.observableArrayList(
            new OutDataFor_ByteWindow("Значение","0","0","0","0","0","0","0","0")
    );

    void ShowDigit(int value){

        value = (byte) value;
        String bits = Integer.toBinaryString(value);
        if (value<0) {
            OutputData.get(0).setCol_1("1");
            bits = bits.substring(bits.length()-8);
        }else
        {
            OutputData.get(0).setCol_1("0");
            bits = "0".repeat(8-bits.length())+bits;
        }

        OutputData.get(0).setCol_2(Character.toString(bits.charAt(1)));
        OutputData.get(0).setCol_3(Character.toString(bits.charAt(2)));
        OutputData.get(0).setCol_4(Character.toString(bits.charAt(3)));
        OutputData.get(0).setCol_5(Character.toString(bits.charAt(4)));
        OutputData.get(0).setCol_6(Character.toString(bits.charAt(5)));
        OutputData.get(0).setCol_7(Character.toString(bits.charAt(6)));
        OutputData.get(0).setCol_8(Character.toString(bits.charAt(7)));
        DemoTable.refresh();
        SignField.setText(Character.toString(bits.charAt(0)));
        BitsField.setText(bits.substring(1));
    }

    @FXML
    void initialize() {
        InsertTable.itemsProperty().setValue(InputData);
        InsertTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DigitInput, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DigitInput, String> param) {
                return new SimpleStringProperty(param.getValue().getInputColString_Int());
            }
        });
        InsertTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        DemoTable.itemsProperty().setValue(OutputData);
        /*Инициализация полей таблицы вывода*/{
        outCol_0.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_0());
            }
        });
        outCol_1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_1());
            }
        });
        outCol_2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_2());
            }
        });
        outCol_3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_3());
            }
        });
        outCol_4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_4());
            }
        });
        outCol_5.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_5());
            }
        });
        outCol_6.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_6());
            }
        });
        outCol_7.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_7());
            }
        });
        outCol_8.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_ByteWindow, String> param) {
                return new SimpleStringProperty(param.getValue().getCol_8());
            }
        });
    }
    }
}