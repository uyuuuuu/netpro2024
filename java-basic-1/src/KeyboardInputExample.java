import java.util.Scanner; // Scannerクラスをインポート

public class KeyboardInputExample {
    public static void main(String[] args) {
        // Scannerオブジェクトを作成し、System.inを引数に指定して初期化
        Scanner scanner = new Scanner(System.in);

        // ユーザーに名前の入力を促す
        System.out.println("あなたの名前を入力してください:");

        // nextLine()メソッドを使用してユーザー入力を文字列として読み取る
        String name = scanner.nextLine();
        System.out.println("こんにちは、" + name + "さん!");

        // ユーザーに年齢の入力を促す
        System.out.println("あなたの年齢を入力してください:");

        // nextInt()メソッドを使用してユーザー入力を整数として読み取る
        int age = scanner.nextInt();
        System.out.println("あなたは" + age + "歳です。");

        // ユーザーに浮動小数点数の入力を促す
        System.out.println("好きな実数を入力してください:");

        // nextDouble()メソッドを使用してユーザー入力を浮動小数点数として読み取る
        double favoriteNumber = scanner.nextDouble();
        System.out.println("あなたの好きな実数は" + favoriteNumber + "です。");

        // Scannerのリソースを解放する
        scanner.close();
    }
}

