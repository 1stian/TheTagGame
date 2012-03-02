package com.TheTagGame;
import org.bukkit.plugin.java.JavaPlugin;


public class Tag extends JavaPlugin{
	public static Tag plugin;
	
	public void onDisable(){
		this.saveConfig();
	}
	
	public void onEnable(){
		Getcommands(this);
		PluginConfig(this);
	}

	public void Getcommands(Tag tag){
		this.getCommand("tagjoin").setExecutor(new JoinTag(this));
		this.getCommand("tagleave").setExecutor(new LeaveTag(this));
		this.getCommand("tagstop").setExecutor(new StopTag(this));
	}
	public void PluginConfig(Tag tag) {
		this.reloadConfig();
		this.getConfig().addDefault("AutoStart", true);
		this.getConfig().addDefault("Rquired players for AutoStart", 4);
		this.saveConfig();
	}
}
