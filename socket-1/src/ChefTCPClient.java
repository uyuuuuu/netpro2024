import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class ChefTCPClient {
    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in,"Shift-JIS");
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while(true){
                ////////// 送信 ////////////
                System.out.println("< 注文を送りましょう！お会計をする場合は\"checkout\"と入力してください！");

                System.out.println("< 注文する料理を入力してください(例:オムライス) ↓");
                String dish = scanner.next();
                if(dish.equals("checkout")) {
                    System.out.println("< ご来店ありがとうございました！");
                    System.out.println("< シェフ( -ω-){ また来てね");
                    oos.writeObject("checkout");
                    oos.flush();
                    scanner.close();
                    break;
                }
                System.out.println("< シェフへのメッセージをどうぞ！(例:美味しく作ってね) ↓");
                String message = scanner.next();
                if(message.equals("checkout")) {
                    System.out.println("< ご来店ありがとうございました！");
                    System.out.println("< シェフ( -ω-){ また来てね");
                    oos.writeObject("checkout");
                    oos.flush();
                    scanner.close();
                    break;
                }

                Chef chef = new Chef();
                chef.setDish(dish);
                chef.setMessage(message);
                oos.writeObject(chef); //送信
                oos.flush();

                //////// シェフの返答を受信 ///////////
                Object inSt = ois.readObject(); //受信

                if(inSt instanceof Chef){
                    Chef serve = (Chef) inSt;
                    String replayMsg = serve.getMessage();
                    System.out.println("\nシェフ( -ω-){ " + replayMsg);
                    String replayDish = serve.getDish();
                    System.out.println(replayDish + "を受け取りました！");
                    String replayNextMessage = serve.getNextMessage();
                    System.out.println("\nシェフ( -ω-){ " + replayNextMessage);
                }
            }
            scanner.close();
            ois.close();
            oos.close();
            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
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
