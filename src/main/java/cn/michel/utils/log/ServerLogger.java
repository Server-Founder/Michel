package cn.michel.utils.log;

public class ServerLogger implements ILogger {

    public void emergency(String message) {
        
    }

    public void alert(String message) {

    }

    public void critical(String message) {

    }

    public void error(String message) {

    }

    public void warning(String message) {

    }

    public void notice(String message) {

    }

    public void info(String message) {

    }

    public void debug(String message) {

    }

    public void log(LogLevel level, String message) {

    }

    public void emergency(String message, Throwable t) {

    }

    public void alert(String message, Throwable t) {

    }

    public void critical(String message, Throwable t) {

    }

    public void error(String message, Throwable t) {

    }

    public void warning(String message, Throwable t) {

    }

    public void notice(String message, Throwable t) {

    }

    public void info(String message, Throwable t) {

    }

    public void debug(String message, Throwable t) {

    }

    public void log(LogLevel level, String message, Throwable t) {
        level.getFunc().accept(new Message(message,t),this);
    }
}
