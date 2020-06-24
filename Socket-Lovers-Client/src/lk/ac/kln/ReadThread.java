package lk.ac.kln;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread  extends Thread{
    private BufferedReader reader;
    private Socket socket;
    private ChatClient client;
    private ChatEncryption encryption=new ChatEncryption();

    public ReadThread(Socket socket,ChatClient client){
        this.socket=socket;
        this.client=client;

        try {
            InputStream input=socket.getInputStream();
            reader=new BufferedReader(new InputStreamReader(input));
        } catch (IOException e) {
            System.out.println("Client Socket closed ...");
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                String response=reader.readLine();
                String[] reply=response.split(":");
                if(reply.length == 2)
                    System.out.println("\n"+ reply[0]+ ":"+encryption.decrypt(reply[1]));
                else
                    System.out.println("\n"+response);

                if(client.getUsername()!=null)
                    System.out.println(client.getUsername()+ " : ");
            } catch (IOException e) {
                System.out.println("Client left....");
                break;
            }
        }
    }
}
