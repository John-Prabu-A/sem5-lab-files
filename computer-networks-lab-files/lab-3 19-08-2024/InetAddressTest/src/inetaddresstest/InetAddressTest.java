/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inetaddresstest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author admin
 */
public class InetAddressTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        address = InetAddress.getByName("www.google.com");
        System.out.println(address);

        InetAddress sw[] = InetAddress.getAllByName("www.nbac.com");
        for(InetAddress add : sw) System.out.println(add); 
    }
    
}
