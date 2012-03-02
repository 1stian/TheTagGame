package com.TheTagGame;

import java.util.HashMap;

import org.bukkit.Bukkit;

import com.TheTagGame.Tag;

public class Tager {
	
	public static Tag plugin;
	
	public Tager(Tag instance) {
		plugin = instance;
	}
	
	static int pjoined = 0;
	static int pstart = 2;
	
	static int countto = 100;
	static int counter = 0;
	
	public static HashMap<String, Boolean> TagRun = new HashMap<String, Boolean>();
	private static int TagStarter;
	
	public static void playerCount(){	
		if (pjoined < pstart){
			Bukkit.broadcastMessage("Tag: " + pjoined + "/" + pstart + " Players");
		}else{
			Bukkit.broadcastMessage("Tag game will start in:");
			
			 TagStarter = plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable(){

				public void run() {
					counter++;
					Bukkit.broadcastMessage("Tag: " + counter);
					if (counter < 5){
						TagRun.put("TagGame", true);
						Bukkit.broadcastMessage("Tag game has started!");
						Bukkit.getScheduler().cancelTask(TagStarter);
					}
				}
				
			}, 20, 100);
		}
	}
}
