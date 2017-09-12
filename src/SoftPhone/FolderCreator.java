package SoftPhone;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by admin on 08.09.2017.
 */
public class FolderCreator {
    public FolderCreator() {
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
}