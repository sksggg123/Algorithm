package etc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : algorithm
 * create date  : 2019-10-19 14:27
 */
public class Reflection {
    public static void main(String[] args) {
        Reflection reflection = new Reflection();

        try {
            reflection.run();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void run() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        /* PrivateInner Class의 생성자에 전달할 인자 */
        int arg = 10;

        /* Class.forName을 통해 Package.ClassName을 정의하여 Class를 갖고 온다. */
        Class targetClass = Class.forName("etc.PrivateInner");

        /* 생성하게 될 경우 전달할 인자의 타입을 정의한다, 인자가 복수일 수 있기에 배열로 정의 */
        Class[] targetArgs = new Class[]{int.class};

        /* 생성시 인자타입 배열을 넣어 정의 */
        Constructor constructor = targetClass.getConstructor(targetArgs);

        /* 객체화 시키는 과정 */
        PrivateInner inner = (PrivateInner) constructor.newInstance(arg);

        System.out.println(inner.getData(20));

    }
}
