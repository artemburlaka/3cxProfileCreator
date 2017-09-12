package SoftPhone;

/**
 * Created by Artem Burlaka on 06.09.2017.
 */

import java.awt.*;
import javax.swing.*;

public class MainForm extends JFrame {

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuSettings = new JMenu("Настройки");
    private JMenuItem settingsParam = new JMenuItem("Параметры");
    private JMenuItem settingsRestore = new JMenuItem("Сброс");
    private JMenu menuInfo = new JMenu("Справка");
    private JMenuItem infoAbout = new JMenuItem("О программе");

    private JLabel labelEmail = new JLabel("  Введите email:");
    private static JTextField inputEmail = new JTextField("example@koderline.com", 5);
    private JLabel labelPass = new JLabel("  Введите пароль:");
    private static JTextField inputPass = new JTextField("", 5);
    private JRadioButton radio1 = new JRadioButton("Рос телефония");
    private JRadioButton radio2 = new JRadioButton("Укр телефония");
    private JCheckBox check = new JCheckBox("Check", false);
    private JButton button = new JButton("Ok");

    public MainForm() {
        super("3cxProfileCreator");
        this.setSize(350, 180);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar.add(menuSettings);
        menuSettings.add(settingsParam);
        menuSettings.add(settingsRestore);
        menuBar.add(menuInfo);
        menuInfo.add(infoAbout);
        this.setJMenuBar(menuBar);

        infoAbout.addActionListener(new ActionFormAbout());

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 2, 2, 2));
        container.add(labelEmail);
        container.add(inputEmail);
        container.add(labelPass);
        container.add(inputPass);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        container.add(check);
        button.addActionListener(new ActionMainFormButton());
        container.add(button);

    }

    public static String getInputEmail() {
        return inputEmail.getText();
    }

    public static String getInputPass() {
        return inputPass.getText();
    }
}
