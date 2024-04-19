import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperationTest {

	public static void main(String[] args) {
		String sentence = "Enjoy Java World Good Life Java Hello Java";
		System.out.println("--------------------");
		System.out.println("文字列の長さは"+sentence.length()+"文字");//空白文字もカウントする。
		System.out.println("--------------------");
		System.out.println("Javaという単語が最初に出てくる位置は"+sentence.indexOf("Java")+"文字目");//最初にJavaが出る位置をindexOfで検索。
		System.out.println("--------------------");
		System.out.println("Javaという単語が2番目に出てくる位置は"+sentence.indexOf("Java",sentence.indexOf("Java")+1)+"文字目");//第二引数は何文字目から検索を開始するかを指定するため、一度Javaを検索してその次の文字から検索してもらう。
		System.out.println("--------------------");
		System.out.println("Javaという単語が最後に出てくる位置は"+sentence.lastIndexOf("Java")+"文字目");//後ろから検索してJavaが出る位置が何文字目か調べる。
		System.out.println("--------------------");
		System.out.println("Worldの位置とHelloの位置の間を抽出した文字を表示すると・・・");
		String first_search = "World";//抽出する最初の文字
		String last_search = "Hello";//抽出する最後の文字
		int first_index = sentence.indexOf(first_search);//Worldの位置
		int last_index = sentence.indexOf(last_search);//Helloの位置
		first_index += first_search.length();//WorldとHelloの間を抽出するため、Worldのwの位置からWorldのdの次の文字の位置まで移動させる。
		System.out.println(sentence.substring(first_index, last_index));
		System.out.println("--------------------");
		System.out.println("全て大文字にして表示すると・・・");
		System.out.println(sentence.toUpperCase());//大文字や小文字に関係なく単語を検索したいときなどに使用することが多い。
		System.out.println("--------------------");
		System.out.println("全て小文字にして表示すると・・・");
		System.out.println(sentence.toLowerCase());//大文字や小文字に関係なく単語を検索したいときなどに使用することが多い。
		System.out.println("--------------------");
		String search = "C++";//存在するか確かめる単語
		String exist = null;
		if(sentence.contains(search)) {
			exist = "存在します。";
		}else {
			exist = "存在しません。";
		}
		System.out.println("この文字列に"+search+"は"+exist);
		System.out.println("--------------------");
		System.out.println("文字を分割すると・・・");
		String[] word = sentence.split(" ");//splitメソッドの引数に、どこの文字で分割するか指定します。この場合は空白文字。
		for(String w:word) {
			System.out.println(w);
		}
		System.out.println("--------------------");
		System.out.println("先程区切った文字を,区切りで表示すると・・・");
		System.out.println(String.join(",",word));//joinメソッドの第一引数で区切る文字を指定する。第二引数は文字連結する配列を指定する。
		System.out.println("--------------------");
		System.out.println("先程区切った文字[]で囲んで表示すると・・・");
		StringJoiner joiner = new StringJoiner(",","[","]");//第一引数で区切る文字、第二引数で最初に表示する文字、第三引数で最後に表示する文字を指定する。
		for(String w:word) {
			joiner.add(w);
		}
		System.out.println(joiner.toString());
		System.out.println("--------------------");
		//おまけ　正規表現による文字検索（難しいので理解できなくても良いです）
		//正規表現のパターンの法則はwebで調べるといろいろ出てくるため、調べてみてください。
		String matcher_sample1 = "東京都足立区千住旭町5番";
		String matcher_sample2 = "xxxxxx@ms.im.dendai.ac.jp";
		String matcher_sample3 = "C++が好きだ";
		String matcher_sample4 = "ABCDEFG";
		String matcher_sample5 = "hogehoge.png";
		System.out.println("正規表現1は"+matcher_sample1.matches(".*"));
		// 「.」は任意の文字、「*」は0文字以上、「.*」にすると何の文字があっても何もなくてもtrueを返します。
		System.out.println("正規表現2は"+matcher_sample2.matches(".+@.+"));
		// 「.」は任意の文字、「+」は1文字以上、「.+」にすると何か文字があればtrueを返します。この場合は@があって、その前と後ろに何か文字があればtrueです。
		System.out.println("正規表現3は"+matcher_sample3.matches("^(Java|C\\+\\+|python)が好きだ"));
		//　^は次の文字が先頭である必要があります。今回の場合は()で括られた中の部分が先頭である必要があります。|で区切ったそれぞれの単語の内いずれかが登場し、その後に「が好きだ」という言葉が続くとtrueです。（）で括らないと、「Java」、「C++」、「puthonが好きだ」でtrueとなってしまいます。
		//　+はエスケープ処理が必要（既に正規表現で役割が与えられているため、区別する必要）なため、\\+とします。
		System.out.println("正規表現4は"+matcher_sample4.matches("^[A-Z]+$"));
		// ^は先頭の文字です。[]の中はここで括られた中の1つの文字であればtrueを返します。（[aj]ならaかｊ）今回は-で範囲指定しているため、AからZの中の1文字です。つまり英字大文字の意味になります。
		// +は直前の文字がなにか一文字以上あればtrueを返すので、この場合[A-Z]が1文字以上あればtrueを返します。$は文末の文字でtrueを返します。
		//全体を通すと英字大文字以外の文字が入っていればfalseになり、何も文字が入っていない場合もfalseになります。
		// [a-z]や[0-9]、[a-zA-Z]などとすることもできます。
		System.out.println("正規表現5は"+matcher_sample5.matches(".+\\.(jpg|png|jpeg|bmp|ico)$"));
		// 「.+」はなにか文字があってもなくてもtrueで、\\.はエスケープ処理をした.です。|で拡張子をそれぞれ区切ったものを()で括ることで、この中の拡張子のファイル名であればtrueを返します。
		System.out.println("--------------------");
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(matcher_sample1);
		System.out.println("正規表現1のパターンが含まれているか："+m.find());//今までと違い、部分的にでもパターンが一致していればtrueを返します。（今回は数字「5」が含まれているのでtrue）
		System.out.println("--------------------");
		p = Pattern.compile("[^\\.]+\\.");  //     "(.+?)\\."でも可能です。
		//[]の中に^を入れると、次の文字が含まれないものがtrueになります。この場合、\\.なので、.以外の任意の文字がtrueになり、+でその文字が1文字以上の場合を指定しています。最後に\\.で.を指定することで、
		//.以外の任意の文字1文字以上と.の組み合わせ、という意味になります。.+にしてしまうと、.も含まれるため、「xxxxxx@ms.im.dendai.ac.」もtrueになってしまいます。
		//?は直前の文字が0個か1個のときにtrueを返します。
		m = p.matcher(matcher_sample2);
		System.out.println("正規表現2のパターンが含まれているものの抽出：");
		while(m.find()) {
			System.out.println(m.group());//このようにすると、正規表現のパターンが一致した部分だけを抽出してくれます。
		}

	}

}