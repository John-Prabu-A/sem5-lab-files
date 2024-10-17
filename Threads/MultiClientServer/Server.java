package Threads.MultiClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Interface for client communication
interface ClientMessageHandler {
    void handleClient(Socket client, int clientId);
}

// Class to handle individual client connections
class ClientHandler extends Thread implements ClientMessageHandler {
    private int clientId;
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket client, int clientId) {
        this.client = client;
        this.clientId = clientId;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error initializing streams: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        handleClient(client, clientId);
    }

    @Override
    public void handleClient(Socket client, int clientId) {
        try {
            System.out.println("Client Thread started for Client ID: " + clientId);
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("[CLIENT " + clientId + "] : " + message);
                out.println("Your Message: " + message + " has been received.");
            }
        } catch (IOException e) {
            System.out.println("Error with client " + clientId + ": " + e.getMessage());
        } finally {
            cleanup();
        }
    }

    private void cleanup() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (client != null) client.close();
            System.out.println("Cleaned up resources for client " + clientId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Main class to handle the server operations
public class Server {
    private static final int PORT = 5555;
    private ServerSocket server;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server Started.");
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }

    public void start() {
        int count = 1;
        try {
            while (true) {
                Socket client = server.accept();
                System.out.println(client.getInetAddress() + " Connected.");
                new ClientHandler(client, count++).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client: " + e.getMessage());
        } finally {
            stop();
        }
    }

    public void stop() {
        if (server != null) {
            try {
                server.close();
                System.out.println("Server closed.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }
}
