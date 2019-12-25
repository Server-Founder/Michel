package cn.michel.utils.log;


import org.fusesource.jansi.Ansi;

import java.io.File;

public class ServerLogger implements ILogger{

    private File parentDir;

    public ServerLogger(File parentDir){
        this.parentDir = parentDir;
    }

    @Override
    public void emergency(String message) {
        emergency(message,null);
    }

    @Override
    public void alert(String message) {
       alert(message,null);
    }

    @Override
    public void critical(String message) {
        critical(message,null);
    }

    @Override
    public void error(String message) {
        error(message,null);
    }

    @Override
    public void warning(String message) {
        warning(message,null);
    }

    @Override
    public void notice(String message) {
        notice(message,null);
    }

    @Override
    public void info(String message) {
        info(message,null);
    }

    @Override
    public void debug(String message) {
        debug(message,null);
    }

    @Override
    public void log(LogLevel level, String message) {
        log(level,message,null);
    }

    @Override
    public void emergency(String message, Throwable t) {
        LoggerUtil.printRedLog(message,"EMERGENCY",parentDir,this,t);
    }

    @Override
    public void alert(String message, Throwable t) {
        LoggerUtil.printRedLog(message,"ALERT",parentDir,this,t);
    }

    @Override
    public void critical(String message, Throwable t) {
        LoggerUtil.printRedLog(message,"CRITICAL",parentDir,this,t);
    }

    @Override
    public void error(String message, Throwable t) {
        LoggerUtil.printRedLog(message,"ERROR",parentDir,this,t);
    }

    @Override
    public void warning(String message, Throwable t) {
        LoggerUtil.printRedLog(message,"WARNING",parentDir,this,t);
    }

    @Override
    public void notice(String message, Throwable t) {
        LoggerUtil.printCommonLog(message,"NOTICE", Ansi.Color.YELLOW,parentDir,this,t);
    }

    @Override
    public void info(String message, Throwable t) {
        LoggerUtil.printCommonLog(message,"INFO", Ansi.Color.GREEN,parentDir,this,t);
    }

    @Override
    public void debug(String message, Throwable t) {
        LoggerUtil.printCommonLog(message,"DEBUG", Ansi.Color.YELLOW,parentDir,this,t);
    }

    @Override
    public void log(LogLevel level, String message, Throwable t) {
        level.getFunc().accept(new Message(message,t),this);
    }
}
