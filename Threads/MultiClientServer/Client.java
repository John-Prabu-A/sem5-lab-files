package Threads.MultiClientServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Interface for message communication
interface MessageHandler {
    void sendMessage(String message);
    String receiveMessage();
}

// Class to handle client operations
class ClientHandler implements MessageHandler {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(String host, int port) throws Exception {
        socket = new Socket(host, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void sendMessage(String message) {
        out.println(message);
        out.flush();
    }

    @Override
    public String receiveMessage() {
        try {
            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Main class for client execution
public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 5555;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientHandler clientHandler = null;

        try {
            clientHandler = new ClientHandler(HOST, PORT);
            String sendMessage;

            while (true) {
                System.out.print("Enter your Message: ");
                sendMessage = scanner.nextLine();
                clientHandler.sendMessage(sendMessage);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (clientHandler != null) {
                clientHandler.close();
            }
            scanner.close();
        }
    }
}

