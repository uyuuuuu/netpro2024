package reflection;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String value();
}

@MyAnnotation("Hello Annotation")
public class ReflectionExample5 {
    public static void main(String[] args) throws Exception {
        // クラス名からClassオブジェクトを取得
        Class<?> clazz = ReflectionExample5.class;

        // クラスに付与されたアノテーションを取得
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("Annotation Value: " + myAnnotation.value()); // "Hello Annotation" を表示
            }
        }
    }
}
