package thread;

public class CountAZTenRunnable implements Runnable {
    // CountTenRunnable.javaを改造してCountAZTenRunnable.javaを作成せよ。
    // a-zまでスレッドを26個作成し自動で10までカウントアップせよ。
    // コンソール出力の結果も6_C_Result.txtに記載し、socket-3フォルダに入れて提出せよ。
    //private static char[] cl = new char[26];
    private char c;
    public CountAZTenRunnable(char c){
        this.c=c;
    }
    public static void main(String[] args){
        char c1 = 97; // ASCII値 97 は 'a' です
        //char c2 = (char)(c1 + 1); // c1 に 1 を足すと ASCII値 98 になり、'b' になります
        char[] cl = new char[26];
        int firstChar = 97;
        for(int i=0;i<cl.length;i++){
            cl[i] = (char)(firstChar + i);
        }

        // スレッド作成
        Thread[] thList = new Thread[cl.length];
        for(int i=0;i<cl.length;i++){
            CountAZTenRunnable ct = new CountAZTenRunnable((char) (97 + i));
            thList[i] = new Thread(ct);
            thList[i].start();
        }

    }

    public void run() {
        // この try-catch ブロックは、0 から 9 までの値を 1000 ミリ秒間隔で出力するループを実行します。
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println(c+""+(i+1));
                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(1000);  // ミリ秒単位のスリープ時間
            }
        }
        catch(InterruptedException e) {
            System.err.println(e);
        }
    }
    // public void setChar(char c){
    //     this.c=c;
    // }
}
