package cn.michel.plugin;

import cn.michel.Server;
import cn.michel.utils.config.Config;
import cn.michel.utils.log.PluginLogger;

import java.io.File;
import java.io.InputStream;

public class PluginBase implements Plugin{


    @Override
    public void onLoad() {
        
    }

    @Override
    public void onEnable() {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean isDisabled() {
        return false;
    }

    @Override
    public File getDataFolder() {
        return null;
    }

    @Override
    public PluginDescription getDescription() {
        return null;
    }

    @Override
    public InputStream getResource(String filename) {
        return null;
    }

    @Override
    public boolean saveResource(String filename) {
        return false;
    }

    @Override
    public boolean saveResource(String filename, boolean replace) {
        return false;
    }

    @Override
    public boolean saveResource(String filename, String outputName, boolean replace) {
        return false;
    }

    @Override
    public Config getConfig() {
        return null;
    }

    @Override
    public void saveConfig() {

    }

    @Override
    public void saveDefaultConfig() {

    }

    @Override
    public void reloadConfig() {

    }

    @Override
    public Server getServer() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public PluginLogger getLogger() {
        return null;
    }

    @Override
    public PluginLoader getPluginLoader() {
        return null;
    }
}
