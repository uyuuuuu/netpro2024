package networking.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
//受信側
public class MyMulticastReceiver {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("239.0.0.1");
            int port = 12345; // 自分の？ポート

            // マルチキャストソケットを作成し、指定したグループとポートに参加
            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(group); // 非推奨になったらしい

            System.out.println("Waiting for commands...");

            // 受信用バッファを作成
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            int food = 20;

            // コマンドを受信して永遠に待機
            while (true) {
                /////////// 受信//////////
                multicastSocket.receive(packet);//受信するまで"待機"
                // 日本語対応↓
                String receivedCommand = new String(packet.getData(), 0, packet.getLength());
                int order = Integer.parseInt(receivedCommand);
                System.out.println("Cat: " + receivedCommand);
                
                String repmessage = "Here you are!";
                for(int i=0;i<order;i++){
                    repmessage += "旦";
                }
                if(food<order){ repmessage = "Sorry, sold out...;;"; }
                else{food -= order;}
                
                byte[] bytesToSend = repmessage.getBytes();
                InetAddress repnetaddress = packet.getAddress();
                int repportnum = packet.getPort();
                DatagramPacket repPacket2 = new DatagramPacket(bytesToSend, bytesToSend.length, repnetaddress,
                        repportnum);
                multicastSocket.send(repPacket2);

                if(food<=0){
                    System.out.println("Send: " + repmessage);
                    System.out.println("**sold out**");
                }else{
                    System.out.println("Send: " + repmessage + "(@"+food+"foods)");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}