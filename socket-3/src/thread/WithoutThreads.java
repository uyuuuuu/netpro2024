package thread;

public class WithoutThreads {
    public static void main(String[] args) {
        // タスク1を実行
        task1();

        // タスク2を実行
        task2();
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
