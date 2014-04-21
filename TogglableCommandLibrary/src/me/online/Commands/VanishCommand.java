package me.online.Commands;

import me.online.Utils.Exceptions;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(command.getName().equalsIgnoreCase("vanish")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.hasPermission("tcl.vanish")){
					for(Player pl : Bukkit.getOnlinePlayers()){
						pl.hidePlayer(p);
					}
					p.sendMessage(arg0);
					
				}else{
					sender.sendMessage(Exceptions.noPerm());
				}
				
			}else{
				sender.sendMessage(Exceptions.mustbePlayer());
			}
		}
		
		return false;
	}

}
