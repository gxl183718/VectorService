package iie.tool;

import org.jetbrains.annotations.TestOnly;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class TimeOutUtil {

        public static ExecutorService executor = Executors.newFixedThreadPool(10);

    /**
     *
     * @param task  继承了Callable的对象
     * @param timeout   超时时间
     * @param <T>
     * @return
     */
        public static <T> T process(Callable<T> task, long timeout) {
            long time0 = System.currentTimeMillis();
            if (task == null) {
                return null;
            }
            Future<T> futureRet = executor.submit(task);
            try {
                T ret = futureRet.get(timeout, TimeUnit.SECONDS);
                return ret;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
//                if (futureRet != null && futureRet.isCancelled()) {
                    futureRet.cancel(true);
//                }
            }
            System.out.println("解析超时，超时时间 " + timeout + " s.");
            return null;
        }


        public static <T> CompletableFuture<T> asyncProcess(Callable<T> task, long timeout) {
            if (task == null) {
                return null;
            }
            CompletableFuture<T> future = CompletableFuture.supplyAsync(new Supplier<T>() {
                @Override
                public T get() {
                    return process(task, timeout);
                }
            }, executor);
            return future;
        }
        @TestOnly
        public void test(){

        }


}
