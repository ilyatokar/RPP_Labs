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
import sample.DataStructure.OutDataFor_SinglePrecisionWindow;

import java.text.DecimalFormat;

public class SinglePrecisionWindow {

    @FXML
    private TableView<DigitInput> InsertTable;

    @FXML
    private TableColumn<DigitInput, String> InsertTableColumn;

    @FXML
    private TableView<OutDataFor_SinglePrecisionWindow> OutputTable;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_0;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_1;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_2;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_3;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_4;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_5;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_6;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_7;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_8;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_9;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_10;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_11;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_12;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_13;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_14;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_15;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_16;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_17;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_18;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_19;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_20;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_21;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_22;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_23;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_24;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_25;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_26;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_27;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_28;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_29;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_30;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_31;

    @FXML
    private TableColumn<OutDataFor_SinglePrecisionWindow, String> outCol_32;

    @FXML
    private TextField BackField;

    @FXML
    void InsertCommit(TableColumn.CellEditEvent<DigitInput, String> event) {
        InputData.get(0).setInputCol(event.getNewValue());


        String bits = Integer.toBinaryString(Float.floatToIntBits((Float.parseFloat(event.getNewValue()))));
        if (bits.length()<32){
            bits = "0".repeat(32-bits.length()) + bits;
        }
        OutputData.get(3).FromString(bits);


        BackField.setText(new DecimalFormat("#."+"#".repeat(23)).format(
                Float.intBitsToFloat(
                        (int)Long.parseLong(
                                OutputData.get(3).toString(),2
                        )
                )
        ));
        InsertTable.refresh();
        OutputTable.refresh();
    }

    /*Tables Data*/
    private ObservableList<DigitInput> InputData = FXCollections.observableArrayList(
            new DigitInput(0)
    );

    private ObservableList<OutDataFor_SinglePrecisionWindow> OutputData = FXCollections.observableArrayList(
            new OutDataFor_SinglePrecisionWindow("Байт","Б","А","Й","Т","№","3","","","Б","А","Й","Т","№","2","","","Б","А","Й","Т","№","1","","","Б","А","Й","Т","№","0","",""),
            new OutDataFor_SinglePrecisionWindow("№ бита","31","30","29","28","27","26","25","24","23","22","21","20","19","18","17","16","15","14","13","12","11","10","9","8","7","6","5","4","3","2","1","0"),
            new OutDataFor_SinglePrecisionWindow("Вес бита",
                    "256",
                    Double.toString((256/Math.pow(2,1))),
                    Double.toString((256/Math.pow(2,2))),
                    Double.toString((256/Math.pow(2,3))),
                    Double.toString((256/Math.pow(2,4))),
                    Double.toString(256/Math.pow(2,5)),
                    Double.toString(256/Math.pow(2,6)),
                    Double.toString(256/Math.pow(2,7)),
                    Double.toString(256/Math.pow(2,8)),
                    Double.toString(256/Math.pow(2,9)),
                    Double.toString(256/Math.pow(2,10)),
                    Double.toString(256/Math.pow(2,11)),
                    Double.toString(256/Math.pow(2,12)),
                    Double.toString(256/Math.pow(2,13)),
                    Double.toString(256/Math.pow(2,14)),
                    Double.toString(256/Math.pow(2,15)),
                    Double.toString(256/Math.pow(2,16)),
                    Double.toString(256/Math.pow(2,17)),
                    Double.toString(256/Math.pow(2,18)),
                    Double.toString(256/Math.pow(2,19)),
                    Double.toString(256/Math.pow(2,20)),
                    Double.toString(256/Math.pow(2,21)),
                    Double.toString(256/Math.pow(2,22)),
                    Double.toString(256/Math.pow(2,23)),
                    Double.toString(256/Math.pow(2,24)),
                    Double.toString(256/Math.pow(2,25)),
                    Double.toString(256/Math.pow(2,26)),
                    Double.toString(256/Math.pow(2,27)),
                    Double.toString(256/Math.pow(2,28)),
                    Double.toString(256/Math.pow(2,29)),
                    Double.toString(256/Math.pow(2,30)),
                    Double.toString(256/Math.pow(2,31))),
            new OutDataFor_SinglePrecisionWindow("бит","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0")
    );

    @FXML
    void initialize() {

        InsertTable.itemsProperty().setValue(InputData);
        InsertTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DigitInput, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DigitInput, String> param) {
                return new SimpleStringProperty(param.getValue().getInputColString_Float());
            }
        });
        InsertTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        OutputTable.itemsProperty().setValue(OutputData);
        /*Инициализация столбцов таблицы вывода*/{
            outCol_0.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_0());
                }
            });
            outCol_1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_1());
                }
            });
            outCol_2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_2());
                }
            });
            outCol_3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_3());
                }
            });
            outCol_4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_4());
                }
            });
            outCol_5.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_5());
                }
            });
            outCol_6.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_6());
                }
            });
            outCol_7.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_7());
                }
            });
            outCol_8.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_8());
                }
            });
            outCol_9.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_9());
                }
            });
            outCol_10.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_10());
                }
            });
            outCol_11.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_11());
                }
            });
            outCol_12.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_12());
                }
            });
            outCol_13.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_13());
                }
            });
            outCol_14.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_14());
                }
            });
            outCol_15.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_15());
                }
            });
            outCol_16.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_16());
                }
            });
            outCol_17.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_17());
                }
            });
            outCol_18.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_18());
                }
            });
            outCol_19.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_19());
                }
            });
            outCol_20.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_20());
                }
            });
            outCol_21.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_21());
                }
            });
            outCol_22.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_22());
                }
            });
            outCol_23.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_23());
                }
            });
            outCol_24.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_24());
                }
            });
            outCol_25.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_25());
                }
            });
            outCol_26.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_26());
                }
            });
            outCol_27.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_27());
                }
            });
            outCol_28.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_28());
                }
            });
            outCol_29.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_29());
                }
            });
            outCol_30.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_30());
                }
            });
            outCol_31.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_31());
                }
            });
            outCol_32.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<OutDataFor_SinglePrecisionWindow, String> param) {
                    return new SimpleStringProperty(param.getValue().getCol_32());
                }
            });
        }
    }
}
