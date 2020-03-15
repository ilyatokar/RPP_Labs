package sample;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    @FXML
    private TextArea TextAreaNumber;
    @FXML
    private Text TextSearch;

    public void onClickCalc(){
        String findSearch = "Найденно чисел в строке: ";
        String search = TextAreaNumber.getText();
        final String regex = "(\\d+)";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(search);
        int size = 0;
        while (matcher.find()) {
            size++;
        }
        System.out.println(size);
        TextSearch.setText(findSearch + size);
        return;

    }
}
