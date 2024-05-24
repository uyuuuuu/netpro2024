package thread;
public class WithThreads {
    public static void main(String[] args) {
        // タスク1を実行するスレッドを生成し、開始
        Thread thread1 = new Thread(() -> {
            task1();
        });
        thread1.start();

        // タスク2を実行するスレッドを生成し、開始
        Thread thread2 = new Thread(() -> {
            task2();
        });
        thread2.start();
    }

    public static void task1() {
        // タスク1の処理
        System.out.println("Task 1 is executed");
    }

    public static void task2() {
        // タスク2の処理
        System.out.println("Task 2 is executed");
    }
}
