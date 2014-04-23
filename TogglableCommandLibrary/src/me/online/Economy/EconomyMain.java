package me.online.Economy;

import java.util.logging.Logger;

import me.online.TogglableCommandLibrary.Main;
import me.online.Utils.Messages;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.RegisteredServiceProvider;

public class EconomyMain {
	public static Main plugin;    
	public static Economy econ = null;
    private static final Logger log = Logger.getLogger("Minecraft");
	@SuppressWarnings("static-access")
	public EconomyMain(Main plugin){
		this.plugin = plugin;
	}
	 private boolean setupEconomy() {
	        if (plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
	            return false;
	        }
	        RegisteredServiceProvider<Economy> rsp = plugin.getServer().getServicesManager().getRegistration(Economy.class);
	        if (rsp == null) {
	            return false;
	        }
	        econ = rsp.getProvider();
	        return econ != null;
	    }
	public void onEnable(){
		if(Messages.econEnabled()){
			if (!setupEconomy() ) {
				log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", plugin.getDescription().getName()));
				int i;
				for(i = 0; i < 4; i++){
					log.severe("COMMAND LIBRARY, YOU HAVE ECONOMY ENABLED BUT DONT HAVE VAULT, DISABLE ECONOMY IN CONFIG TO USE THIS PLUGIN WITHOUT VAULT!");
				}
				plugin.getServer().getPluginManager().disablePlugin(plugin);
				return;
			}
		}
	}
}
