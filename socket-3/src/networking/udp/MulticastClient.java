package networking.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastClient {
    public static void main(String[] args) {
        try {
            // マルチキャストグループのIPアドレスとポート番号を指定
            InetAddress group = InetAddress.getByName("239.0.0.1");
            int port = 12345;

            // データ送信用のソケットを作成
            DatagramSocket socket = new DatagramSocket();

            // 受信バッファ
            byte[] receiveBuffer = new byte[256];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            

            ///////送信///////
            // 送信するコマンドを設定
            String command = "SOME_COMMAND";
            // コマンドをバイト配列に変換して DatagramPacket を作成し、マルチキャストグループに送信
            byte[] buffer = command.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group,
            port);
            socket.send(packet);
            System.out.println("Command sent: " + command);

            //////////返事を受信//////////
            socket.receive(receivePacket);
            String receivedReply = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
            System.out.println("Received reply: " + receivedReply);


            // ソケットを閉じる
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}