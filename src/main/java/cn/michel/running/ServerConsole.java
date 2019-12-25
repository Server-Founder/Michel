package cn.michel.running;

import cn.michel.Server;
import cn.michel.utils.config.ServerResourceUtil;
import jline.console.ConsoleReader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ServerConsole {

    public static final String CHOOSE_FILE = "choose.txt";
    private ConsoleReader reader;

    private Server server;

    public ServerConsole(Server server){
        try {
            this.server = server;
            this.reader = new ConsoleReader(System.in,System.out);
        }catch (IOException e){
            server.getLogger().error(e.getMessage(),e);
        }
    }

    //这里开启console
    public void start(){
        server.getServerExecutor().execute(() -> {
            try {
                String encoding = System.getProperty("file.encoding");
                File file = server.getServerConfigs().get(Server.LANG);
                String lang;
                if(!file.exists()){
                    ServerResourceUtil.printFile(CHOOSE_FILE,server.getLogger());
                    lang = reader.readLine(">");
                    FileUtils.write(file,lang,encoding);
                }else{
                    lang = FileUtils.readLines(file,encoding).get(0);
                }

                server.setLanguage(lang);

                while (!(server.getState()==Server.STOPPED)) {
                    reader.readLine(">");
                }
            }catch (IOException e){
                server.stop();
            }
        });
    }
}
