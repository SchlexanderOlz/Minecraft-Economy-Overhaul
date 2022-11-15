package com.schlexander;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class Display {

    public static void changePrice() {
        List<String> lorelist = new ArrayList<>();
        lorelist.add("Hallo");

        ItemStack itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemStackMeta = itemStack.getItemMeta();
        itemStackMeta.setLore(lorelist);
        itemStack.setItemMeta(itemStackMeta);
    }
}
