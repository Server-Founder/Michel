package cn.michel.utils.log;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.fusesource.jansi.Ansi;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LoggerUtil {

    public static void println(Object message){
        System.out.println(message);
    }

    //log文件的格式 2019-12-21-12.log
    public static void fileDatePrintln(Object message, File parentDir) throws IOException {
        String name = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE)+"-"+LocalDateTime.now().getHour();
        File file = new File(parentDir,name);
        if(!file.exists()){
            file.createNewFile();
        }
        FileUtils.write(file,message.toString(), Charsets.toCharset(System.getProperty("file.encoding")));
    }

    public static StackTraceElement getStackTraceElement(){
        StackTraceElement[] elements = new Throwable().getStackTrace();
        return elements[elements.length-1];
    }


    public static String simpleClassName(String className){
        String[] fields = className.split("\\.");
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i<fields.length-1;i++){
            String after = fields[i].substring(0,1);
            builder.append(after);
            builder.append(".");
        }
        builder.append(fields[fields.length-1]);
        return builder.toString();
    }

    public static String getStandardLogMessageForMichel(String level, String message, Ansi.Color messageColor,boolean control){
        StackTraceElement element = getStackTraceElement();
        return LogFormat.format(message,level,messageColor,LogFormat.textFormat("["+element.getLineNumber()+":"+simpleClassName(element.getClassName())+"]"+LogFormat.fg(Ansi.Color.DEFAULT), Ansi.Color.CYAN),control);
    }

    public static String getStandardLogMessageForMichel(String level, String message, Ansi.Color messageColor){
        return getStandardLogMessageForMichel(level, message, messageColor,false);
    }

    public static void printException(Throwable t,ILogger logger){
        if(t == null){
            return;
        }
        logger.error(t.toString());
        for(StackTraceElement e : t.getStackTrace()){
            logger.error("\tat "+e);
        }
        logger.error("\tFINISHED");
        printException(t.getCause(),logger);
    }

    public static void printRedLog(String message,String level,File parentDir,ILogger logger,Throwable t){
        try {
            LoggerUtil.getStandardLogMessageForMichel(level, message, Ansi.Color.RED, true);
            LoggerUtil.fileDatePrintln(message, parentDir);
            LoggerUtil.printException(t,logger);
        }catch (IOException e) {
            LoggerUtil.printException(e,logger);
        }
    }

    public static void printRedLog(String message,String level,File parentDir,ILogger logger){
        printRedLog(message, level, parentDir, logger,null);
    }

    public static void printCommonLog(String message, String level, Ansi.Color color,File parentDir,ILogger logger){
        printCommonLog(message, level, color, parentDir, logger,null);

    }

    public static void printCommonLog(String message, String level, Ansi.Color color,File parentDir,ILogger logger,Throwable t){
        try {
            LoggerUtil.getStandardLogMessageForMichel(level, message, color, false);
            LoggerUtil.fileDatePrintln(message, parentDir);
            LoggerUtil.printException(t,logger);
        }catch (IOException e) {
            LoggerUtil.printException(e,logger);
        }
    }
}
