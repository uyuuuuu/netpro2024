public class  WhileTest {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;

        while(j < 101) {
            i += j;
            System.out.println("i = " + i );
            j++;
        }
        System.out.println("while: "+ i);
    }
}