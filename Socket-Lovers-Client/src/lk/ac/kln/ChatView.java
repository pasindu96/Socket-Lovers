package lk.ac.kln;

import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatView extends JFrame{
    public String username;
    private JTextField txtMessage;
    private JButton btnSend;
    private JPanel panelMain;
    private JTextArea txtChatArea;
    private JTextField txtName;

    public ChatView() {

        username=JOptionPane.showInputDialog("Enter your username : ");
        txtName.setEditable(false);
        txtName.setText(username);

        btnSend.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Check");
            }
        });
    }

    public static void main(String[] args) {
        //JFrame frame=new JFrame("ChatView");
        ChatView frame=new ChatView();
        frame.setContentPane(new ChatView().panelMain);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
//        frame.executeClient();
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void test(){
//        txtChatArea.setText(username);
//    }

//    public void executeClient(){
//        try {
//            Socket socket=new Socket("localhost",6000);
//            System.out.println("Connected to the chat server");
//
//            new ReadThread(socket,this).start();
//            new WriteThread(socket,this).start();
//
//        } catch(UnknownHostException e){
//            e.printStackTrace();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
