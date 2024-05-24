package thread;
public class DeadlockExample {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    ////////////////////////////////////////
    //////////     出ない！！！    /////////
    ////////////////////////////////////////
    public static void main(String[] args) {
        // スレッド1: リソース1をロックし、リソース2をロックしようとする
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked resource 1");

                // 少し待機してからリソース2をロックしようとする
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1: Trying to lock resource 2");
                synchronized (resource2) {
                    System.out.println("Thread 1: Locked resource 2");
                }
            }
        });

        // スレッド2: リソース2をロックし、リソース1をロックしようとする
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked resource 2");

                // 少し待機してからリソース1をロックしようとする
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2: Trying to lock resource 1");
                synchronized (resource1) {
                    System.out.println("Thread 2: Locked resource 1");
                }
            }
        });

        // スレッド1とスレッド2を開始
        thread1.start();
        thread2.start();
    }
}
