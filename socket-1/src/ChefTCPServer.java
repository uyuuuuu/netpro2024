import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChefTCPServer {

    private static String serverProcess(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("〈");
        sb.append(content);
        sb.append("〉");
        String result = sb.toString();
        return result;
    }

    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                /////// 注文を受信 ////////
                Object inSt = ois.readObject();
                if (inSt instanceof String && inSt.equals("checkout")) {
                    System.out.println("お会計終了！接続を終了します");
                    oos.writeObject("checkout");
                    oos.flush();
                    break;
                } else {
                    //////// 料理を送信 ////////
                    Chef chef = (Chef) inSt;
                    chef.cook();
                    String dish = chef.getDish();
                    int dishTime = chef.getTime();
                    String dishQuality = chef.getQuality();
                    String msg = chef.getMessage();
                    System.out.println("注文料理名："+dish);
                    System.out.println("届いたメッセージ："+msg);

                    Chef response = new Chef();
                    response.setMessage(
                            "\"" + msg + "\"？そうか、私に任せなさい！\n" + "...(" + dishTime + "分後)...\n" + "シェフ( -ω-)_旦{ 完成だ！");
                    response.setDish(serverProcess(dishQuality + dish));
                    response.setNextMessage("他にご注文は？");
                    oos.writeObject(response);
                    oos.flush();
                }
            }

            // close処理
            ois.close();
            oos.close();
            // socketの終了。
            socket.close();
            server.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
