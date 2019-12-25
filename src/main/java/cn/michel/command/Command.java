package cn.michel.command;

//TODO 没有完成
public abstract class Command {


    private String name;

    private CommandMap map;

    private String label;

    private String[] aliases = new String[0];

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isRegistered(){
        return map != null;
    }

    public boolean allowChangesFrom(CommandMap commandMap) {
        return commandMap != null && !commandMap.equals(this.map);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String[] getAliases() {
        return aliases;
    }

    public void setAliases(String[] aliases) {
        this.aliases = aliases;
    }

    public boolean register(CommandMap commandMap) {
        if (this.allowChangesFrom(commandMap)) {
            this.map = commandMap;
            return true;
        }
        return false;
    }

    public abstract boolean execute(CommandSender sender, String commandLabel, String[] args);
}
