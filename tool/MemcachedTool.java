package iie.tool;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;

public class MemcachedTool {

    private  static  MemcachedClient mc = null;


    synchronized public static void init(String host, int port) throws IOException {
        mc = new MemcachedClient(new InetSocketAddress(host, port));
    }

    public static MemcachedClient getClient (){
        return mc;
    }

    public static void shutDown(){
        if (null != mc)
            mc.shutdown();
    }


    public static boolean set(String key, byte[] value){
        try {
            return mc.set(key, 0, value).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static byte[] get(String key){
        return (byte[])mc.get(key);
    }
    public static boolean delete(String key){
        try {
            return mc.delete(key).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        MemcachedClient mc = new MemcachedClient(new InetSocketAddress("192.168.99.100", 11211));
        OperationFuture<Boolean> op = mc.set("key2", 0, "222");
//        System.out.println(mc.set("key1", 0, "value1".getBytes()).isDone());

        System.out.println(op.isDone() +",,"+ op.get());
        System.out.println("key2" + mc.get("key2"));
//        OperationFuture<Boolean> operationFuture = mc.delete("key1");
//        System.out.println("operate result : " + operationFuture.get());
//        System.out.println("operate is down : " + operationFuture.isDone() + ", " + operationFuture.getKey()
//        + ", " + operationFuture.cancel()+ ", " + operationFuture.isCancelled() );
        mc.shutdown();
    }
}
