package Commands;

import Config.LoadConfig;
import com.pepper.clearlyannouncer.Main;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class randomannouncer implements CommandExecutor {

    public randomannouncer(Main main) {
    }

    //設定定時公告
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String lable, @NotNull String[] args) {

        // 檢查是否為指令、參數是否正確
        if (!(command.getName().equalsIgnoreCase("randomannouncer"))) {
            return false;
        }
        if (args.length != 1) {
            sender.sendMessage("[ClearlyAnnouncer]參數數量不正確！請檢查是否有遺漏或是多餘的參數。");
            return true;
        }

        // 讀取資料
        YamlConfiguration randomannouncement = YamlConfiguration.loadConfiguration(new File("announcement.yml"));
        Server server = sender.getServer();
        ConsoleCommandSender console = server.getConsoleSender();

        //輸入
        switch (args[0]) {
            case "test1":
                console.sendMessage(String.valueOf(randomannouncement.getList("Test") != null));
                return true;
            default:
                sender.sendMessage("[ClearlyAnnouncer]您沒有輸入正確的參數！請檢查是否有打錯字或是大小寫不同。");
                return true;
        }
    }
}
