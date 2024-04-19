public class ConditionalStatements {
    public static void main(String[] args) {
        // ifステートメントの例
        int number = 20;
        if (number > 0) {
            System.out.println("数は正です。"); // 条件が真の場合に実行される
        }

        // if-elseステートメントの例
        if (number % 2 == 0) {
            System.out.println("数は偶数です。"); // 条件が真の場合に実行される
        } else {
            System.out.println("数は奇数です。"); // 条件が偽の場合に実行される
        }

        // else-ifラダーの例
        int score = 75;
        if (score >= 90) {
            System.out.println("成績は優です。");
        } else if (score >= 70) {
            System.out.println("成績は良です。"); // 上の条件が偽でこの条件が真の場合に実行される
        } else if (score >= 50) {
            System.out.println("成績は可です。");
        } else {
            System.out.println("成績は不可です。"); // すべての条件が偽の場合に実行される
        }

        // switchステートメントの例
        int month = 4;
        switch (month) {
            case 1:
                System.out.println("1月");
                break;
            case 2:
                System.out.println("2月");
                break;
            case 3:
                System.out.println("3月");
                break;
            case 4:
                System.out.println("4月"); // monthが4の場合、このブロックが実行される
                break;
            default:
                System.out.println("1〜4月以外の月");
                break; // 上のどの条件にも当てはまらない場合に実行される
        }
    }
}

