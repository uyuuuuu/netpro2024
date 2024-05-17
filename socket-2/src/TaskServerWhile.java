import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TaskServerWhile {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket serverSocket = new ServerSocket(port);
            scanner.close();
            System.out.println("Waiting for client connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

            while (true) {
                // 受信 ois
                TaskObject task = (TaskObject) ois.readObject();
                if (task.input <= 0) {
                    System.out.println("終了");
                    break;
                } else {
                    System.out.println("入力数値: " + task.input);
                    // 応答を送信 oos
                    task.exec(); // 計算
                    oos.writeObject(task);
                    oos.flush();
                }
            }

            ois.close();
            oos.close();
            clientSocket.close();
            serverSocket.close();
        } catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}