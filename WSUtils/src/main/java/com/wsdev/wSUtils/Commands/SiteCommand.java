package com.wsdev.wSUtils.Commands;

import com.wsdev.wSUtils.WSUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SiteCommand implements CommandExecutor
{
    @Override
    public boolean onCommand( @NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args )
    {
        var exigirPermissao = WSUtils.getPluginConfig().getBoolean( "Site.Exigir-Permissao" );
        var mensagem = WSUtils.getPluginConfig().getString( "Site.Mensagem" );

        if( sender instanceof Player player )
        {
            if ( exigirPermissao && !player.hasPermission( "wsutil.site" ) )
            {
                player.sendMessage( "§e§l[Info]: §7Voce não tem permissão para executar esse comando." );
                return true;
            }
        }

        sender.sendMessage( ChatColor.translateAlternateColorCodes( '&', mensagem ) );

        return true;
    }
}
