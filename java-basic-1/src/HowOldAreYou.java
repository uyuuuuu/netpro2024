// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {
    public static void main(String[] args){
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        try {
            while(true){
                System.out.println("何歳ですか?");
                String line = rd.readLine();
                int nowAge = 0; // 入力した年齢
                if(line.equals("q") || line.equals("e")){
                    break; // 終了
                }else{
                    try{
                        nowAge = Integer.parseInt(line);
                        if(nowAge<0 || nowAge>=120){ // 範囲外
                            System.out.println("0歳以上120歳未満までしか入力できません。");
                            // 再入力を受け付ける
                        }else{ // 正常
                            System.out.println("あなたは" + nowAge + "歳ですね。");
                            // 年号計算
                            String nengou = ""; // [年号]n年
                            int year = 2024-nowAge;
                            if(year<=1911){ //明治
                                nengou += "明治" + String.valueOf(year-1868+1);
                            }else if(year<=1925){ //大正
                                if(year == 1912) nengou += "大正元";
                                nengou += "大正" + String.valueOf(year-1912+1);
    
                            }else if(year<=1988){ //昭和
                                if(year == 1926) nengou += "昭和元";
                                nengou += "昭和" + String.valueOf(year-1926+1);
    
                            }else if(year<=2018){ //平成
                                if(year == 1989) nengou += "平成元";
                                nengou += "平成" + String.valueOf(year-1989+1);
                            }else{ //令和
                                if(year == 2019) nengou += "令和元";
                                nengou += "令和" + String.valueOf(year-2019+1);
    
                            }
                            // 出力
                            System.out.println("あなたは2030年、" + (nowAge + (2030-2024)) + "歳ですね。");
                            System.out.println("あなたの誕生した年は"+ year+":"+nengou + "年ですね。");
                            // 再入力を受け付ける
                        }
                    }catch(NumberFormatException e){
                        System.out.println("数値を入力してください。");
                    }
                }
            }
            rd.close();
        }catch(IOException e) {
			System.out.println(e);
		}
    }
}
