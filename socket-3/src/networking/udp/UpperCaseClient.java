package networking.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpperCaseClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // クライアントからのメッセージをユーザに入力させる
                System.out.println("次郎さんが大文字にして返してくれます！");
                String clientMessage = "";
                // 英語判定
                while(true){
                    System.out.print("英語を入力してください(終了はexit): ");
                    clientMessage = scanner.nextLine();
                    String alphabet = "^[A-Za-z]+$";
                    Pattern p = Pattern.compile(alphabet);
                    Matcher m = p.matcher(clientMessage);
                    if(m.matches()) break;
                }
                // 終了処理
                if(clientMessage.equals("exit")) {
                    scanner.close();
                    sendData = clientMessage.getBytes();
                    // exitをサーバに送信
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
                    socket.send(sendPacket);
                    break;
                }else{
                    sendData = clientMessage.getBytes();

                    // メッセージをサーバに送信
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
                    socket.send(sendPacket);

                    // サーバからの返信を受信
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    socket.receive(receivePacket);
                    String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("次郎さん: " + serverResponse);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
