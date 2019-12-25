package cn.michel.command.server;


import cn.michel.Server;
import cn.michel.command.CommandSender;
import cn.michel.command.VanillaCommand;

public class StopCommand extends VanillaCommand {

    public StopCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        Server.getServer().stop();
        return true;
    }
}
