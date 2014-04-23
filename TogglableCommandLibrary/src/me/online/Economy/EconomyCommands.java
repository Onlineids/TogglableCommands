package me.online.Economy;

import java.text.DecimalFormat;

import me.online.Utils.Exceptions;
import me.online.Utils.Messages;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EconomyCommands implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(Messages.econEnabled()){
			if(command.getName().equalsIgnoreCase("balance")){
				if(sender instanceof Player){
					Player p = (Player) sender;
					if(p.hasPermission("tcl.econ.balance")){
						String bal = format(EconomyMain.econ.getBalance(p.getName()));
						p.sendMessage(Messages.balance().replace("%a", bal));
						return true;
						
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
	public String format(double d){
		DecimalFormat formatter = new DecimalFormat("#,###.00");
		String fin = formatter.format(d);
		return fin;
	}
}
