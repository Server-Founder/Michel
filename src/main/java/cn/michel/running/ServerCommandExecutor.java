package cn.michel.running;

import cn.michel.Server;
import cn.michel.command.Command;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ServerCommandExecutor {

    private Server server;

    private Map<String, Command> serverCommands = new ConcurrentHashMap<>();

    public ServerCommandExecutor(Server server){
        this.server = server;
    }


    public void run(String command){
        String[] commands = command.split(" ");
    }
}
