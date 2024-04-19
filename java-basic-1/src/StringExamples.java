public class StringExamples {
    public static void main(String[] args) {
        // 文字列の定義
        String greeting = "Hello, World!";
        
        // length() - 文字列の長さを取得
        System.out.println("Length: " + greeting.length()); // 出力: 13

        // charAt() - 指定位置の文字を取得
        System.out.println("Character at position 7: " + greeting.charAt(7)); // 出力: W

        // substring() - 部分文字列を取得
        System.out.println("Substring from 7 to 12: " + greeting.substring(7, 13)); // 出力: World!

        // equals() - 文字列が等しいかどうか比較
        String anotherGreeting = "Hello, World!";
        System.out.println("Equals: " + greeting.equals(anotherGreeting)); // 出力: true

        // toLowerCase() と toUpperCase() - 大文字と小文字の変換
        System.out.println("Lowercase: " + greeting.toLowerCase()); // 出力: hello, world!
        System.out.println("Uppercase: " + greeting.toUpperCase()); // 出力: HELLO, WORLD!

        // contains() - 文字列が指定した文字列を含むかどうか
        System.out.println("Contains 'World': " + greeting.contains("World")); // 出力: true

        // indexOf() - 文字列内の特定の文字/文字列の最初の位置
        System.out.println("Index of 'World': " + greeting.indexOf("World")); // 出力: 7

        // replace() - 文字列内の文字や文字列を別のものに置換
        System.out.println("Replace 'World' with 'Java': " + greeting.replace("World", "Java")); // 出力: Hello, Java!

        // split() - 文字列を特定の区切り文字で分割して配列にする
        String[] words = greeting.split(", ");
        System.out.println("Split into: " + java.util.Arrays.toString(words)); // 出力: [Hello, World!]

        // trim() - 文字列の前後の空白を削除
        String spacedString = "   Hello, Java!   ";
        System.out.println("Trimmed: '" + spacedString.trim() + "'"); // 出力: 'Hello, Java!'
    }
}
