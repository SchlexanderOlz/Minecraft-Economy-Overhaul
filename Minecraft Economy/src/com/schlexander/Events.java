package com.schlexander;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {

    public Events(MinecraftEconomy plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onRemoveChestItem(InventoryClickEvent event) {
        ItemStack itemStack = event.getCurrentItem();

        if (event.getClickedInventory().equals(Market.free_market)) {
            for (int i = 0; i < AllItems.ITEMCATEGORIES.length; i++) {
                if (itemStack.getItemMeta().getDisplayName().equals(AllItems.ITEMCATEGORIES[i][0][0])) {
                    Market.LoadItems(i);
                    event.setCancelled(true);
                    return;

                } else if (itemStack.getItemMeta().getDisplayName().equals("Go Back to categories")) {
                    Market.LoadOverview();
                    event.setCancelled(true);
                    return;
                }
            }
            if (event.isRightClick()){
                if (event.isShiftClick()) {
                    Market.Buy((Player) event.getWhoClicked(), itemStack, 10);
                }
                else  {
                    Market.Buy((Player) event.getWhoClicked(), itemStack, 1);
                }
            } else if (event.isLeftClick()) {
                if (event.isShiftClick()) {
                    Market.Sell((Player) event.getWhoClicked(), itemStack, 10);
                } else {
                    Market.Sell((Player) event.getWhoClicked(), itemStack, 1);
                }
            }
            event.setCancelled(true);
            } else {
                return;
        }

    }

}

