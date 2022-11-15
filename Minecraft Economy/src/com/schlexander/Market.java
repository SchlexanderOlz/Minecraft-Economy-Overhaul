package com.schlexander;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.json.simple.ItemList;

import java.lang.reflect.Field;


public class Market {

    public static Inventory free_market = Bukkit.createInventory(null, 45, "Free Market");


    public static void LoadOverview() {
        free_market.clear();
        for (int i = 0; i < AllItems.ITEMCATEGORIES.length; i++) {

            ItemStack itemStack = new ItemStack((Material) AllItems.ITEMCATEGORIES[i][0][1], 1);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName((String) AllItems.ITEMCATEGORIES[i][0][0]);
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(itemMeta);
            free_market.setItem(i, itemStack);
        }
    }

    public static void LoadItems(Integer index) {
        free_market.clear();
        for (int i = 0; i < AllItems.ITEMCATEGORIES[index][1].length; i++) {

            ItemStack itemStack = new ItemStack((Material) AllItems.ITEMCATEGORIES[index][1][i], 1);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(itemMeta);
            free_market.setItem(i, itemStack);
        }
        CreateBack("Go Back to categories");
    }

    public static void CreateBack(String name) {
        ItemStack backblock = new ItemStack(Material.BARRIER, 1);
        ItemMeta backmeta = backblock.getItemMeta();
        backmeta.setDisplayName(name);
        backblock.setItemMeta(backmeta);
        free_market.setItem(44, backblock);
    }

    public static void Sell(Player player, ItemStack itemStack, Integer amount) {
        player.getInventory().removeItem(new ItemStack(itemStack.getType(), amount));
    }
    public static void Buy (Player player, ItemStack itemStack, Integer amount) {
        player.getInventory().addItem(new ItemStack(itemStack.getType(), amount));

    }



}
