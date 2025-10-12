package com.wsdev.wSUtils;

import com.wsdev.wSUtils.Commands.ChestCommand;
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
        registerCommands();

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

    public void registerCommands()
    {
        if( getCommand( "fly" ) != null ) getCommand( "fly" ).setExecutor( new FlyCommand() );
        if( getCommand( "gm" ) != null ) getCommand( "gm" ).setExecutor( new GmCommand() );
        if( getCommand( "site" ) != null ) getCommand( "site" ).setExecutor( new SiteCommand() );
        if( getCommand( "bau" ) != null ) getCommand( "bau" ).setExecutor( new ChestCommand() );
    }
}
