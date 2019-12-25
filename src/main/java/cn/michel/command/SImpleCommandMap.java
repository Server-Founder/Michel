package cn.michel.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SImpleCommandMap implements CommandMap {

    private Map<String,Command> commands = new HashMap<>();

    private Map<String,String> prefix_commands = new HashMap<>();

    private Map<String, List<String>> commands_alias = new HashMap<>();
    @Override
    public int register(String prefix, Command command) {
        commands.put(prefix,command);
        return 0;
    }

}
