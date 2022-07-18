package com.pepper.clearlyannouncer;

import com.pepper.clearlyannouncer.Commands.announcer;
import com.pepper.clearlyannouncer.Commands.randomannouncer;
import org.bukkit.plugin.java.JavaPlugin;
import com.pepper.clearlyannouncer.Config.LoadConfig;

import java.util.Objects;

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
        Objects.requireNonNull(getCommand("announcer")).setExecutor(new announcer(this));
        Objects.requireNonNull(getCommand("randomannouncer")).setExecutor(new randomannouncer(this));
    }
}
