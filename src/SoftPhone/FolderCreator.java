package SoftPhone;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by admin on 08.09.2017.
 */
public class FolderCreator {
    public FolderCreator(String login, String server) {
        makeFolders();
        makeFiles(login, server);
    }

    private static void makeFolders() {
        File makeMainDir = new File(System.getenv("LOCALAPPDATA") + "\\1test");
        makeMainDir.mkdir();

        ArrayList subDir = new ArrayList();
        subDir.add("Cert");
        subDir.add("History");
        subDir.add("Language");
        subDir.add("Logs");
        subDir.add("Phonebook");
        subDir.add("Provisioned");
        subDir.add("Recordings");
        subDir.add("Reports");
        subDir.add("Snapshots");
        subDir.add("Updater");
        subDir.add("Video");
        for (int i = 0; i < subDir.size(); i++) {
            File makeSubDir = new File(System.getenv("LOCALAPPDATA") + "\\1test\\" + subDir.get(i));
            if (!makeSubDir.exists()) {
                makeSubDir.mkdir();
            }
        }

        ArrayList subSubDir = new ArrayList();
        subSubDir.add("Contacts");
        subSubDir.add("Phones");
        subSubDir.add("Photos");
        for (int i = 0; i < subSubDir.size(); i++) {
            File makeSubDir = new File(System.getenv("LOCALAPPDATA") + "\\1test\\Phonebook\\" + subSubDir.get(i));
            if (!makeSubDir.exists()) {
                makeSubDir.mkdir();
            }
        }
    }

    private static void makeFiles(String login, String server) {
        String loginServer = login + "@" + server;

        ArrayList files = new ArrayList();
        files.add("\\1test\\History\\");
        files.add("callHistory");
        files.add(".txt");
        files.add("\\1test\\Phonebook\\Contacts\\");
        files.add("contacts");
        files.add(".ini");
        files.add("\\1test\\Phonebook\\Phones\\");
        files.add("phones");
        files.add(".ini");

        for (int i = 0; i < files.size(); i++) {
            File file = new File(System.getenv("LOCALAPPDATA") + files.get(i) + files.get(i + 1) + loginServer + files.get(i + 2));
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            i = i + 2;
        }

        File fileConf = new File(System.getenv("LOCALAPPDATA") + "\\1test\\3CXVoipPhone.ini");
        if (!fileConf.exists()) {
            try {
                fileConf.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}