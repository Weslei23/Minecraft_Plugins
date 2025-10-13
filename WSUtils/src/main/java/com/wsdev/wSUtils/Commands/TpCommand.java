package com.wsdev.wSUtils.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TpCommand implements CommandExecutor
{
    @Override
    public boolean onCommand( @NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args )
    {
        if( sender instanceof Player player )
        {
            if( args.length != 1 )
            {
                sender.sendMessage( ChatColor.RED + "Usage: /tp <player>" );
                return true;
            }

            Player target = Bukkit.getPlayer( args[0] );

            if( target == null )
            {
                player.sendMessage( ChatColor.RED + "Jogador não encontrado!" );
            }

            player.teleport( target.getLocation() );
            player.sendMessage( ChatColor.GREEN + "Teleportado com sucesso" );

        }
        else
        {
            sender.sendMessage( "O comando não pode ser utilizado pelo console!" );
        }

        return false;

    }
}
