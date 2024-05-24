package reflection;
public class ReflectionExample1 {
    public static void main(String[] args) {
        // クラス名からClassオブジェクトを取得
        Class<?> clazz = String.class; //classではなくclazzという変数名をつける

        // クラス名やパッケージ名を取得
        System.out.println("Class Name: " + clazz.getName());
        System.out.println("Package Name: " + clazz.getPackageName());

        // クラスがインターフェースかどうかを判定
        System.out.println("Is interface? " + clazz.isInterface());

        // クラスが配列かどうかを判定
        System.out.println("Is array? " + clazz.isArray());

        // クラスがプリミティブ型かどうかを判定
        System.out.println("Is primitive? " + clazz.isPrimitive());
    }
}
