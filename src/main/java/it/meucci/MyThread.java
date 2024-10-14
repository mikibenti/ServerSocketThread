package it.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread extends Thread{
    private Socket mySocket;

    public MyThread(Socket s) {
        mySocket = s;
    }

    @Override
    public void run() {
            String stringRed = "";
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
                do {
                    stringRed = in.readLine();
                    System.out.println("Stringa ricevuta : " + stringRed);
                    String stringMaius = stringRed.toUpperCase();
                    out.writeBytes(stringMaius + '\n');
                } while(!stringRed.equals("!"));
                mySocket.close();
            } catch (Exception e) {
                System.err.println("ERRORE");
            }
        super.run();
    }
}
