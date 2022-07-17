package com.pepper.clearlyannouncer;

import Commands.announcer;
import Commands.randomannouncer;
import org.bukkit.plugin.java.JavaPlugin;
import Config.LoadConfig;

public class Main extends JavaPlugin {

    public static Main clearlyannouncer;

    @Override
    public void onEnable() {
        clearlyannouncer = this;

        setupCommands();
        LoadConfig.copyConfig();
    }

    @Override
    public void onDisable() {
    }

    public void setupCommands() {
        getCommand("announcer").setExecutor(new announcer(this));
        getCommand("randomannouncer").setExecutor(new randomannouncer(this));
    }
}
