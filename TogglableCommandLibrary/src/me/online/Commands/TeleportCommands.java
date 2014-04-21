package me.online.Commands;

import me.online.Utils.Exceptions;
import me.online.Utils.Messages;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommands implements CommandExecutor{
	private final boolean enabled = Messages.commandEnabled("teleportCommands");
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(enabled){
			if(command.getName().equals("tpall")){
				if(sender instanceof Player){
					Player p = (Player) sender;
					if(p.hasPermission("tcl.tp.all")){
						Location loc = p.getLocation();
						for(Player pl : Bukkit.getOnlinePlayers()){
							if(!(pl.hasPermission("tcl.tp.all.bypass"))){
								pl.teleport(loc);
								pl.sendMessage(Messages.tpd());
							}
							p.sendMessage(Messages.tpAll());
						}
					}else{
						p.sendMessage(Exceptions.noPerm());
					}
				}else{
					sender.sendMessage(Exceptions.mustbePlayer());
				}
			}
		}

		return false;
	}

}
