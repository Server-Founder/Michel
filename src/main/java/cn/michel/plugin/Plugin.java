package cn.michel.plugin;



import cn.michel.Server;
import cn.michel.utils.config.Config;
import cn.michel.utils.log.PluginLogger;

import java.io.File;
import java.io.InputStream;


public interface Plugin  {

    void onLoad();


    void onEnable();


    boolean isEnabled();


    void onDisable();


    boolean isDisabled();


    File getDataFolder();

    PluginDescription getDescription();

    InputStream getResource(String filename);

    boolean saveResource(String filename);

    boolean saveResource(String filename, boolean replace);

    boolean saveResource(String filename, String outputName, boolean replace);


    Config getConfig();


    void saveConfig();


    void saveDefaultConfig();


    void reloadConfig();


    Server getServer();

    String getName();


    PluginLogger getLogger();

    PluginLoader getPluginLoader();

}
