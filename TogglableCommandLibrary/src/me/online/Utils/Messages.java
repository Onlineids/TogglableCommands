package me.online.Utils;

import me.online.TogglableCommandLibrary.Main;

import org.bukkit.ChatColor;

public class Messages {
	public static Main plugin;
	@SuppressWarnings("static-access")
	public Messages(Main plugin){
		this.plugin = plugin;
	}
	private final static String prefix = plugin.getConfig().getString("prefix") + " ";
	public static String prefix(){
		return prefix;
	}
	public static boolean econEnabled(){
		boolean a = plugin.getConfig().getBoolean("economyEnabled");
		return a;
	}
	public static String vanished(){
		String b = prefix + " " + plugin.getConfig().getString("vanishCommand.vanished");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	public static String balance(){
		String b = prefix + " " + plugin.getConfig().getString("economyCommands.balance");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	public static String feedSelf(){
		String b = prefix + " " + plugin.getConfig().getString("feedCommands.feedSelf");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	public static String feedAll(){
		String b = prefix + " " + plugin.getConfig().getString("feedCommands.feedAll");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	public static boolean healCoolDown(){
		boolean enabled = plugin.getConfig().getBoolean("healCommands.coolDownEnabled");
		return enabled;
	}
	public static Long healCooldownLength(){
		int sec = plugin.getConfig().getInt("healCommands.coolDownLength");
		long seconds = (long) sec;
		return seconds;
	}
	public static String feedOthers(){
		String b = prefix + " " + plugin.getConfig().getString("healcommands.feedOthers");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	public static String healOthers(){
		String b = prefix + " " + plugin.getConfig().getString("healcommands.healOthers");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	public static String messageFormatR(){
		String b = prefix + " " + plugin.getConfig().getString("messageCommands.messageFormatReciever");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	public static String messageFormatS(){
		String b = prefix + " " + plugin.getConfig().getString("messageCommands.messageFormatSender");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	public static String tpd(){
		String b = prefix + " " + plugin.getConfig().getString("teleportCommands.tpd");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	public static String tpAll(){
		String b = prefix + " " + plugin.getConfig().getString("teleportCommands.tpAll");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	public static String healAll(){
		String b = prefix + " " + plugin.getConfig().getString("healcommands.healAll");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	public static String healSelf(){
		String b = prefix + " " + plugin.getConfig().getString("healcommands.healSelf");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	public static String noReply(){
		String b = prefix + " " + plugin.getConfig().getString("messageCommands.noonetoReply");
		String a = ChatColor.translateAlternateColorCodes('&', b);
		return a;
	}
	//Below is the method I use to check if a command is enabled or not
	public static boolean commandEnabled(String command){
		if(plugin.getConfig().getBoolean(command + ".enabled")){
			return true;
		}else{
			return false;
		}
		
	}
}
