import java.net.InetAddress;
import java.net.UnknownHostException;

class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        address = InetAddress.getByName("www.google.com");
        System.out.println(address);

        InetAddress sw[] = InetAddress.getAllByName("www.nbac.com");
        for(InetAddress add : sw) System.out.println(add); 
        // for(int i = 0; i < sw.length; i++) {
        //     System.out.println(sw[i]);
        // }
        
    }
}