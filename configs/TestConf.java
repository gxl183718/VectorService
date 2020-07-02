package iie.configs;

import zzq.dolls.config.From;

@From(name = "configs/testConf.yml", alternateNames = "testConf.yaml")
public class TestConf {
    @From(name = "pulsarUrl")
    public static String pulsarUrl;
    @From(name = "pulsarTopic")
    public static String pulsarTopic;
    @From(name = "grpcHost")
    public static String grpcHost;
    @From(name = "grpcPort")
    public static int grpcPort;
    @From(name = "flag")
    public static int flag;
}
