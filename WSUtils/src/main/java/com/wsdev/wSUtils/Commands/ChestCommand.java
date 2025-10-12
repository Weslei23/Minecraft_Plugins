package com.wsdev.wSUtils.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class ChestCommand implements CommandExecutor
{
    @Override
    public boolean onCommand( @NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args )
    {
        if ( !( sender instanceof Player ) )
        {
            sender.sendMessage( "Somente players podem utilizar este comando!" );
            return true;
        }

        Player player = ( Player ) sender;

        Inventory bau = Bukkit.createInventory( null, 27 , "Bau" );

        player.openInventory( bau );
        return true;
    }
}
