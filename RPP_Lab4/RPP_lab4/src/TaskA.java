import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class TaskA extends JFrame {
    private JPanel JPanelFrameOne;
    private JButton CalcButton;
    private JTextArea textArea1;
    private JButton ClearButton;

    public final float[] array_r = {1, 25, 0, -18, 3, 0,5};

    public TaskA(){
        setTitle("Работа с массивом");
        add(JPanelFrameOne);
        setVisible(true);
        setSize(600, 400);
        setLocationRelativeTo(null);
        textArea1.setEditable(false);

        CalcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float result = 0;
                textArea1.append("Массив r:\n");
                for (int i=0; i<array_r.length; i++){
                    if(array_r[i]>0) {
                        if(result == 0)
                            result = array_r[i];

                        result *= array_r[i];
                    }
                    textArea1.append(array_r[i] + "   ");
                }
                textArea1.append("\n");
                textArea1.append("Произведение положительных элементов: " + result + "\n\n");
                Arrays.sort(array_r);
                Collections.reverse(Collections.singletonList(array_r));
                textArea1.append("Отсортированный массив:\n");
                for (int i=0; i<array_r.length; i++){
                    textArea1.append(array_r[i] + "   ");
                }

            }
        });
        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.selectAll();
                textArea1.replaceSelection("");
            }
        });

    }

    public int compare(double x, double y){
        if(x < y)
            return 0;
        else
            return 1;
    }
}
