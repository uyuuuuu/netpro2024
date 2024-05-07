import java.util.Scanner;

public class MyExceptionHoliday {
    public static void main(String[] args) {
        MyExceptionHoliday myE = new MyExceptionHoliday();

        while (true) {
            try {
                myE.test();
            } catch (NoHolidayException e) {
                e.printStackTrace();
            }
        }
    }

    void test() throws NoHolidayException {
        Scanner scan = new Scanner(System.in);

        System.out.println("5月の日付を入力してください。");
        String line = scan.nextLine();
        int input = Integer.parseInt(line);
        if (input < 1 || input > 31) {
            throw new NoHolidayException();
        } else if (input % 7 != 5 && input % 7 != 4 && input != 3 && input != 6) {
            throw new NoHolidayException();
        } else {
            System.out.println("5月" + input + "日は土日・祝日です。");
        }

    }
}
