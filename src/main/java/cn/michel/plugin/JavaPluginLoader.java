package cn.michel.plugin;

import java.io.File;
import java.util.List;

public class JavaPluginLoader implements PluginLoader {

    public List<Permission> loadPermission(File parentDir){
        return null;
    }

    @Override
    public List<Plugin> loadPlugins(File parentDir) {
        return null;
    }

    @Override
    public List<Plugin> loadPlugin(File file) {
        return null;
    }
}
