package com.matek.server;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    ServerSocket serverSocket; // სერვერი
    Socket socket = null; // კლიენტი
    ObjectInputStream objectInputStream; // ნაკადი
    String str; // მიღებული მონაცემი
    int clientId = 0;
    ChatServerRunnable serverRunnable;

    public ChatServer(int port) {

        createServer();
    }

    private void createServer(){

        try {
            // სერვერის შექმნა
            serverSocket = new ServerSocket(9011);
            System.out.println("Server On");

            while (true) {
                // კავშირის დამყარება
                socket = serverSocket.accept();
                serverRunnable = new ChatServerRunnable(socket, clientId);
                Thread t = new Thread(serverRunnable);
                t.start();
                System.out.println("Connected");
                clientId++;
            }

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

}
