import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CalculatingFunction extends JFrame {
    private JPanel MainJPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton CalcButton;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTable table1;
    private DefaultTableModel tableModel;
    private JButton CalcTableButton;
    private JButton очиститьButton;
    private Vector<String> columnsHeader = new Vector<String>();


    public CalculatingFunction(){
        add(MainJPanel);
        setSize(600, 500);
        setVisible(true);
        setTitle("Вычисление функции");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        columnsHeader.add("a");
        columnsHeader.add("b");
        columnsHeader.add("c");
        columnsHeader.add("x");
        columnsHeader.add("y");
        tableModel = new DefaultTableModel(new Vector(), columnsHeader);
        table1.setModel(tableModel);


        CalcTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(textField1.getText());
                    double b = Double.parseDouble(textField2.getText());
                    double c = Double.parseDouble(textField3.getText());
                    double x = Double.parseDouble(textField4.getText());

                    double start = Double.parseDouble(textField6.getText());
                    double end = Double.parseDouble(textField7.getText());
                    double step = Double.parseDouble(textField8.getText());

                    Vector<Vector<String>> data = new Vector<Vector<String>>();

                    for (double j = start; j < end; j+=step) {
                        Vector<String> row = new Vector<String>();
                        row.add(Double.toString(a));
                        row.add(Double.toString(b));
                        row.add(Double.toString(c));
                        row.add(String.format("%.2f", j));
                        row.add(String.format("%.2f", Function(a,b,c,j)));
                        data.add(row);
                    }
                    tableModel = new DefaultTableModel(data, columnsHeader);
                    table1.setModel(tableModel);
                }catch (Exception ex){
                    table1.setModel(new DefaultTableModel(new Vector(), columnsHeader));
                    JOptionPane.showMessageDialog(null,
                            "Введенные данные не верны!!!",
                            "Ошибка введенных данных",
                            JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        CalcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(textField1.getText());
                    double b = Double.parseDouble(textField2.getText());
                    double c = Double.parseDouble(textField3.getText());
                    double x = Double.parseDouble(textField4.getText());

                    double result = Function(a,b,c,x);
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

        очиститьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(new DefaultTableModel(new Vector(), columnsHeader));
            }
        });
    }

    public double Function(double a, double b, double c, double x){
        return (Math.sqrt(a/(1+(b*Math.pow(x,2)))))+(b*Math.atan(x))+(Math.exp(c*x));
    }

}
