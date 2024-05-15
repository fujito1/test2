package de.porsche;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        EchoClient client = new EchoClient();
        EchoClient client2= new EchoClient();
        try {
            client.startConnection("127.0.0.1", 7788);  //localhost 127.0.0.1
            client2.startConnection("127.0.0.1", 7789);
            String response = client.sendMessage("hello server");
            String response2= client2.sendMessage("du kleiner hurensohn");
            System.out.println(response2);
            System.out.println(response);
            client.stopConnection();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}