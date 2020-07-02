package iie.test;

import iie.grpc.BytesResponse;
import iie.grpctool.GrpcClient;

public class FaceTest {
    public static void main(String[] args) {
        String url = args[0];
        String po = args[1];
        String[] pos = po.split(",");
        int x1 = Integer.parseInt(pos[0]);
        int y1 = Integer.parseInt(pos[1]);
        int x2 = Integer.parseInt(pos[2]);
        int y2 = Integer.parseInt(pos[3]);
        int x3 = Integer.parseInt(pos[4]);
        int y3 = Integer.parseInt(pos[5]);
        int x4 = Integer.parseInt(pos[6]);
        int y4 = Integer.parseInt(pos[7]);
        GrpcClient grpcClient = new GrpcClient("10.136.144.86:8080");
        BytesResponse br = grpcClient.searchByUrl(url,
                x1, y1, x2, y2, x3, y3, x4, y4);
        System.out.println("code = " + br.getCode());
        System.out.println("vector size = " + br.getVectorBytes().size());
    }
}
