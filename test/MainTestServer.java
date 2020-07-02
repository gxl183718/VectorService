package iie.test;

import iie.configs.Config;
import iie.grpc.*;
import iie.grpctool.VectorClient;
import iie.server.VectorSearchServer;
import io.grpc.Context;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainTestServer {
    private int port = 8899;
    private Server server;


    protected void start() throws IOException {
        /* The port on which the server should run */
        server = ServerBuilder.forPort(port)
                .addService(new MainTestServer.VectorImpl())
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    MainTestServer.this.stop();
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


    static class VectorImpl extends VectorGrpc.VectorImplBase {
        @Override
        public void getVectorByBytes(QueryByBytesEntry request, StreamObserver<ResultEntryHash> responseObserver) {
//            super.getVectorByBytes(request, responseObserver);
            BytesRequest br = request.getImage();
            ResultEntryHash reh = null;
            responseObserver.onNext(reh);
            responseObserver.onCompleted();
        }

        @Override
        public void getVectorByUrl(QueryByUrlEntry request, StreamObserver<ResultEntryHash> responseObserver) {
//            super.getVectorByUrl(request, responseObserver);
            System.out.println("1111111" + Thread.currentThread().getName() + ", " + System.currentTimeMillis());
            UrlRequest ur = request.getImage();
            ResultEntryHash reh = null;
            responseObserver.onNext(reh);
            responseObserver.onCompleted();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MainTestServer mainTestServer = new MainTestServer();
        mainTestServer.start();
        mainTestServer.blockUntilShutdown();
    }
}
