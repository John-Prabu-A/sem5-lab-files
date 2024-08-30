import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class WhoIsTest {
    public static void main(String args[]) throws UnknownHostException, IOException {
        int c;
        Socket s = new Socket("whois.internic.net", 43);
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        String str = (args.length == 0 || args[0].isEmpty() ? "google.com" : args[0]) + "\n";
        byte buff[] = str.getBytes("UTF-8");
        out.write(buff);
        while((c = in.read()) != -1) {
            System.out.print((char) c);
        }
        s.close();
    }
}
