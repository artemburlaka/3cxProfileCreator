package SoftPhone;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by admin on 08.09.2017.
 */
public class ProfileCreator {
    public ProfileCreator(String profileType, String login, String password) {
        String filePath = System.getenv("LOCALAPPDATA") + "\\1test\\3CXVoipPhone.ini";
        File fileConf = new File(filePath);
        if (!fileConf.exists()) {
            try {
                fileConf.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        String server = "";
        String port = "";

        makeFiles(login, server);

        if (profileType.equals("RUS")) {
            server = FormSettingsParam.getFieldServerMango();
            if (FormSettingsParam.getCheckPortMango()) {
                port = ":60000";
            }
        }
        else {
            server = FormSettingsParam.getFieldServerBinotel();
        }

        //TODO Profile number
        int portNumber = 0;


        String text = getString(profileType, login, password, server, port);

        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
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
    }

    private String getString(String profileType, String login, String password, String server, String port) {
        return "[Profile0]\r\n" +
                    "Name="+profileType+"\r\n" +
                    "Enabled=1\r\n" +
                    "CallerID="+login+"\r\n" +
                    "AuthUser="+login+"\r\n" +
                    "AuthID="+login+"\r\n" +
                    "AuthPass="+password+"\r\n" +
                    "PBXAddr="+server+port+"\r\n" +
                    "PBXRemoteAddr=\r\n" +
                    "PBXVoicemail=\r\n" +
                    "ServerProxy=\r\n" +
                    "DtmfRFC2833=1\r\n" +
                    "DtmfInband=0\r\n" +
                    "DtmfSipinfo=0\r\n" +
                    "DtmfPayload=96\r\n" +
                    "SipTransport=0\r\n" +
                    "RegistrationTime=2\r\n" +
                    "Codecs=PCMA;PCMU;GSM;\r\n" +
                    "VideoCodecs=H.263 (ffdshow)\r\n" +
                    "VideoFormats=QCIF;CIF;SQCIF;CIF4;\r\n" +
                    "LocalPBX=1\r\n" +
                    "RTPTransport=0\r\n" +
                    "ProvisioningURL=http://\r\n" +
                    "UseTunnel=0\r\n" +
                    "UseProxy=0\r\n" +
                    "TunnelPass=abc\r\n" +
                    "TunnelRemAddr="+server+"\r\n" +
                    "TunnelPort=5090\r\n" +
                    "PBXPort=0\r\n" +
                    "STUNServer=stun.3cx.com\r\n" +
                    "AutoProvisioning=0\r\n" +
                    "VoicemailConfirmed=0\r\n";
    }
}
