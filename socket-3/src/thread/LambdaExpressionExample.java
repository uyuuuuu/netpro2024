package thread;
public class LambdaExpressionExample {
    public static void main(String[] args) {
        // Runnableインターフェースをラムダ式で実装
        Runnable runnable = () -> {
            System.out.println("Running in a lambda expression");
        };
        // 新しいスレッドでラムダ式の実行
        new Thread(runnable).start();
    }
}
