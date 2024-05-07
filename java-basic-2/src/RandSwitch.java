import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandSwitch {  // 乱数発生

	public static void main(String[] args){

		try {
			while (true) {
				System.out.print("?");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String line = reader.readLine();
				int x = 1 + (int)((Math.random())*6.0);
				System.out.println(x);


				switch (x) {
				case 1:
					System.out.println("１です");
					break;    //break を書き忘れがちなので注意!
				case 6:
					System.out.println("りんご");
					break;    //break を書き忘れがちなので注意! 
				case 3:
					System.out.println("ばなな");
					break;
				default: // それ以外
					System.out.println("いちご");
				}

// 上を踏まえて switch case を使って：
//  1、6のときは  りんご
//  3のときは ばなな
//  それ以外のときは いちご　を表示する


			}
		}
		catch (IOException e) {
			System.out.println(e);
		}

	}

}