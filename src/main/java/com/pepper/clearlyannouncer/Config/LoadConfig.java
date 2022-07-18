package com.pepper.clearlyannouncer.Config;

import com.pepper.clearlyannouncer.Main;

public class LoadConfig {

    // 產生新的announcement.yml
    public static void copyConfig(){
        Main.clearlyannouncer.saveResource("announcement.yml",false);
    }

}
