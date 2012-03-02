package com.TheTagGame;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.TheTagGame.Tager;

public class JoinTag implements CommandExecutor {
	public static HashMap<String, Boolean> TagP = new HashMap<String, Boolean>();
	
	public Tag plugin;
	public JoinTag(Tag tag) {
		plugin = tag;
	}

	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if (cs.hasPermission("tag.play")){
			if (commandLabel.equalsIgnoreCase("tagjoin")){
				String TagPlayer = cs.getName();
				if (!TagP.containsKey(TagPlayer)){
					TagP.put(TagPlayer, true);
					Tager.pjoined++;
					Tager.playerCount();
					return true;
				}else{
					cs.sendMessage("Tag: You can't join twice!");
				}
			}
		}
		
		return false;
		
	}
}
