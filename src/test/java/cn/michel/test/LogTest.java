package cn.michel.test;


import cn.michel.utils.log.ServerLogger;

import java.io.File;

public class LogTest {


    public static void main(String[] args) {
        ServerLogger logger = new ServerLogger(new File("/Users/luchangcun/IdeaProjects/logfile"));
        logger.info("hello,world",new NullPointerException());
    }

}
