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

        File f = new File(System.getenv("LOCALAPPDATA") + "\\1test");
        if (f.exists()) {
            System.out.println("1test is exist");
            new ProfileCreator(MainForm.getProfileType(), MainForm.getInputLogin(), MainForm.getInputPass());
            System.out.println("1test profile was created");
        }
        else {
            new FolderCreator();
            System.out.println("1test folder was created");
            new ProfileCreator(MainForm.getProfileType(), MainForm.getInputLogin(), MainForm.getInputPass());
            System.out.println("1test profile was created");
        }

        String message = "";
        message += "Text is " + MainForm.getInputLogin() + "\n";
        JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);

    }
}
