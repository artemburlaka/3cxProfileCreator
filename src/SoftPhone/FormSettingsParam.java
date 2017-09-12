package SoftPhone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 12.09.2017.
 */
public class FormSettingsParam implements ActionListener {

    private JLabel labelServerMango = new JLabel("Ардес сервера Манго:");
    private static JTextField fieldServerMango = new JTextField("vpbx400032623.mangosip.ru", 5);
    private JLabel labelPortMango = new JLabel("Альтернативный порт сервера Манго");
    private static JCheckBox checkPortMango = new JCheckBox("", true);
    private JLabel labelServerBinotel = new JLabel("Ардес сервера Бинотел:");
    private static JTextField fieldServerBinotel = new JTextField("sip5.binotel.com", 5);
    private JButton buttonParam = new JButton("Ok");

    public void actionPerformed(ActionEvent e) {
        JFrame formSettingsParam = new JFrame("Настройки");
        formSettingsParam.setSize(550,150);
        formSettingsParam.setLocationRelativeTo(null);
        formSettingsParam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        formSettingsParam.setVisible(true);
        formSettingsParam.setLayout(new GridLayout(4, 2, 2, 2));
        formSettingsParam.add(labelServerMango);
        formSettingsParam.add(fieldServerMango);
        formSettingsParam.add(labelPortMango);
        formSettingsParam.add(checkPortMango);
        formSettingsParam.add(labelServerBinotel);
        formSettingsParam.add(fieldServerBinotel);
        formSettingsParam.add(buttonParam);
        buttonParam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formSettingsParam.dispose();
            }
        });
    }

    public static String getFieldServerMango() {
        return fieldServerMango.getText();
    }

    public static boolean getCheckPortMango() {
        if (checkPortMango.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public static String getFieldServerBinotel() {
        return fieldServerBinotel.getText();
    }
}
