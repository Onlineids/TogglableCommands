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
		getConfig().set("economyEnabled", true);
		getConfig().set("signsEnabled", true);
		getConfig().set("feedCommands.enabled", true);
		getConfig().set("feedCommands.feedAll", "&3All players have been fed!");
		getConfig().set("feedCommands.feedSelf", "&3You have been fed!");
		getConfig().set("feedCommands.coolDownEnabled", true);
		getConfig().set("feedCommands.coolDownLength", 60);
		getConfig().set("healCommands.enabled", true);
		getConfig().set("healCommands.healAll", "&3All players have been healed!");
		getConfig().set("healCommands.healSelf", "&3You have been healed!");
		getConfig().set("healCommands.coolDownEnabled", true);
		getConfig().set("healCommands.coolDownLength", 60);
		getConfig().set("vanishCommand.enabled", true);
		getConfig().set("vanishCommand.vanishedOn", "&3You are now vanished!");
		getConfig().set("vanishCommand.vanishedOff", "&3You are now no longer vanished!");
		getConfig().set("messageCommands.enabled", true);
		getConfig().set("messageCommands.recieverFormat", "&3[%s &3-> &cme&3] &r%m");
		getConfig().set("messageCommands.senderFormat", "&3[&cme &3-> %s&3] &r%m");
		getConfig().set("messageCommands.noonetoReply", "&cYou have noone to reply to!");
		getConfig().set("economyCommands.pay", "&3You paid &6%p &a%a$");
		getConfig().set("economyCommands.recieveMoney", "&3You recieved &a%a$ from &6%p");
		getConfig().set("economyCommands.balance", "&3Your balance: &a%a$");
		getConfig().set("signs.sellAll.enabled", true);
		getConfig().set("signs.sellAll.firstLine", "&3[&cSell-All&3]");
		getConfig().set("signs.sell.enabled", true);
		getConfig().set("signs.sell.firstLine", "&3[&cSell&3]");
		getConfig().set("signs.buy.enabled", true);
		getConfig().set("signs.buy.firstLine", "&3[&cBuy&3]");

	}
}