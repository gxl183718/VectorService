package iie.server;

import com.google.protobuf.ByteString;
import iie.grpc.*;
import iie.grpc.VectorGrpc.VectorImplBase;
import iie.grpctool.VectorClient;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class VectorSearchServer {
    private static VectorClient vectorClient;
    private int port;
    private Server server;

    public VectorSearchServer(VectorClient vectorClient, int port) {
        this.vectorClient = vectorClient;
        this.port = port;
    }

    protected void start() throws IOException {
        /* The port on which the server should run */
        server = ServerBuilder.forPort(port)
                .addService(new VectorImpl())
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    VectorSearchServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    protected void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */


    static class VectorImpl extends VectorImplBase {
        @Override
        public void getVectorByBytes(QueryByBytesEntry request, StreamObserver<ResultEntryHash> responseObserver) {
//            super.getVectorByBytes(request, responseObserver);
            BytesRequest br = request.getImage();
            ResultEntryHash reh = vectorClient.getVectors(request.getSpace(), request.getStartTime(), request.getEndTime(),
                    br.getImageBytes(), br.getX1(), br.getY1(), br.getX2(), br.getY2(), br.getX3(), br.getY3(), br.getX4(), br.getY4());
            responseObserver.onNext(reh);
            responseObserver.onCompleted();
        }

        @Override
        public void getVectorByUrl(QueryByUrlEntry request, StreamObserver<ResultEntryHash> responseObserver) {
//            super.getVectorByUrl(request, responseObserver);
            System.out.println(getTime() + " grpc 请求: space='" + request.getSpace() +"',startTime=" +
                    request.getStartTime() +",endTime=" +
                    request.getEndTime() +",url=" +
                    request.getImage().getImageUrl() + " position is '" +
                    request.getImage().getX1() + ", " +
                    request.getImage().getY1() + ", " +
                    request.getImage().getX2() + ", " +
                    request.getImage().getY2() + ", " +
                    request.getImage().getX3() + ", " +
                    request.getImage().getY3() + ", " +
                    request.getImage().getX4() + ", " +
                    request.getImage().getY4() + "."
                    );
            long start = System.currentTimeMillis();
            if (request.getSpace().equals("wbyy")){
                long time1 = System.currentTimeMillis();
                byte[] vector = null;
                int i = 0;
                boolean error;
                do {
                    try {
                        vector = TextEngine.getTextVector(request.getImage().getImageUrl());
                        error = false;
                    } catch (IOException e) {
                        error = true;
                        i ++;
                        System.out.println("请求wbyy服务异常：" + e.getMessage() + " , 重试 " + i + " times.");
                    }
                }while (i < 3 && error);

                System.out.println(getTime() + " 文本语义耗时：" + (System.currentTimeMillis() - time1) + "ms.");
                ResultEntryHash reh = ResultEntryHash.newBuilder().addResultEntries(
                        ResultEntry.newBuilder()
                                .setStartTime(request.getStartTime())
                                .setEndTime(request.getEndTime())
                                .setSpace("wbyy")
                                .setVersion("verter_v4")
                                .setVector(vector == null ? ByteString.EMPTY : ByteString.copyFrom(vector))
                                .build())
                        .build();
                responseObserver.onNext(reh);
                responseObserver.onCompleted();
            }else {
                UrlRequest ur = request.getImage();
                ResultEntryHash reh = vectorClient.getVectors(request.getSpace(), request.getStartTime(), request.getEndTime(),
                        ur.getImageUrl(), ur.getX1(), ur.getY1(), ur.getX2(), ur.getY2(), ur.getX3(), ur.getY3(), ur.getX4(), ur.getY4());
                if (reh.getResultEntriesList().size() != 0)
                    System.out.println(getTime() + " grpc 查询耗时 :" + (System.currentTimeMillis() - start) + " ms, vector size = " + reh.getResultEntriesList().size());
                else {
                    System.out.println(getTime() + " grpc 查询耗时 :" + (System.currentTimeMillis() - start) + " ms, no engine");
                }
                responseObserver.onNext(reh);
                responseObserver.onCompleted();
            }
        }
    }
    private static String getTime(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()) + " ----> ";
    }
}
