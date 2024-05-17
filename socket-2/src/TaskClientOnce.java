import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientOnce {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in,"Shift-JIS");
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            // 送信 oos
            System.out.println("数値を入力してください！");
            int inputNum = scanner.nextInt();
            TaskObject task = new TaskObject();
            task.setExecNumber(inputNum);
            oos.writeObject(task);//送信
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            // 応答を受信 ois
            TaskObject response = (TaskObject)ois.readObject();
            System.out.println("演算結果は " + response.getResult() + " です。");

            // 6. 接続を閉じる
            socket.close();
            scanner.close();
        } catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
