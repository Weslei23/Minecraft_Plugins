package com.wsdev.wSUtils.Commands;

import com.wsdev.wSUtils.WSUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor
{
    @Override
    public boolean onCommand( @NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args )
    {
        var exigirPermissao = WSUtils.getPluginConfig().getBoolean( "Fly.Exigir-Permissao" );

        if( sender instanceof Player player )
        {
            if( exigirPermissao && !player.hasPermission( "wsutil.fly" ) )
            {
                player.sendMessage( "§e§l[Info]: §7Voce não permissão para executar este comando." );
                return true;
            }

            if ( !player.getAllowFlight() )
            {
                player.setAllowFlight( true );
                player.setFlying( true );

                player.sendMessage( "§e§l[Info]: §7Fly ativado" );

            }
            else
            {
                player.setAllowFlight( false );
                player.setFlying( false );
                player.sendMessage( "§e§l[Info]: §7Fly desativado" );
            }
        }
        return true;
    }
}
