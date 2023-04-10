package multithread;

/**
 * @author zhangrucheng on 2023/4/10
 */

class Person {
    String name = "rucheng";
}
public class ThreadLocalTest {

    private static final ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(100);
                tl.set(new Person());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(300);
                Person person = tl.get();
                System.out.println(person);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }


}
