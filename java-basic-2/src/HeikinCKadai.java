import java.util.Random;

public class HeikinCKadai {
    public static void main(String[] args) {

        Kamoku[] students = new Kamoku[100];
        Random rand = new Random();
        int sum = 0;
        for (int i = 0; i < students.length; i++) {
            int score = rand.nextInt(100);
            students[i] = new Kamoku(score);

            // math の name に "数学" を設定する
            students[i].name = "英語";
            int a = students[i].getScore();
            sum += a;
        }
        int ave = sum / 100;
        System.out.println("平均点は" + ave + "点");

        System.out.println("以下合格者の点数です。");
        for (Kamoku m : students) {
            int sc = m.getScore();
            if (sc >= 80) {
                System.out.println(sc);
            }
        }
    }
}
