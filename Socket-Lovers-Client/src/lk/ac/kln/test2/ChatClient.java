

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

    //private String host;
    private String username;

    public static void main(String[] args) {
        ChatClient client=new ChatClient();
        client.executeClient();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void executeClient(){
        try {
            Socket socket=new Socket("localhost",6000);
            System.out.println("Connected to the chat server");

            new ReadThread(socket,this).start();
            new WriteThread(socket,this).start();

        } catch(UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

