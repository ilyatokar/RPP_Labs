import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CalculatingFunction extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton CalcButton;
    private JPanel MainJPanel;

    public CalculatingFunction(){
        add(MainJPanel);
        setSize(400, 250);
        setVisible(true);
        setTitle("Вычисление функции");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CalcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(textField1.getText());
                    double b = Double.parseDouble(textField2.getText());
                    double c = Double.parseDouble(textField3.getText());
                    double x = Double.parseDouble(textField4.getText());

                    double result = (Math.sqrt(a/(1+(b*Math.pow(x,2)))))+(b*Math.atan(x))+(Math.exp(c*x));
                    textField5.setText(Double.toString(result));
                }catch (Exception ex){
                    textField5.setText("");
                    JOptionPane.showMessageDialog(null,
                            "Введенные данные не верны!!!",
                            "Ошибка введенных данных",
                            JOptionPane.ERROR_MESSAGE);

                }
            }
        });
    }
}
