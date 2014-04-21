package me.online.Commands;

import me.online.Utils.Exceptions;
import me.online.Utils.Messages;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommands implements CommandExecutor{

	private final boolean enabled = Messages.commandEnabled("feedCommands");
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(enabled == true){
			if(command.getName().equalsIgnoreCase("feed")){
				if(sender instanceof Player){
					Player p = (Player) sender;
					if(args.length == 0){
						if(p.hasPermission("tcl.feed.self")){
							p.setFoodLevel(20);
							p.setExhaustion(0F);
							p.setSaturation(10F);
							p.sendMessage(Messages.feedSelf());
						}else{
							p.sendMessage(Exceptions.noPerm());
						}
					}else if(args.length == 1){
						if(args[0].equalsIgnoreCase("all")){
							if(p.hasPermission("tcl.feed.all")){
								for(Player pl : Bukkit.getOnlinePlayers()){
									pl.setFoodLevel(20);
									pl.setExhaustion(0F);
									pl.setSaturation(10F);
									pl.sendMessage(Messages.feedSelf());
								}
								p.sendMessage(Messages.feedAll());
							}else{
								p.sendMessage(Exceptions.noPerm());
							}
						}else{
							if(p.hasPermission("tcl.feed.others")){
								Player target = Bukkit.getPlayerExact((args[0]));
								if(target != null){
									target.setFoodLevel(20);
									target.setExhaustion(0F);
									target.setSaturation(10F);
									target.sendMessage(Messages.feedSelf());
									p.sendMessage(Messages.feedOthers());
								}else{
									p.sendMessage(Exceptions.playernotFound());
								}
							}else{
								p.sendMessage(Exceptions.noPerm());
							}
						}
					}else{
						p.sendMessage(Exceptions.notEnoughArgs());
					}
				}else{
					sender.sendMessage(Exceptions.mustbePlayer());
				}
			}
		}


		return false;
	}

}
