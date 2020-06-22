

public class ChatEncryption {
    public String encrypt(String message){

        char[] arr=new char[message.length()];
        int y=0;
        for(int i=message.length()-1;i>=0;i--,y++){
            //System.out.println(message.charAt(i));
            arr[y]=message.charAt(i);
            //System.out.println(arr[y]);
        }
        return String.valueOf(arr);
    }
    public String decrypt(String message){
        char[] arr=new char[message.length()];
        int y=message.length()-1;
        for(int i=0;i<message.length();i++,y--){
            arr[y]=message.charAt(i);
        }
        return String.valueOf(arr);
    }

//    public static void main(String[] args) {
//        ChatEncryption chat=new ChatEncryption();
//        System.out.println(chat.encrypt("hello pren").toString());
//        System.out.println(chat.decrypt(chat.encrypt("hello pren").toString()).toString());
//    }
}
