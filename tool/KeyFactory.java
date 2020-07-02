package iie.tool;

import java.util.Random;

public class KeyFactory {
    static Random random = new Random();

    public enum KeyType{
        ImageZB("中标图片"),ImageYB("样本图片"),ImagePYQ("朋友圈图片"),ImageJMXF("界面下发图片"),ImageJMFW("界面服务图片"),ImageSJCY("随机采样图片"),
        VideoZB("中标视频"),VideoYB("样本视频"),VideoPYQ("朋友圈视频"),VideoJMXF("界面下发视频"),VideoJMFW("界面服务视频"),VideoSJCY("随机采样视频"),
        AudioZB("中标音频"),AudioYB("样本音频"),AudioPYQ("朋友圈音频"),AudioJMXF("界面下发音频"),AudioJMFW("界面服务音频"),AudioSJCY("随机采样音频"),
        OtherZB("中标文件"),OtherYB("样本文件"),OtherPYQ("朋友圈文件"),OtherJMXF("界面下发文件"),OtherJMFW("界面服务文件"),OtherSJCY("随机采样文件"),
        ZG("王志国wx专用"),WL("王志国wb专用"),
        ImageJGH("广恒图片"),VideoJGH("广恒视频"),
        ImageWB("微博图片"),AudioWB("微博语音"),VideoWB("微博视频"),OtherWB("微博文件"),
        ImageFS("faiss搜索入库");
        String dbName;
        KeyType(String dbName) {
        }

        public String getDbName() {
            return dbName;
        }
    }

    public static String getType(KeyType keyType){
        String type;
        switch (keyType){
            case ImageFS:
                type = "is";
                break;
//            case ImageZB:
//                type = "iz";
//                break;
            case ImageWB:
                type = "iw";
                break;
//            case ImagePYQ:
//                type = "ip";
//                break;
//            case ImageJMXF:
//                type = "ix";
//                break;
//            case ImageJMFW:
//                type = "if";
//                break;
//            case ImageSJCY:
//                type = "ic";
//                break;
//            case VideoZB:
//                type = "vz";
//                break;
            case VideoWB:
                type = "vw";
                break;
//            case VideoPYQ:
//                type = "vp";
//                break;
//            case VideoJMXF:
//                type = "vx";
//                break;
//            case VideoJMFW:
//                type = "vf";
//                break;
//            case VideoSJCY:
//                type = "vc";
//                break;
//            case AudioZB:
//                type = "az";
//                break;
            case AudioWB:
                type = "zqw";
                break;
//            case AudioPYQ:
//                type = "ap";
//                break;
//            case AudioJMXF:
//                type = "ax";
//                break;
//            case AudioJMFW:
//                type = "af";
//                break;
//            case AudioSJCY:
//                type = "ac";
//                break;
//            case OtherZB:
//                type = "oz";
//                break;
            case OtherWB:
                type = "ow";
                break;
//            case OtherPYQ:
//                type = "op";
//                break;
//            case OtherJMXF:
//                type = "ox";
//                break;
//            case OtherJMFW:
//                type = "of";
//                break;
//            case OtherSJCY:
//                type = "oc";
//                break;
//            case ZG:
//                type = "zg";
//                break;
            default:
                type = "";
                break;
        }
        return type;
    }

    public static String getInstance(KeyType type, String dataId, int unitData, int unitSet){
        return getInstance(type, dataId, unitData, unitSet, System.currentTimeMillis()/1000);
    }

    /**
     *
     * @param type      数据类型
     * @param dataId    数据唯一标识
     * @param unitData  将当前时间段的数据分散到当前set和其之前的unitData-1个set中
     * @param unitSet   多媒体库set划分；每unitSet分钟对应一个set
     * @return key
     */
    public static String getInstance(KeyType type, String dataId, int unitData, int unitSet, long second){
        StringBuilder key = new StringBuilder();
        long curSet = second - (second%(unitSet*60));

        long finalSet = curSet - random.nextInt(unitData)*unitSet*60;
        String fileType = getType(type);
        key.append(fileType).append(finalSet).append("@").append(dataId);
        return key.toString();
    }

//    /**
//     * 每个小时生成一个set
//     * @param type      数据类型
//     * @param dataId    数据唯一标识
//     * @param unitData  每个小时时间段内的数据分散到当前set和之前的unitData-1个set中
//     * @return
//     */
//    public static String getInstance(KeyType type, String dataId, int unitData){
//        return getInstance(type, dataId, unitData, 60);
//    }
    public static String getInstance(KeyType type, String dataId, long second){
        return getInstance(type, dataId, 1, 60, second);
    }
    /**
     * 每小时生成一个set，每个小时内的数据入到对应的set中
     * @param type      数据类型
     * @param dataId    数据唯一标识
     * @return  key
     */
    public static String getInstance(KeyType type, String dataId){
        return getInstance(type, dataId, 1, 60);
    }

    //类型：VideoYB AudioYB ImageYB OtherYB
    public static void main(String[] args){
        KeyFactory.getInstance(KeyType.ImageYB, "唯一标识/md5", 1550485600);
    }
}
