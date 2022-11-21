package com.matek.server;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ChatServerRunnable implements Runnable {
    private Socket client;
    private int clientID;
    private boolean running = true;

    public ChatServerRunnable(Socket socket, int clientId) {
        client = socket;
        this.clientID = clientId;
    }

    @Override
    public void run() {
        System.out.println("Connected to: ID - " + clientID + " : Address: " + client.getInetAddress().getHostName());

        try {
            // მონაცემების წაკითხვა და ეკრანზე გამოტანა
            System.out.println("Reading Data...");
            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            String str = (String) objectInputStream.readObject();
            System.out.println("Message: " + str);

            // ნაკადის და სერვერის დახურვა
            // objectInputStream.close();
            System.out.println("Connection Ended ");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }


}
