package reflection;
import java.lang.reflect.Method;

public class ReflectionExample2 {
    public static void main(String[] args) throws Exception {
        // クラス名からClassオブジェクトを取得
        Class<?> clazz = String.class;

        // newInstanceメソッドを使用してクラスのインスタンスを生成
        Object instance = clazz.newInstance();

        // クラスのメソッドを取得して呼び出し
        Method method = clazz.getMethod("length");
        Object result = method.invoke(instance);

        System.out.println("Result: " + result); // 結果を表示
    }
}
