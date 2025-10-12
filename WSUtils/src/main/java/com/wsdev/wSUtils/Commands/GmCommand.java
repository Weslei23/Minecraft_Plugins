package com.wsdev.wSUtils.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GmCommand implements CommandExecutor
{
    @Override
    public boolean onCommand( @NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args )
    {
        if( sender instanceof Player player )
        {
            if( !player.hasPermission( "wsutil.gmcreative" ) )
            {
                player.sendMessage( "§e§l[Info]: §7Voce não possui permissão para executar esse comando." );
            }

            if ( command.getName().equalsIgnoreCase( "creative" ) )
                if( player.getGameMode() != GameMode.CREATIVE )
                {
                    player.setGameMode( GameMode.CREATIVE );
                    player.sendMessage( "§e§l[Info]: §7Voce entrou no modo §acriativo" );
                }
        }
        return false;
    }
}
