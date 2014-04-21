package me.online.Utils;

import me.online.TogglableCommandLibrary.Main;

import org.bukkit.ChatColor;

public class Exceptions{

	/*
	 * This class is used to call on exceptions in commands such as playernotFound,
	 * which is an exception when bukkit cannot find that player this class is just to make things organized and easier
	 */
	public static Main plugin;
	@SuppressWarnings("static-access")
	public Exceptions(Main plugin){
		this.plugin = plugin;
	}
	//The above is used to access the Main class so below we can access the configuration to get the prefix
	private final static String prefix1 = plugin.getConfig().getString("prefix") + " ";
	//The line below "translates the color codes" or replaces the color/format codes with something that the code can read
	public final static String prefix = ChatColor.translateAlternateColorCodes('&', prefix1);
	public static String playernotFound(){
		String a = prefix + ChatColor.RED + "That player is not online!";
		return a;
		}
	public static String noPerm(){
		String a = prefix + ChatColor.RED + "You don't have permission to do this!";
		return a;
	}
	public static String notEnoughArgs(){
		String a = prefix + ChatColor.RED + "Not enough arguments!";
		return a;
	}
	public static String noMoney(){
		String a = prefix + ChatColor.RED + "You don't have enough money!";
		return a;
	}
	public static String mustbePlayer(){
		String a = prefix + ChatColor.RED + "Only players can use this!";
		return a;
	}


}
