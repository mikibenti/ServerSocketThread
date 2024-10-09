package it.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Server partito");
            ServerSocket ss;
            ss = new ServerSocket(4000);
            Socket mySocket = ss.accept();
            System.out.println("COLLEGAMENTO STABILITO");
            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            String stringRed = in.readLine();
            System.out.println("Stringa ricevuta : " + stringRed);
            String stringMaius = stringRed.toUpperCase();
            out.writeBytes(stringMaius + '\n');
            mySocket.close();
            ss.close();
        } catch (IOException e) {
            System.out.println("ERRORE");
            System.exit(1);
        }
    }
}
