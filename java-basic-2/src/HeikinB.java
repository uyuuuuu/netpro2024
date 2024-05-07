import java.util.Random;

public class HeikinB {
	public static final int N=100;
	Kamoku[] kamoku = new Kamoku[N];
	static String kamokuname="数学";

	public static void main(String[] args) {
		HeikinB heikinb= new HeikinB(kamokuname);
		heikinb.initalizeScores();
		heikinb.printAverage();
		heikinb.gokakusha();

	}
	
	HeikinB(String s){
		this.kamokuname=s;
		
	}
	void initalizeScores(){
		Random r = new Random();

		for(int i=0;i<N;i++){
			int score = r.nextInt(N+1);
			kamoku[i]= new Kamoku(score);

		}
	
	}
	
	void printAverage(){
		int sum=0;
		for(int i=0;i<N;i++){
			sum+=kamoku[i].getScore();

		}
		System.out.println("平均点は"+sum/N);

	}

	void gokakusha(){

	}//student idと点数をソートしてだせ。＞＝８０以上

}