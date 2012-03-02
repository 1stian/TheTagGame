package com.TheTagGame;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Config {
	public Tag plugin;
	public static FileConfiguration mainconfig = null;
	public static File configFile = null;
		

		public static void loadConfig() {
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
		
		public static void reloadConfig() {
			if (configFile == null) {
				configFile = new File("plugins/HCgeneralCommands/data/warps.yml");
			}
			mainconfig = YamlConfiguration.loadConfiguration(configFile);
		}

		public static FileConfiguration getConfig() {
			if (mainconfig == null) {
				reloadConfig();
			}
			return mainconfig;
		}

		public static void saveConfig() {
			if (mainconfig == null || configFile == null) {
				return;
			}
			try {
				mainconfig.save(configFile);
			} catch (IOException ex) {
				Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Error saving warps to " + configFile, ex);
			}
		}
		public void configSettings(){
			mainconfig.addDefault("AutoStart", true);
			mainconfig.addDefault("Required amount of players to auto start", 4);
			saveConfig();
		}
	}
