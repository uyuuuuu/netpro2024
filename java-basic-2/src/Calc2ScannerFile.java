import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calc2ScannerFile {

	public static void main(String args[]){
		try{
			File file = new File("src\\targetfile.txt");
			Scanner scan = new Scanner(file);
			scan.useDelimiter("¥¥r¥¥n");

			int line = 1;

			while(scan.hasNext()){
				String str = scan.nextLine();
				System.out.println(line + ":" + str);
				String[] nums = str.split(" ");
				System.out.println("合計は"+(Integer.parseInt(nums[0])+Integer.parseInt(nums[1])));
				line++;
			}
			scan.close();
		}catch(FileNotFoundException e){
			System.out.println(e);
		}
	}
}

//  課題    ファイルから読み込むキーボードから2つの数字を打ち込む
//     その足し算結果を、出力する。
