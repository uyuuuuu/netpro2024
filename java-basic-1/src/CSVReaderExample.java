import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderExample {
    public static void main(String[] args) {
    String csvFile = "src/file.csv"; // ファイルのパスを指定してください
    String line = "";
    String csvSplitBy = ","; // CSVファイルの区切り文字を指定してください

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int count = 0;
            while ((line = br.readLine()) != null) {
                // 1行をカンマで分割して単語の配列を取得
                String[] words = line.split(csvSplitBy);

                // 単語を一つずつ出力
                // for (String word : words) {
                //     System.out.println(word);
                // }
                if(count==0) { System.out.println(words[3]); }
                count++;
            }//while end
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main end
}//class end

