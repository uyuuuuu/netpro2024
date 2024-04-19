import java.util.Arrays;

public class ArraysTest {


    public static void main(String[] args) {

        new ArraysTest();

    }

    ArraysTest() {
        int[] array1 = {2, 4, 3, 5, 1}; // 配列を作成
        String[] array2 = {"い", "え", "あ", "お", "う"}; // 配列を作成
        Integer[] array3 = {2, 4, 3, 5, 1}; // 配列を作成

        Student[] students = new Student[10];

        System.out.println();
        System.out.println("Arrays.sort(array1);");
        Arrays.sort(array1);  //並び替え
        for (int i : array1) {
            System.out.print(i + ","); // 配列の中身を表示
        }
        System.out.println();
        System.out.println("Arrays.sort(array2);");
        Arrays.sort(array2); //並び替え
        for (String str : array2) {
            System.out.print(str + ","); // 配列の中身を表示
        }
        System.out.println();
        System.out.println("Arrays.sort(array3);");
        Arrays.sort(array3); //並び替え
        for (Integer itg : array3) {
            System.out.print(itg + ","); // 配列の中身を表示
        }
        System.out.println();
        System.out.println("System.out.println(\"\");\n");
        Arrays.sort(array3, (a, b) -> a - b); //aのが大きければaを後ろにbaの順番にする。昇順
        for (int i : array3) {
            System.out.print(i + ","); // 配列の中身を表示
        }

        System.out.println();
        System.out.println("¥n Arrays.sort(students,(a,b)->a.score-b.score);");
        for (int i=0;i<10;i++) {
            students[i]= new Student();
            students[i].score = 10 - i;
        }
        //Arrays.sort(students);
        Arrays.sort(students,(a,b)->a.score-b.score);

        for (Student st : students) {
            System.out.print(st.score + ",");
        }
    }

    class Student {
        int score;

    }


}