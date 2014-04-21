package me.online.TogglableCommandLibrary;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	@SuppressWarnings("unused")
	private static Plugin plugin;
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);
		saveConfig();
		plugin = this;
		}
	
	 
	public void onDisable() {
	plugin = null;
	 
	}
	
	
	
	
	
	
	
	

}
