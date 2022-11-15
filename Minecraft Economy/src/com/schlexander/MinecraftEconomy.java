package com.schlexander;

import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftEconomy extends JavaPlugin {


    @Override
    public void onEnable() {
        String[][] Goods = {{}};

        Display.changePrice();
        new Events(this);
        getCommand("market").setExecutor(new OpenMarketCommand());
    }

    @Override
    public void onDisable() {
        System.out.println("Shutting down...");
    }

}
