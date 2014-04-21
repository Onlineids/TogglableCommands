package me.online.Commands;

import me.online.Utils.Cooldowns;
import me.online.Utils.Exceptions;
import me.online.Utils.Messages;
import me.online.Utils.PlayerCooldown;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommands implements CommandExecutor{
	private final boolean enabled = Messages.commandEnabled("healCommands");
	private final long seconds = Messages.healCooldownLength();
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(enabled == true){

			if(command.getName().equalsIgnoreCase("heal")){
				if(sender instanceof Player){
					Player p = (Player) sender;
					PlayerCooldown pc = Cooldowns.getCooldown("healCoolDown", p.getName(), seconds * 1000);
					if(args.length == 0){
						if(p.hasPermission("tcl.heal.self")){
							if(Messages.healCoolDown()){
								if(pc.isOver() || p.hasPermission("tcl.heal.bypass")){
									p.setHealth(20);
									p.sendMessage(Messages.healSelf());
								}else{
									p.sendMessage(Messages.prefix() + ChatColor.RED + "You can't heal yourself for another " + ChatColor.GOLD + pc.getTimeLeft() + ChatColor.RED + " seconds!");
								}
							}else{
								p.setHealth(20);
								p.sendMessage(Messages.healSelf());
							}

						}else{
							p.sendMessage(Exceptions.noPerm());
						}
					}else if(args.length == 1){
						if(args[0].equalsIgnoreCase("all")){
							if(p.hasPermission("tcl.heal.all")){
								for(Player pl : Bukkit.getOnlinePlayers()){
									pl.setHealth(20);
									pl.sendMessage(Messages.healSelf());
								}
								p.sendMessage(Messages.healAll());
							}else{
								p.sendMessage(Exceptions.noPerm());
							}
						}else{
							if(p.hasPermission("tcl.heal.others")){
								Player target = Bukkit.getPlayerExact((args[0]));
								if(target != null){
									target.setHealth(20);
									target.sendMessage(Messages.healSelf());
									p.sendMessage(Messages.healOthers());
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
