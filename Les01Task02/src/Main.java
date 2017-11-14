import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        TextContainer textContainer = new TextContainer();
        Class<?> cls = textContainer.getClass();

        if (!cls.isAnnotationPresent(SaveTo.class)){
            System.out.println("Error");
            return;
        }

        SaveTo saveTo = cls.getAnnotation(SaveTo.class);
        String path = saveTo.path();
        Method[] methods = cls.getDeclaredMethods();

        for (Method m:methods
             ) {
            if (m.isAnnotationPresent(Saver.class)){
                try {
                    m.invoke(textContainer, path, "здесь может быть ваш текст");
                    break;
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }

    }
}
