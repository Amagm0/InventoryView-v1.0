package com.github.amagm0.inventoryview;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.amagm0.inventoryview.commands.OpenEnder;
import com.github.amagm0.inventoryview.commands.OpenInventory;

public final class InventoryView extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Enabled InventoryView v1.0");
        Bukkit.getPluginCommand("openender").setExecutor(new OpenEnder());
        Bukkit.getPluginCommand("openinventory").setExecutor(new OpenInventory());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Disabled InventoryView v1.0");
    }
}
