import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class TaskB extends JFrame{
    private JTextField textField1;
    private JButton CalcButton;
    private JTextArea textArea3;
    private JPanel JPanelTaskB;
    private JButton ClearButton1;

    public TaskB(){
        setTitle("Работа с массивом задание B");
        setSize(600, 400);
        add(JPanelTaskB);
        setLocationRelativeTo(null);
        setVisible(true);

        CalcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String array_r[] = textField1.getText().split(" ");
                ArrayList<Double> array = new ArrayList<Double>();
                try {
                    for(String item : array_r){
                        array.add(Double.parseDouble(item));
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,
                            "Введенные данные не верны!!!",
                            "Ошибка введенных данных",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double result = 0;
                textArea3.append("Массив:\n");
                for (Double item : array){
                    if(item>0) {
                        if(result == 0)
                            result = item;

                        result *= item;
                    }
                    textArea3.append(item + "   ");
                }
                array.sort(Collections.reverseOrder());
                textArea3.append("\n");
                textArea3.append("Отсортированный массив:\n");
                for (Double item : array){
                    textArea3.append(item + "   ");
                }
                textArea3.append("\n");
                textArea3.append("Произведение положительных элементов: " + result + "\n\n");
            }
        });

        ClearButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea3.selectAll();
                textArea3.replaceSelection("");
            }
        });
        
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if((e.getExtendedKeyCode() >= 0x30 && e.getExtendedKeyCode()<=0x39) ||
                        e.getExtendedKeyCode() == 0x2e ||
                        e.getExtendedKeyCode() == 0x2c ||
                        e.getExtendedKeyCode() == 0x2d ||
                        e.getExtendedKeyCode() == 0x20){
                    super.keyTyped(e);
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Введенные данные не верны!!!",
                            "Ошибка введенных данных",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                return;
            }
        });
    }
}
