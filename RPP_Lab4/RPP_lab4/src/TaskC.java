import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Vector;

public class TaskC extends JFrame{
    private JTable table1;
    private JButton CalcButton;
    private JTextArea textArea2;
    private JTable table2;
    private JPanel JPanelTaskC;
    private JButton ClearButton;
    private DefaultTableModel tableModelFirst;
    private DefaultTableModel tableModelSecond;
    private Vector<String> columnsHeader = new Vector<String>();

    public final double[] array_r = {1, 25, 0, -18, 3, 0,5};

    public TaskC(){
        setTitle("Работа с массивом задание C");
        setSize(600, 500);
        add(JPanelTaskC);
        setLocationRelativeTo(null);
        setVisible(true);
        columnsHeader.add("Индексы ячеек");
        columnsHeader.add("0");
        columnsHeader.add("1");
        columnsHeader.add("2");
        columnsHeader.add("3");
        columnsHeader.add("4");
        columnsHeader.add("5");
        InitTable();

        CalcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Vector<Vector> data = tableModelFirst.getDataVector();
                Vector<Vector> dataSecond = new Vector<Vector>();
                Vector<Double> dataDouble = new Vector<Double>();
                double result = 0;
                textArea2.append("Исходный массив:\n");
                for (Vector array : data) {
                    for (int i = 1; i <= 6; i++) {
                        try {
                            Double item = Double.parseDouble(array.get(i).toString());
                            if(item>0) {
                                if(result == 0)
                                    result = item;

                                result *= item;
                            }
                            textArea2.append(item + "   ");
                            dataDouble.add(item);
                        }catch (Exception e){
                            System.out.println(e);
                            JOptionPane.showMessageDialog(null,
                                    "Введенные данные не верны!!!",
                                    "Ошибка введенных данных",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }
                textArea2.append("\n");
                textArea2.append("Произведение положительных элементов: " + result + "\n\n");

                dataDouble.sort(Collections.reverseOrder());
                Vector<Object> row = new Vector<Object>();
                row.add(null);
                for(Double item : dataDouble){
                    row.add(item.toString());
                }
                dataSecond.add(row);
                tableModelSecond.setDataVector(dataSecond,columnsHeader);

            }
        });

        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea2.selectAll();
                textArea2.replaceSelection("");
                InitTable();
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
            }
        });
    }

    private void InitTable(){
        tableModelFirst = new DefaultTableModel(new Vector(), columnsHeader){
            public boolean isCellEditable(int row, int column){
                if(row == 0 && column == 0)
                    return false;
                return true;
            }
        };

        tableModelSecond = new DefaultTableModel(new Vector(), columnsHeader){
            public boolean isCellEditable(int row, int column){
                if(row == 0 && column == 0)
                    return false;
                return true;
            }
        };

        tableModelFirst.addRow(new String[]{" "});
        table1.setModel(tableModelFirst);
        table2.setModel(tableModelSecond);
    }

}
