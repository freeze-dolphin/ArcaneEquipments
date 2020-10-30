package io.github.freeze_dolphin.arcane_equipments;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.cscorelib2.config.Config;

public class ArcaneEquipments extends JavaPlugin {
	
	private final Config config = new Config(this);
	private static Plugin instance;
	
	@Override
	public void onEnable() {
		instance = this;
	}
	
	public Plugin getInstance() {
		return instance;
	}
	
	public Config getCSConfig() {
		return config;
	}
	
}
