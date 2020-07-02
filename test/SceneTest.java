package iie.test;

import com.google.protobuf.ByteString;
import iie.grpc.BytesResponse;
import iie.grpctool.GrpcClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SceneTest {
    public static void main(String[] args) {
        GrpcClient grpcClient = new GrpcClient(args[0]);
        Map<String, String> map = new HashMap<>();
        map.put("task1", args[1]);
        map.put("task2", args[1]);

        Map<String, List<ByteString>> map1 = grpcClient.search(map);
        map1.forEach((k, v) ->{
            System.out.println(k + " : total have " + v.size() + " vectors , vector size = " + v.get(0).size()
            + "vector");
        });

    }
}
