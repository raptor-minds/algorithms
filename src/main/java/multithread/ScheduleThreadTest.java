package multithread;

import org.jetbrains.annotations.NotNull;
import sun.nio.ch.ThreadPool;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.concurrent.*;

/**
 * @author zhangrucheng on 2023/4/11
 */
public class ScheduleThreadTest {

    private static class MyTask extends FutureTask<String> {

        public MyTask(@NotNull Callable<String> callable) {
            super(callable);
        }

        public MyTask(@NotNull Runnable runnable, String result) {
            super(runnable, result);
        }
    }

      static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

    public void printName() {
        System.out.println("ni hao dai li");
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<?> clazz = Class.forName("multithread.ScheduleThreadTest");
        Object o = clazz.newInstance();
        Method printName = clazz.getMethod("printName", null);
        printName.invoke(o,)
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("hello fix delay task " + name);
        }, 5, 3, TimeUnit.SECONDS);
        scheduledExecutorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "hello normal task");
        });
        scheduledExecutorService.schedule(() -> {
            System.out.println(Thread.currentThread().getName() + "hello delay task");
        }, 3, TimeUnit.SECONDS);
    }
}
