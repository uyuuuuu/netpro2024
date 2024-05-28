package thread;

import java.util.Random;

public class ExThreadsMain implements Runnable {
    private String name;
    private int[] myScore;
    private int scoreSum;
    public ExThreadsMain(String name, int[] score){
        this.name = name;
        this.myScore = score;
    }
    public static void main(String[] args){
        String[] name = new String[]{"Nekko","Innu","Hamham"};
        int n = 3; //ステージ数
        int[][] score = new int[name.length][n];
        for(int[] s:score){
            for(int i=0;i<n;i++){ s[i] = new Random().nextInt(100);}
        }
        // スレッド作成
        Thread[] thList = new Thread[score.length];
        for(int i=0;i<score.length;i++){
            ExThreadsMain ct = new ExThreadsMain(name[i], score[i]);
            thList[i] = new Thread(ct);
            thList[i].start();
        }
    }

    public void run() {
        // この try-catch ブロックは、0 から 9 までの値を 1000 ミリ秒間隔で出力するループを実行します。
        try {
            for(int i = 0; i < myScore.length; i++) {
                scoreSum += myScore[i];
                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(1000);  // ミリ秒単位のスリープ時間
            }
            System.out.println(name+"\'s Score Result " + scoreSum);
        }
        catch(InterruptedException e) {
            System.err.println(e);
        }
    }
}
