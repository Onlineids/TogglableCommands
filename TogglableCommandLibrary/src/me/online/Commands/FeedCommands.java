package me.online.Commands;

import me.online.Utils.Exceptions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(command.getName().equalsIgnoreCase("feed")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(args.length == 0){
					if(p.hasPermission("tcl.feed.self")){
						p.setFoodLevel(20);
						p.setExhaustion(0F);
						p.setSaturation(10F);
						
					}else{
						p.sendMessage(Exceptions.noPerm());
						
					}
				}
			}else{
				sender.sendMessage(Exceptions.mustbePlayer());
			}
		}
		
		
		return false;
	}

}
