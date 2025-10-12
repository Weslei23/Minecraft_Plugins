package com.wsdev.wSkits;

import com.wsdev.wSkits.Commands.KitCommand;
import com.wsdev.wSkits.Managers.KitManager;
import org.bukkit.plugin.java.JavaPlugin;

public class WSkits extends JavaPlugin
{
    private KitManager kitManager;

    @Override
    public void onEnable()
    {
        getLogger().info( "Plugin de Kits ativado!" );
        saveDefaultConfig();

        kitManager = new KitManager( this );
        kitManager.loadKits();

        getCommand( "kit" ).setExecutor( new KitCommand( this ) );
    }

    @Override
    public void onDisable()
    {
        kitManager.saveKits();
        getLogger().info( "Plugin de Kits desativado!" );
    }

    public KitManager getKitManager()
    {
        return kitManager;
    }
}
