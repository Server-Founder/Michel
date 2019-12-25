package cn.michel.utils.config;

import cn.michel.Server;
import cn.michel.utils.log.ILogger;
import cn.michel.utils.log.LoggerUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ServerResourceUtil {

    public static List<String> readFile(String name,ILogger logger){
        List<String> list = new ArrayList<>();
        InputStream stream = Server.class.getClassLoader().getResourceAsStream(name);
        if(stream!=null){
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
                String s;
                while ((s=reader.readLine())!=null){
                    list.add(s);
                }
            }catch (IOException e){
                LoggerUtil.printException(e,logger);
            }
        }
        return list;
    }

    public static void printFile(String name, ILogger logger){
        readFile(name,logger).forEach(logger::info);
    }
}
