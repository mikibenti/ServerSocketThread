package it.meucci;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(4000);
            do {
                Socket s = ss.accept();
                MyThread t = new MyThread(s);
                t.start();
            } while (true);
        } catch (IOException e) {
            System.out.println("ERRORE");
            System.exit(1);
        }
    }
}
