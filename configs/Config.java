package iie.configs;

import zzq.dolls.config.From;

import java.util.Map;

@From(name = "configs/config.yml", alternateNames = "config.yaml")
public class Config {
    @From(name = "isUseCache")
    public static boolean isUseCache = false;
    @From(name = "memcachedUrl")
    public static String memcachedUrl;

    @From(name = "redisUrl")
    public static String redisUrl;
    @From(name = "redisMasterName")
    public static String redisMasterName;
    @From(name = "redisPassWD")
    public static String redisPassWD;


    @From(name = "grpcPort")
    public static int grpcPort;

    @From(name = "staticDir")
    public static String staticDir;
    @From(name = "httpServerPort")
    public static int httpServerPort;


    @From(name = "yoloServerUrl")
    public static String yoloServerUrl;
    @From(name = "yoloServerPort")
    public static int yoloServerPort;
    @From(name = "yoloFaceServerUrl")
    public static String yoloFaceServerUrl;
    @From(name = "yoloFaceServerPort")
    public static int yoloFaceServerPort;

    @From(name = "mamUrl")
    public static String mamUrl;
    @From(name = "mamPre")
    public static String mamPre;
    @From(name = "tmpUISet")
    public static String tmpUISet;


    @From(name = "tagUrl")
    public static String tagUrl;
    @From(name = "ocrUrl")
    public static String ocrUrl;
    @From(name = "keyWordsUrl")
    public static String keyWordsUrl;
    @From(name = "engineTimeout")
    public  static int engineTimeout;

    @From(name = "faceTags")
    public static Map<String, String> faceTags;

    @From(name = "typeTags")
    public static Map<String, String> typeTags;

    @From(name = "logLevel")
    public static int logLevel;

}
