package me.online.TogglableCommandLibrary;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);
		getConfig().options().header("Configuration for Togglable Command Library");
		getConfig().options().copyHeader(true);
		saveConfig();
	}

}
