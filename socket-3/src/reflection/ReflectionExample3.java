package reflection;
import java.lang.reflect.Field;

public class ReflectionExample3 {
    public static void main(String[] args) throws Exception {
        // クラス名からClassオブジェクトを取得
        Class<?> clazz = String.class;

        // インスタンスを生成
        Object instance = clazz.newInstance();

        // クラスのフィールドを取得して値を設定
        Field field = clazz.getDeclaredField("value");
        field.setAccessible(true); // privateフィールドにアクセスするための設定
        field.set(instance, "Hello".toCharArray()); // フィールドに値を設定

        // フィールドの値を取得して表示
        char[] value = (char[]) field.get(instance);
        System.out.println("Field Value: " + new String(value)); // "Hello" を表示
    }
}
