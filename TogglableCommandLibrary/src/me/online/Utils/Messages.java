package me.online.Utils;

import me.online.TogglableCommandLibrary.Main;

public class Messages {
	public static Main plugin;
	@SuppressWarnings("static-access")
	public Messages(Main plugin){
		this.plugin = plugin;
	}
	public static String feedSelf(){
		String a = plugin.getConfig().getString("feedCommands.feedSelf");
		return a;
	}
	public static String feedAll(){
		String a = plugin.getConfig().getString("feedCommands.feedAll");
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
