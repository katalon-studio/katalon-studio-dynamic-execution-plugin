package com.katalon.plugin.tags;

import org.osgi.service.event.Event;

import com.katalon.platform.api.event.EventListener;
import com.katalon.platform.api.exception.ResourceException;
import com.katalon.platform.api.extension.EventListenerInitializer;
import com.katalon.platform.api.preference.PluginPreference;
import com.katalon.platform.api.service.ApplicationManager;
import com.katalon.platform.api.service.PreferenceManager;
import com.katalon.platform.api.service.ProjectManager;

/**
 * This plugin only activates filtering feature in KS.
 */
public class TagEventListenerInitializer implements EventListenerInitializer {

    @Override
    public void registerListener(EventListener eventListener) {

        eventListener.on(Event.class, e -> {
            try {
                PreferenceManager preferenceManager = ApplicationManager.getInstance().getPreferenceManager();
                ProjectManager projectManager = ApplicationManager.getInstance().getProjectManager();

                PluginPreference pluginPreference = preferenceManager.getPluginPreference(
                        projectManager.getCurrentProject().getId(), "com.katalon.katalon-studio-tags-plugin");
                pluginPreference.getBoolean("haha", true);
            } catch (ResourceException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        });
    }

}
