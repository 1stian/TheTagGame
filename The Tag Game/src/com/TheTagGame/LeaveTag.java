package com.TheTagGame;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LeaveTag implements CommandExecutor {
	
	public Tag plugin;
	public LeaveTag(Tag tag) {
		plugin = tag;
	}
	
	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if (cs.hasPermission("tag.play")){
			if (commandLabel.equalsIgnoreCase("tagleave")){
				String TagPlayer = cs.getName();
				if (JoinTag.TagP.containsKey(TagPlayer)){
					JoinTag.TagP.remove(TagPlayer);
					Tager.pjoined--;
					Tager.playerCount();
					return true;
				}else{
					cs.sendMessage("Tag: You can't leave when you are not in a game!");
				}
			}
		}
		
		return false;
		
	}
}
