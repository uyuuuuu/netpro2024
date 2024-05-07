public class HeikinA {
	public static void main(String[] args){

// Kamokuクラスのインスタンスとして、englishを
// 作る
	Kamoku english = new Kamoku(80);
// 同様に、math
	Kamoku math = new Kamoku(70);

// english の name に "英語" を設定する
	english.name = "英語";
	int a = english.getScore();
	System.out.println("英語の点は" + a + "ですね");
	int b;
	b = math.getScore();
	System.out.println("数学の点は" + b + "ですね");
		int ave=(a+b)/2;
		System.out.println("平均点は" + ave + "ですね");


	}
}
