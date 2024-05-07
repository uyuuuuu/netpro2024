import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PrimeCheck {
// 3以上の100000までの素数全体を下一桁を項目として素数グループの分類せよ。
// さらに連続する素数の下一桁の出現回数のランキング付けも挑戦せよ。
// たとえば11-13なら1->3ペア の個数が+1増える。
// ペアは以下がすべてになる。5は考えない。
// 1-1, 1-3, 1-7, 1-9, 3-1,  3-3,  3-7,  3-9,
// 7-1,  7-3,  7-7,  7-9, 9-1, 9-3, 9-7, 9-9

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> array = new ArrayList<Integer>();
        boolean isPrime = true;
        array.add(2);
        for(int i=3;i<=100000;i++){
            for(int p:array){
                if(i%p==0) {isPrime = false; break;}
            }
            if(isPrime) array.add(i);
            isPrime = true;
        }
        array.remove(0); //0番目の2を削除

        System.out.println("1.下一桁を項目とした素数グループの分類");
        
        for(int i=0;i<10;i++){
            String left = "下一桁が"+i+"の素数:";
            String right = "";
            for(int p:array){
                if(p%10==i && right.equals("")) right = right+p;
                else if(p%10==i) right = right+","+p;
            }
            System.out.println(left+right);
        }
        
        Map<String, Integer> primeMap = new HashMap<String, Integer>();
        for(int j=0;j<array.size()-1;j++){
            String set = array.get(j)%10 +"-"+ array.get(j+1)%10;
            if(primeMap.get(set)!=null){
                int count = primeMap.get(set);
                primeMap.put(set,count+1);
            }else{
                primeMap.put(set,1);
            }
        }
        
        System.out.println("2.連続する素数の下一桁の出現回数を大きい順に表示");
        ArrayList<Entry<String, Integer>> sortList = new ArrayList<>(primeMap.entrySet());
        sortList.sort(Collections.reverseOrder(Entry.comparingByValue()));
        for (Map.Entry<String, Integer> e : sortList) {
            System.out.println(e.getKey() + ":" + e.getValue()+"回");
        }
    }
}
