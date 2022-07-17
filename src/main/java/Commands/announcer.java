package Commands;

import com.pepper.clearlyannouncer.Main;
import org.bukkit.*;
import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class announcer implements CommandExecutor {

    public announcer(Main main) {
    }

    // 使用指令公告
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String lable, @NotNull String[] args) {

        // 偵測是否為指令、參數是否正確
        if (!(command.getName().equalsIgnoreCase("announcer"))) {
            return false;
        }
        if (args.length != 1) {
            sender.sendMessage("【ClearlyAnnouncer】參數沒有輸入正確，請檢查是否有多餘或缺少的參數！");
            return true;
        }

        // 讀取資料
        Server server = sender.getServer();
        ConsoleCommandSender console = server.getConsoleSender();
        Date date = new Date(); // 產生當下的日期
        SimpleDateFormat now = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a"); // 轉換成 西元年/月/日 時:分:秒 上、下午

        // 發送訊息以及後台發送
        server.broadcastMessage("【假裝我是公告前輟】" + args[0]);
        switch (sender.getName()) {
            case "@": // 指令方塊
                console.sendMessage("[ClearlyAnnouncer] 指令方塊於 " + now.format(date) + " 發送了「" + args[0] + "」");
                return true;
            case "CONSOLE": // 控制台
                console.sendMessage("[ClearlyAnnouncer] 控制台於 " + now.format(date) + " 發送了「" + args[0] + "」");
                return true;
            default: // 玩家
                console.sendMessage("[ClearlyAnnouncer] " + sender.getName() + " 於 " + now.format(date) + " 發送了「" + args[0] + "」");
                return true;
        }
    }
}
