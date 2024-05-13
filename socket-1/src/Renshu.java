public class Renshu {

    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    //ここに続きを実装していく。
    public int sumUpToN(int x){
        int sum=0;
        for(int i=1; i<=x; i++){
            sum+=i;
        }
        return sum;
    }
    public int sumFromPtoQ(int x,int y){
        if(x>y) return -1;
        int sum=0;
        for(int i=x; i<=y; i++){
            sum+=i;
        }
        return sum;
    }
    public int sumFromArrayIndex(int[] a,int x){
        int sum=0;
        if(x>=a.length) return -1;
        for(int i=x; i<a.length; i++){
            sum+=a[i];
        }
        return sum;
    }
    public int selectMaxValue(int[] a){
        int max=a[0];
        for(int v:a){
            if(max<v) max=v;
        }
        return max;
    }
    public int selectMinValue(int[] a){
        int min=a[0];
        for(int v:a){
            if(min>v) min=v;
        }
        return min;
    }
    public int selectMaxIndex(int[] a){
        int max=0;
        for(int i=0;i<a.length;i++){
            if(a[max]<a[i]) max=i;
        }
        return max;
    }
    public int selectMinIndex(int[] a){
        int min=0;
        for(int i=0;i<a.length;i++){
            if(a[min]>a[i]) min=i;
        }
        return min;
    }
    public void swapArrayElements(int[] p,int x,int y){
        int t = p[x];
        p[x]=p[y];
        p[y]=t;
    }
    public boolean swapTwoArrays(int[] a,  int[] b){
        boolean tf=false;
        if(a.length==b.length){
            tf=true;
            for(int i=0;i<a.length;i++){
                int t=a[i];
                a[i]=b[i];
                b[i]=t;
            }
        }
        return tf;
    }
}