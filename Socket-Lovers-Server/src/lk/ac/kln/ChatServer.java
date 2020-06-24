package lk.ac.kln;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {

    //Save the username of clients
    private Set<String> userName=new HashSet<>();
    //Save the client threads who are logging to the system
    private Set<ClientHandler> clientThreads=new HashSet<>();

    public static void main(String[] args) {
	    ChatServer server=new ChatServer();
	    server.executeServer();
    }

    public void executeServer(){
        try {
            //Make a port for a server socket
            ServerSocket socket=new ServerSocket(6000);
            System.out.println("Created a new socket on port 6000");
            while (true){
                //Once a client is joined this will accept that client
                Socket client=socket.accept();
                System.out.println("A new user has connected ! ");
                ClientHandler newUser=new ClientHandler(client,this);
                clientThreads.add(newUser);
                //ClientHandle extends from Thread class. So each user will assign for a separate thread and invoke start method
                newUser.start();
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
    //Get all the username of clients
    public Set<String> getUserName() {
        return userName;
    }

    //Add username for the thread
    void addUserName(String name){
        userName.add(name);
    }

    //Once a client send a message it should broadcast every client in the system
    void broadcast(String message, ClientHandler users) {
        for (ClientHandler aUser : clientThreads) {
            if (aUser != users) {
                aUser.sendMessage(message);
            }
        }
    }
    //Once the client exit from the system, this will remove the username of this user
    void removeUser(String name, ClientHandler user) {
        boolean removed = userName.remove(name);
        if (removed) {
            clientThreads.remove(user);
            System.out.println("The user " + name + " quitted..");
        }
    }
}
