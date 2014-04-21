package me.online.Commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.online.Utils.Messages;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommands implements CommandExecutor{
	private final boolean enabled = Messages.commandEnabled("messageCommands");
	private Map<Player, Player> reply = new HashMap<Player, Player>();
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(enabled){
			if(command.getName().equalsIgnoreCase("message")){
				
				
				
			}else if(command.getName().equalsIgnoreCase("reply")){
				if(reply.get(sender) != null){
					Player reciever = reply.get(sender);
					List<String> msg = new ArrayList<String>();
					int length = args.length;
					int i;
					for (i = 0; i < length; i++) {
						msg.add((args[i]));
					}
					sender.sendMessage(Messages.messageFormatS().replace("%m", msg.toString()));
					reciever.sendMessage(Messages.messageFormatR().replace("%m", msg.toString()));

				}else{
					sender.sendMessage(Messages.noReply());
				}
			}
		}
		
		return false;
	}

}
