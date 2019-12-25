package cn.michel;

import cn.michel.running.ServerCommandExecutor;
import cn.michel.utils.log.ILogger;
import cn.michel.utils.log.ServerLogger;
import cn.michel.running.ServerConsole;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server {

    public static final String LANG = "lang.txt";

    public static final int STARTING = 0;

    public static final int STARTED = 1;

    public static final int STOPPING = 2;

    public static final int STOPPED = 3;

    private static Server server;

    private File baseFile;

    private File logFile;

    private Map<String,File> serverConfigs;

    private ServerLogger logger;

    private ServerConsole console;

    private Executor serverExecutor;

    private String language;



    private ServerCommandExecutor executor;

    private int state = -1;



    Server(){
        Server.server = this;
        this.state = STARTING;
        this.baseFile = new File(Server.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getParentFile();
        this.logFile = new File(baseFile,"logs");
        this.logger = new ServerLogger(logFile,"");
        this.console = new ServerConsole(server);
        this.serverExecutor = Executors.newFixedThreadPool(10);
        this.serverConfigs = new HashMap<>();
        this.registerConfigs();
        this.executor = new ServerCommandExecutor(server);
    }

    public void registerConfigs(){
        serverConfigs.put(LANG,new File(baseFile,"lang.txt"));
    }

    public void start(){
        console.start();
        this.state = STARTED;
    }
    public void stop(){

    }

    public File getBaseFile() {
        return baseFile;
    }

    public File getLogFile() {
        return logFile;
    }

    public ServerConsole getConsole() {
        return console;
    }

    public static Server getServer() {
        return server;
    }

    public ILogger getLogger() {
        return logger;
    }

    public int getState() {
        return state;
    }

    public Map<String, File> getServerConfigs() {
        return serverConfigs;
    }

    public Executor getServerExecutor() {
        return serverExecutor;
    }



    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
