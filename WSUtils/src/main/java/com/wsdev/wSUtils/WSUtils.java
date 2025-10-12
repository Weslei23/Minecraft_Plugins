package com.wsdev.wSUtils;

import com.wsdev.wSUtils.Commands.FlyCommand;
import com.wsdev.wSUtils.Commands.GmCommand;
import com.wsdev.wSUtils.Commands.SiteCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class WSUtils extends JavaPlugin
{
    private static FileConfiguration config;

    @Override
    public void onEnable()
    {
        getLogger().info( "Plugin ativado com sucesso!" );

        saveDefaultConfig();

        config = getConfig();

        //Chama os comandos.
        getCommand( "fly" ).setExecutor( new FlyCommand() );
        getCommand( "gm" ).setExecutor( new GmCommand() );
        getCommand( "site" ).setExecutor( new SiteCommand() );

    }

    @Override
    public void onDisable()
    {
        getLogger().info( "Plugin desativado com sucesso!" );
    }


    public static FileConfiguration getPluginConfig()
    {
        return config;
    }
}
