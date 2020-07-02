package iie.test;

import iie.grpc.QueryByUrlEntry;
import iie.grpc.ResultEntryHash;
import iie.grpc.UrlRequest;
import iie.grpc.VectorGrpc;
import iie.grpctool.GrpcClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;

import java.util.concurrent.TimeUnit;

public class MainTest {
    static int a = 1;
    public static void main(String[] args) throws InterruptedException {
        QueryByUrlEntry queryByUrlEntry = QueryByUrlEntry.newBuilder()
                .setStartTime(0)
                .setEndTime(15055555555l)
                .build();
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899)
                .usePlaintext().build();
        VectorGrpc.VectorBlockingStub blockingStub = VectorGrpc.newBlockingStub(managedChannel);
        while(true){

            Thread.sleep(10);
            new Thread(()->{
                ResultEntryHash resultEntryHash = blockingStub
                        .getVectorByUrl(queryByUrlEntry);
            }).start();
            new Thread(()->{
                ResultEntryHash resultEntryHash = blockingStub
                        .getVectorByUrl(queryByUrlEntry);
            }).start();
}

    }
}
