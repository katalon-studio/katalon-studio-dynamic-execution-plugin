package com.katalon.plugin.tags;

import com.katalon.platform.api.Plugin;
import com.katalon.platform.api.extension.PluginActivationListener;

public class TagPluginActivationListener implements PluginActivationListener {

    public void afterActivation(Plugin plugin) {
        System.out.println(plugin.getPluginId());
    }

    @Override
    public void beforeDeactivation(Plugin plugin) {
        System.out.println(plugin.getPluginId());
    }
}
