package com.TheTagGame;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StopTag implements CommandExecutor {
	public Tag plugin;
	public StopTag(Tag tag) {
		plugin = tag;
	}

	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if (cs.hasPermission("tag.stop")){
			if (commandLabel.equalsIgnoreCase("tagstop")){
				Tager.pjoined = 0;
				cs.sendMessage("Tag stoped!");
				return true;
			}
		}
		
		return false;
		
	}
}
