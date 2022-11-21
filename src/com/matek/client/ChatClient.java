package com.matek.client;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatClient {


    public ChatClient(String msg){
        Socket socket; // კლიენტი
        ObjectOutputStream objectOutputStream = null; // ნაკადი
        boolean isStart = true;
        try {
            // კლიენტის შექმნა და კავშირის დამყარება
            socket = new Socket("localhost", 9011);
            System.out.println("Connecting");

            while (isStart) {
                // შეტყობინების გაგზავნა
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(msg);
                System.out.println("Message Sent");

            }
            // ნაკადის და სოკეტის დახურვა
            objectOutputStream.close();
            socket.close();
            System.out.println("Connection Ended");

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
}
