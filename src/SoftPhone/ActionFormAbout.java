package SoftPhone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 11.09.2017.
 */
public class ActionFormAbout implements ActionListener {

    private JLabel labelAbout = new JLabel("Создание профилей в 3CXPhone");

        public void actionPerformed(ActionEvent e) {
        JFrame formAbout = new JFrame("О программе");
        formAbout.setSize(350,150);
        formAbout.setLocationRelativeTo(null);
        formAbout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        formAbout.setVisible(true);
        formAbout.setLayout(new GridLayout(4, 2, 2, 2));
        formAbout.add(labelAbout);
    }
}
