package lk.ac.kln;

import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket client;
    private ChatServer server;
    //private PrintWriter writer;

    ClientHandler(Socket client,ChatServer server){
        this.client=client;
        this.server=server;
    }
    public static void main(String[] args) {

    }

    @Override
    public void run() {
        //Client handling part
    }
    void sendMessage(String message){
        //should use printwriter
    }
}
