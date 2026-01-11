package org.example.layer0tcp;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws Exception {
        int port = 9000;

        System.out.println("Starting TCP Server on port " + port);

        ServerSocket serverSocket = new ServerSocket(port);

        // Server waits (blocks) here until a client connects
        Socket clientSocket = serverSocket.accept();

        System.out.println("Client connected: " + clientSocket.getInetAddress());

        InputStream input = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Received from client: " + line);

            // Echo back
            writer.write("Echo: " + line);
            writer.newLine();
            writer.flush();
        }

        System.out.println("Client disconnected");
        clientSocket.close();
        serverSocket.close();
    }
}

