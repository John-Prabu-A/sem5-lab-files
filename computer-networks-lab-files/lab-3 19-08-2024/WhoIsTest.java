import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class WhoIsTest {
    public static void main(String args[]) throws UnknownHostException {
        int c;
        Socket s = new Socket("whois.internic.net", 43);
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        String str = 

    }
}
