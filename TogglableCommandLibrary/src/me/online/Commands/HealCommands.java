package me.online.Commands;

import me.online.Utils.Messages;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HealCommands implements CommandExecutor{
	private final boolean enabled = Messages.commandEnabled("feedCommands");
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		
		return false;
	}

}
