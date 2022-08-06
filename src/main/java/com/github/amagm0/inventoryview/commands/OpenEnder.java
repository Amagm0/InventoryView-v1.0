package com.github.amagm0.inventoryview.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class OpenEnder implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("openender")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("コンソールからは実行できません");
            } else {
                Player pl = (Player) sender;

                if(!(pl.hasPermission("inventoryview.openender"))) {
                    pl.sendMessage("このコマンドを実行する権限がありません");
                    return true;
                }

                if(args.length == 0) {
                    Inventory inv = pl.getEnderChest();
                    pl.openInventory(inv);
                    pl.sendMessage(pl.getName() + "のエンダーチェストを表示しています");
                } else if(args.length == 1) {
                    String target_p = args[0];
                    Player target = Bukkit.getPlayer(target_p);

                    if(target == null) {
                        pl.sendMessage("プレイヤー" + target.getName() + "は見つかりませんでした");
                        return true;
                    }
                    
                    Inventory inv = target.getEnderChest();
                    pl.openInventory(inv);
                    pl.sendMessage(target.getName() + "のエンダーチェストを表示しています");
                } else {
                    pl.sendMessage("引数が不正です");
                }
            }
        }
        return true;
    }
}
