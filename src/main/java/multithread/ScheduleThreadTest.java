package multithread;

import org.jetbrains.annotations.NotNull;

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

    public static void main(String[] args) {
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
