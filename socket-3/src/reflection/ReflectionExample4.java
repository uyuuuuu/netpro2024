package reflection;
import java.lang.reflect.Constructor;

public class ReflectionExample4 {
    public static void main(String[] args) throws Exception {
        // クラス名からClassオブジェクトを取得
        Class<?> clazz = String.class;

        // コンストラクタを取得して呼び出し
        Constructor<?> constructor = clazz.getConstructor(String.class);
        Object instance = constructor.newInstance("Hello");

        System.out.println(instance); // "Hello" を表示
    }
}
