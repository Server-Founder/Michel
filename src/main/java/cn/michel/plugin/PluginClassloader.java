package cn.michel.plugin;

import cn.michel.exceptions.MainClassFormatException;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class PluginClassloader extends URLClassLoader {

    private static final String MICHEL = "cn.michel";

    private static final String MINECRAFT = "net.minecraft";

    private final Map<String, Class> classes = new HashMap<>();

    private JavaPluginLoader pluginClassloader;

    public PluginClassloader(File file,JavaPluginLoader pluginClassloader) throws MalformedURLException {
        super(new URL[]{file.toURI().toURL()}, PluginClassloader.class.getClassLoader());
        this.pluginClassloader = pluginClassloader;
    }



    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.startsWith(MICHEL)||name.startsWith(MINECRAFT)){
            throw new MainClassFormatException("illegal package name: "+MICHEL+"/"+MINECRAFT);
        }
        if(classes.containsKey(name)){
            return classes.get(name);
        }
        Class<?> loaded = super.loadClass(name);
        classes.put(name,loaded);
        return loaded;
    }
}
