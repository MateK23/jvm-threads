package com.matek.client;

public class Main {
    public static void main(String[] args) {
        new ChatClient("Hello");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new ChatClient("Hi");
    }
}
