package cn.michel.plugin;

import java.io.File;
import java.util.List;

public interface PluginLoader {

    List<Permission> loadPermission(File parentDir);

    List<Plugin> loadPlugins(File parentDir);

    List<Plugin> loadPlugin(File file);
}
