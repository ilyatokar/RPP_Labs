import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainForm extends JFrame{

    public MainForm()
    {
        setTitle("Системное меню");
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        // Создание строки главного меню
        JMenuBar menuBar = new JMenuBar();
        // Добавление в главное меню выпадающих пунктов меню
        menuBar.add(createFileMenu());
        // Подключаем меню к интерфейсу приложения
        setJMenuBar(menuBar);
        // Открытие окна
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    //--------------------------------------------------------
    /**
     * Функция создания меню "Файл"
     * @return
     */
    private JMenu createFileMenu()
    {
        // Создание выпадающего меню
        JMenu menu = new JMenu("Файл");
        // Пункт меню "Открыть" с изображением
        JMenuItem taskA = new JMenuItem("Задание А");
        JMenuItem taskB = new JMenuItem("Задание B");
        JMenuItem taskC = new JMenuItem("Задание C");
        // Добавим в меню пункта open
        menu.add(taskA);
        menu.addSeparator();
        menu.add(taskB);
        menu.addSeparator();
        menu.add(taskC);

        taskA.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new TaskA();
            }
        });

        taskB.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new TaskB();
            }
        });

        taskC.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new TaskC();
            }
        });
        return menu;
    }

}
