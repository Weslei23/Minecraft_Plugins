package com.wsdev.wSkits.Managers;

import com.wsdev.wSkits.WSkits;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class KitManager
{

    private final WSkits plugin;
    private final File file;
    private FileConfiguration config;

    public KitManager( WSkits plugin )
    {
        this.plugin = plugin;
        this.file = new File( plugin.getDataFolder(), "kits.yml" );
    }

    public void loadKits()
    {
        if( !file.exists() )
        {
            try
            {
                file.createNewFile();
            }
            catch( IOException e )
            {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration( file );
    }

    public void saveKits()
    {
        try
        {
            config.save( file );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

    public void saveKit( String name, ItemStack[] contents )
    {
        config.set( "kits." + name, contents );
        saveKits();
    }

    public ItemStack[] getKit( String name )
    {
        List<ItemStack> items = ( List<ItemStack> ) config.getList( "kits." + name );

        if ( items == null ) return null;

        return items.toArray( new ItemStack[0] );
    }

    public Set<String> getAllKits()
    {
        if ( config.getConfigurationSection( "kits" ) == null ) return new HashSet<>();

        return config.getConfigurationSection( "kits" ).getKeys( false );
    }
}