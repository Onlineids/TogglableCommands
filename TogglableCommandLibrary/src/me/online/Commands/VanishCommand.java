package me.online.Commands;

import me.online.Utils.Exceptions;
import me.online.Utils.Messages;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor{
	private final boolean enabled = Messages.commandEnabled("vanishCommand");
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(command.getName().equalsIgnoreCase("vanish")){
			if(enabled){
				if(sender instanceof Player){
					Player p = (Player) sender;
					if(p.hasPermission("tcl.vanish")){
						for(Player pl : Bukkit.getOnlinePlayers()){
							pl.hidePlayer(p);
						}
						p.sendMessage(Messages.vanished());

					}else{
						sender.sendMessage(Exceptions.noPerm());
					}

				}else{
					sender.sendMessage(Exceptions.mustbePlayer());
				}
			}
		}

		return false;
	}

}
