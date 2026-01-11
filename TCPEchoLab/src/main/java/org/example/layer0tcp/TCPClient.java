package org.example.layer0tcp;
import java.io.*;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 9000;

        Socket socket = new Socket(host, port);

        System.out.println("Connected to server");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));

        // Send messages
        for (int i = 1; i <= 3; i++) {
            String msg = "Message " + i;
            System.out.println("Sending: " + msg);

            writer.write(msg);
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println("Received: " + response);

            Thread.sleep(1000);
        }

        socket.close();
        System.out.println("Connection closed");
    }
}

