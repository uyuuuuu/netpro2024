import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckLocalAddress {
    public static void main(String[] args) {
        // IPアドレスからホスト名を取り出す実験
        // IP Address
        try {
            InetAddress addr = InetAddress.getLocalHost();
            // Host name
            System.out.println("Host name is: " + addr.getHostName());
            // Host Address
            System.out.println("Ip address is: " + addr.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("ホスト名の取得に失敗しました。");
            e.printStackTrace();
        }
    }
}
