package iie.test;

import iie.configs.TestConf;
import iie.grpctool.GrpcClient;
import iie.server.VectorData;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import zzq.dolls.config.LoadConfig;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ForTest {
    public static void main(String[] args) throws IOException {
        LoadConfig.load(TestConf.class);
        PulsarClient pulsarClient = PulsarClient.builder()
                .serviceUrl(TestConf.pulsarUrl)
                .ioThreads(5)
                .listenerThreads(5)
                .build();
        Producer<VectorData> producer = pulsarClient.newProducer(Schema.AVRO(VectorData.class))
                .enableBatching(true)
                .topic(TestConf.pulsarTopic)
                .create();

        GrpcClient grpcClient = new GrpcClient(TestConf.grpcHost, TestConf.grpcPort);
        VectorData vData = new VectorData();

        vData.setSpace("face");
        vData.setVersion("v1.0.1");

        LocalDateTime localDateTime =
                LocalDateTime.of(2018, 1, 1, 1, 0);
        int threadNum = 10;
        for (int j = 0; j < threadNum; j++) {
            new Thread(()->{
//                long stamp = localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
//                for (int i = TestConf.flag; i < 1000 * 1000 / threadNum; i++) {
//                    long time = i * 30 * threadNum + stamp;
//                    System.out.println(Instant.now().getEpochSecond() + " : task " + i + " start! + timestamp " + stampToTime(time));
//                    long start = Instant.now().toEpochMilli();
//                    List<ByteString> list = grpcClient.searchByBytes("".getBytes());
//                    long mid = Instant.now().toEpochMilli();
//                    byte[] vectorByte;
//                    for (ByteString value : list) {
//                        vectorByte = value.toByteArray();
//                        vData.setVector(ByteBuffer.wrap(vectorByte));
//                        vData.setPublishTime(System.currentTimeMillis());
//                        vData.setGId(UUID.randomUUID().toString().replaceAll("-", ""));
//                        producer.sendAsync(vData).thenAccept(msgId -> {
//                            System.out.printf("Message with ID %s successfully sent", msgId);
//                        });
//                    }
//                    long end = Instant.now().toEpochMilli();
//                    System.out.println(Instant.now().getEpochSecond() + " : " + Thread.currentThread().getName() +
//                            "task " + i + " end!  search time is " + (mid-start) +
//                            " ms, and send time is " + (end - mid) + " ms.");
//                }
            }).start();
        }
    }
    public static String stampToTime(long stamp){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(LocalDateTime.ofInstant(Instant.ofEpochSecond(stamp),ZoneId.systemDefault()));
    }


}
