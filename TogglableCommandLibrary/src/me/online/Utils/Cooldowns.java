package me.online.Utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Cooldowns {
	  private static Set<PlayerCooldown> cooldowns = new HashSet<PlayerCooldown>();
	 
	  public static void addCooldown(String cooldownName, String player, long lengthInMillis) {
	      PlayerCooldown pc = new PlayerCooldown(cooldownName, player, lengthInMillis);
	      Iterator<PlayerCooldown> it = cooldowns.iterator();
	      //This section prevents duplicate cooldowns
	      while(it.hasNext()) {
	        PlayerCooldown iterated = it.next();
	        if(iterated.getPlayerName().equalsIgnoreCase(pc.getPlayerName())) {
	            if(iterated.getCooldownName().equalsIgnoreCase(pc.getCooldownName())) {
	              it.remove();
	            }
	        }
	      }
	      cooldowns.add(pc);
	  }
	  public static PlayerCooldown getCooldown(String cooldownName, String playerName, long length) {
	      Iterator<PlayerCooldown> it = cooldowns.iterator();
	      while(it.hasNext()) {
	        PlayerCooldown pc = it.next();
	        if(pc.getCooldownName().equalsIgnoreCase(cooldownName)) {
	            if(pc.getPlayerName().equalsIgnoreCase(playerName)) {
	              return pc;
	            }
	        }
	      }
	      return new PlayerCooldown(cooldownName, playerName, length, true);
	  }
	 
	}
