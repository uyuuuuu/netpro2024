import java.util.Scanner;

public class Calc2Scanner {

	public static void main(String[] args) {
		int i=0;
		Scanner scan = new Scanner(System.in);;
		while(i<10) {
			String str = scan.next();
			System.out.println("最初のトークンは: " + str);
			int first = Integer.parseInt(str);
			str = scan.next();
			System.out.println("次のトークンは  : " + str);
			int second = Integer.parseInt(str);
			System.out.println("合計は"+(first+second));
			i++;
		}
		scan.close();

	}
}

//  課題    キーボードから2つの数字を打ち込む
//     その足し算結果を、出力する。