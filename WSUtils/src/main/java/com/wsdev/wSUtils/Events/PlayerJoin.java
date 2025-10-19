package com.wsdev.wSUtils.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerJoin implements Listener
{
    @EventHandler
    public void onJoin( PlayerJoinEvent event)
    {
       Player player = event.getPlayer();

       ItemStack i = new ItemStack( Material.DIAMOND_AXE );
       player.getInventory().setItem( 1, i );

    }
}
