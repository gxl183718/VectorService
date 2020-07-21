package iie.tool;

import iie.configs.Config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {
    public static String getTime(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()) + " ----> ";
    }

    public static void logInfo(int level, String info){
        if (level <= Config.logLevel){
            System.out.println(getTime() + info);
        }
    }
}
