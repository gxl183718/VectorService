package iie.server;

import iie.configs.Config;
import iie.grpctool.VectorClient;
import mammoth.jclient.ClientAPI;
import zzq.dolls.config.LoadConfig;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainServer {
    public static void main(String[] args) {
        try {
            LoadConfig.load(Config.class);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        LoadConfig.load(Config.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, 10 * 1000, 10 * 1000);
            ClientAPI clientAPI = new ClientAPI();
            try {
                clientAPI.init(Config.mamUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //1.启动yolo http server
            YoloHttpServer yoloHttpServer = new YoloHttpServer(clientAPI);
            yoloHttpServer.startHttpServer();
//            yoloHttpServer.updateConfig();
            //2.启动监控vector engine变化的线程
            VectorClient vectorClient = new VectorClient();
            vectorClient.init();
            //3.启动接收查询请求服务
            VectorSearchServer server = new VectorSearchServer(vectorClient, Config.grpcPort);
            try {
                server.start();
                server.blockUntilShutdown();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
