import java.util.Scanner;

public class XmasTreeKadai {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] in;
        while(true){
            // 19,3,7,+
            System.out.println("最大の葉の半分の横幅の数,幹の幅列,幹の長さ,雪の模様を入力してください");
            in = scan.nextLine().split(",");
            if(in.length!=4){ System.out.println("入力数が間違っています。"); continue;}

            int leaf = Integer.parseInt(in[0]);
            int miki_w = Integer.parseInt(in[1]);
            int miki_h = Integer.parseInt(in[2]);
            String c = in[3];

            String left = "";
            for(int l=0;l<leaf+1;l+=2){
                left = String.join("",left,c," ");
            }
            String right = left;
            int center = left.length()-1; //中心のインデックス

            for(int i=0;i<leaf+miki_h;i++){
                if(left.length()>((leaf%2==0)?2:1)) {
                    System.out.print(left);
                    left = left.substring(1,left.length());
                }
                for(int j=0;j<2*i;j++){
                    //20  18< <=22=19~22   22
                    int id_r = miki_w/2;
                    int id_l = miki_w-miki_w/2;
                    if(i<leaf) { System.out.print("*"); }
                    else if(center-id_l < j && j <= center+id_r){ System.out.print("*"); }//19-2より上～19+1
                    else { System.out.print(" "); }
                }
                if(right.length()>((leaf%2==0)?2:1)) {
                    System.out.print(" "+right);
                    right = right.substring(0,right.length()-1);
                }
                System.out.println();
            }
        }
    }
}
