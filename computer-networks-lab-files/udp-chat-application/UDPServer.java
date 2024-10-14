import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    public static void main(String args[]) throws IOException {
        DatagramSocket server = new DatagramSocket(4160);
        
        byte[] receiveBuf = new byte[1024];
        byte[] sendBuf = new byte[2024];

        DatagramPacket receivePacket = new DatagramPacket(receiveBuf, receiveBuf.length);
        DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length);

        System.out.println("[INFO] : Server Started");
        while(true) {
            server.receive(receivePacket);
            String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
            if(msg.equalsIgnoreCase("terminate")) {
                System.out.println("[INFO] : Client terminated connection");
                break;
            }
            System.out.println("[CLIENT] : " + msg);
            String data;
            
        }
        server.close();
    }
}