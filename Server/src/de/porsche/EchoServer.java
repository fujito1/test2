package de.porsche;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private ServerSocket serverSocket;
    private Socket connectionSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.printf("Server is listening on port #: %d\n", serverSocket.getLocalPort());
        connectionSocket = serverSocket.accept();
        out = new PrintWriter(connectionSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        String str = in.readLine();
        out.println("Echo: " + str);
    }


}