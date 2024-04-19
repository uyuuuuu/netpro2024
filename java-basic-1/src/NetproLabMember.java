import java.util.Random;

public class NetproLabMember {
    public static void main(String[] args){
        //15年間岩井研に女性の学生が来ない確率をもとめよ。
        // 1年目から15年目を年数を行
        // 学生総数、女子の割合、配属人数がカラムとなるint型の2次元配列
        // 学生総数は定員110対して+-10人でランダム
        // 女子学生の割合は20%から毎年1%上昇するものとする。
        // 配属人数は毎年定員10人に対して+-3人のランダム
        int[] col = new int[3]; //その年の学生数,女子生徒割合,配属人数
        int[][] iwai = new int[15][]; //1~15年分
        double ans_p = 1;
        for(int i=0;i<15;i++){
            Random rd = new Random();
            col[0] = 110 + (rd.nextInt(21)-10); // 0~20の乱数-10 → -10~10
            col[1] = 20 + i;
            col[2] = 10 + (rd.nextInt(7)-3); // 0~6の乱数-3 → -3~3
            iwai[i] = col;

            int girl = Math.round(col[0] * (20+i)/100F);
            int boy = col[0] - girl;
            System.out.println(girl+":"+boy);
            long all = comb(col[0],col[2]);//col[0]からcol[2]人選ぶ;
            System.out.println(all);
            long onlyBoy = comb(boy,col[2]);//boyからcol[2]人選ぶ;
            System.out.println(onlyBoy);
            ans_p *= onlyBoy/all;
        }
    }
    public static long comb(int n, int r){
        if(n<0||r<0) {System.out.println("0以上の引数を与えること"); return 0;}
        else if(n==r) return 1;
        else if (r==0) return 1;
        else if(n==0) return 0;
        else return kaijo(n)/kaijo(r)*kaijo(n-r);
    }
    public static long kaijo(int n){
        long ans = 1;
        for(int i=1;i<=n;i++) ans*=i;
        return ans;
    }
}
