import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


public class LoopAdvance {
    
    public static void main(String[] args) throws Exception {

        System.out.println("----Loop 1----");
        //文字列リストの要素を順番に処理する:↓↓
        List<String> fruits = Arrays.asList("りんご", "バナナ", "オレンジ", "グレープ", "パイナップル");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println("----Loop 2----");
        //文字列リストの要素を逆順に処理する:↓↓
        List<String> colors = Arrays.asList("赤", "青", "緑", "黄", "紫");
        
        for (int i = colors.size() - 1; i >= 0; i--) {
            System.out.println(colors.get(i));
        }
        
        System.out.println("----Loop 3----");
        //特定の条件に合致する文字列を検索する:↓↓
        List<String> animals = Arrays.asList("犬", "猫", "ウサギ", "ハムスター", "鳥");
        for (String animal : animals) {
            if (animal.equals("猫")) {
                System.out.println("猫が見つかりました！");
                break;
            }
        }

        System.out.println("----Loop 4----");
        //2次元配列の要素をイテレートする:↓↓
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("----Loop 5----");
        //無限ループ（特定の条件で終了）:↓↓
        int count = 0;
        while (true) {
            System.out.println("無限ループの例");
            count++;
            if (count >= 10) {
                break; // 10回繰り返したらループを終了
            }
        }
        /*
        System.out.println("----Loop 6----");
        //ファイルの行を読み込みながら処理する:↓↓
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

        System.out.println("----Loop 7----");
        //有効な入力の判定While
        Scanner scanner = new Scanner(System.in);
        int userInput;
        while (true) {
            System.out.print("0から10までの数値を入力してください: ");
            userInput = scanner.nextInt();
            if (userInput >= 0 && userInput <= 10) {
                System.out.println("有効な入力です。入力された数値は " + userInput + " です。");
            break;
            } else {
                System.out.println("無効な入力です。再度入力してください。");
            }
        }
        scanner.close();
        
        System.out.println("----Loop 8----");
        //リスト内の要素を条件に基づいてフィルタリングする:↓↓
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.println("偶数: " + num);
            }
        }

        System.out.println("----Loop 9----");
        //条件に合致する要素をリストから削除する:
        List<Integer> number2s = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int index = 0;
        while (index < number2s.size()) {
            if (number2s.get(index) % 2 == 0) {
                number2s.remove(index);
            } else {
                index++;
            }
        }
        System.out.println("奇数だけを残したリスト: " + numbers);

        System.out.println("----Loop 10----");
        //マルチスレッドで並列処理する:↓↓
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable task = () -> System.out.println(Thread.currentThread().getName() + "が処理中");
            executor.execute(task);
        }
        executor.shutdown();
        
        System.out.println("----Loop 12----");
        //検索条件に合致する要素をリストから削除する:↓↓
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "Alice", "David"));
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("Alice")) {
                iterator.remove();
            }
        }
        System.out.println(names);
        
        System.out.println("----Loop 13----");
        //ネストしたループからの早期脱出:↓↓
        outerloop:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i * j > 6) {
                    System.out.println("早期脱出");
                    break outerloop;
                }
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }

        System.out.println("----Loop 14----");
        //数学的なシーケンスを生成する:↓↓
        IntStream.iterate(0, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);

    }


}
