package com.wsdev.wSkits.Commands;

import com.wsdev.wSkits.WSkits;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitCommand implements CommandExecutor
{
    private final WSkits plugin;

    public KitCommand( WSkits plugin )
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args )
    {
        if( !( sender instanceof Player player ) )
        {
            sender.sendMessage( "§cApenas jogadores podem usar este comando!" );
            return true;
        }

        if( args.length == 0 )
        {
            player.sendMessage( "§eUse: /kit <criar|pegar|listar> [nome]" );
            return true;
        }

        switch( args[0].toLowerCase() )
        {
            case "criar":
                if( args.length < 2 )
                {
                    player.sendMessage( "§cUso: /kit criar <nome>" );
                    return true;
                }

                String kitName = args[1].toLowerCase();
                ItemStack[] items = player.getInventory().getContents();

                plugin.getKitManager().saveKit( kitName, items );
                player.sendMessage( "§aKit §e" + kitName + " §acriado com sucesso!" );

                break;

            case "pegar":

                if( args.length < 2 )
                {
                    player.sendMessage( "§cUso: /kit pegar <nome>" );
                    return true;
                }

                String name = args[1].toLowerCase();
                ItemStack[] kit = plugin.getKitManager().getKit( name );

                if ( kit == null )
                {
                    player.sendMessage( "§cEsse kit não existe!" );
                    return true;
                }

                player.getInventory().addItem( kit );
                player.sendMessage( "§aVocê recebeu o kit §e" + name + "§a!" );

                break;

            case "listar":

                var kits = plugin.getKitManager().getAllKits();

                if( kits.isEmpty() )
                {
                    player.sendMessage( "§cNenhum kit criado ainda!" );
                } else
                {
                    player.sendMessage( "§aKits disponíveis: §e" + String.join( ", ", kits ) );
                }
                break;

            default:
                player.sendMessage("§eUse: /kit <criar|pegar|listar> [nome]");
                break;
        }

        return true;
    }
}
