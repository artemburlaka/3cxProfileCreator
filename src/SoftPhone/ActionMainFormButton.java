package SoftPhone;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by admin on 11.09.2017.
 */
public class ActionMainFormButton implements ActionListener {
    public void actionPerformed (ActionEvent e) {

        String server = "server";
        File f = new File(System.getenv("LOCALAPPDATA") + "\\1test");
        if (f.exists()) {
            System.out.println("1test is exist");
//                new ProfileCreator(inputEmail.getText(), inputPass.getText(), server);  //add later
//                System.out.println("1test profile was created");
        }
        else {
            new FolderCreator(MainForm.getInputEmail(), server);
            System.out.println("1test folder was created");
            new ProfileCreator(MainForm.getInputEmail(), MainForm.getInputPass(), server);
            System.out.println("1test profile was created");
        }

        String message = "";
        message += "Text is " + MainForm.getInputEmail() + "\n";
//        message += (radio1.isSelected() ? "Radio #1" : "Radio #2") + " is selected!\n";
//        message += "Checkbox is " + ((check.isSelected()) ? "checked" : "unchecked");
        JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);

    }
}
