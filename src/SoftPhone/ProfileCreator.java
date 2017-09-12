package SoftPhone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by admin on 08.09.2017.
 */
public class ProfileCreator {
    public ProfileCreator(String login, String password, String server) {
        String filePath = System.getenv("LOCALAPPDATA") + "\\1test\\3CXVoipPhone.ini";

        //TODO file exist??

        //TODO Profile number

        //TODO "Name="+ RUSorUKR +"\r\n"
        String text = "[Profile0]\r\n" +
                "Name="+login+"\r\n" +
                "Enabled=1\r\n" +
                "CallerID="+login+"\r\n" +
                "AuthUser="+login+"\r\n" +
                "AuthID="+login+"\r\n" +
                "AuthPass="+password+"\r\n" +
                "PBXAddr="+server+"\r\n" +
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
}
