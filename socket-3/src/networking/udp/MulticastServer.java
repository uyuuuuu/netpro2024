package networking.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServer {
    public static void main(String[] args) {
        try {
            // マルチキャストグループのIPアドレスとポート番号を指定
            InetAddress group = InetAddress.getByName("239.0.0.1");
            int port = 12345; // 自分の？ポート

            // マルチキャストソケットを作成し、指定したグループとポートに参加
            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(group); // 非推奨になったらしい

            System.out.println("Server started. Waiting for commands...");

            // 受信用バッファを作成
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // コマンドを受信して永遠に待機
            while (true) {
                /////////// 受信//////////
                multicastSocket.receive(packet);//受信するまで"待機"する！！
                // 日本語対応↓
                String receivedCommand = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received command: " + receivedCommand);

                String repmessage = "thanks!";
                byte[] bytesToSend = repmessage.getBytes();
                System.out.println("sending msg is" + repmessage);
                InetAddress repnetaddress = packet.getAddress();
                int repportnum = packet.getPort();
                DatagramPacket repPacket2 = new DatagramPacket(bytesToSend, bytesToSend.length, repnetaddress,
                        repportnum);
                multicastSocket.send(repPacket2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}