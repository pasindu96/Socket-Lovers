package lk.ac.kln;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket client;
    private ChatServer server;
    private PrintWriter writer;

    ClientHandler(Socket client,ChatServer server){
        this.client=client;
        this.server=server;
    }
    @Override
    public void run() {
        try {
            InputStream input=client.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(input));

            OutputStream output=client.getOutputStream();
            writer=new PrintWriter(output,true);

            String username=reader.readLine();
            server.addUserName(username);

            String serverMessage="New User connected -> "+username + "[ Type 'bye' to end the chat... ]";
            //Should broadcast to other uses when a new user connected to the server
            server.broadcast(serverMessage,this);

            String clientMessage;
            do{
                clientMessage=reader.readLine();
                serverMessage = username + " : "+clientMessage;
                server.broadcast(serverMessage,this);
            }while(!clientMessage.equals("bye"));
            //If  the user type bye in the chat user should remove from the server client list
            server.removeUser(username,this);
            client.close();

            serverMessage= username + " has quitted..";
            server.broadcast(serverMessage,this);

        } catch (IOException e) {
//            System.out.println("Error in UserThread: " + e.getMessage());
//            e.printStackTrace();
        }
    }
    void sendMessage(String message){
        writer.println(message);
    }
}
