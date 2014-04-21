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
		getConfig().createSection("feedCommands");
		getConfig().createSection("healCommands");
		getConfig().createSection("teleportCommands");
		getConfig().createSection("vanishCommand");
		getConfig().createSection("messageCommands");
		saveConfig();
		plugin = this;
		}
	
	 
	public void onDisable() {
	plugin = null;
	 
	}
	public void addDefaults(){
		getConfig().set("feedCommands.enabled", true);
		getConfig().set("feedCommands.feedAll", "&3All players have been fed!");
		getConfig().set("feedCommands.feedSelf", "&3You have been fed!");
		getConfig().set("feedCommands.coolDownEnabled", true);
		getConfig().set("feedCommands.coolDownLength", 60);
	}
}