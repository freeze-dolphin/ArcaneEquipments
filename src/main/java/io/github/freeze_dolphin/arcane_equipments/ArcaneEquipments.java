package io.github.freeze_dolphin.arcane_equipments;

import java.io.File;
import java.io.IOException;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.freeze_dolphin.arcane_equipments.adapters.ScriptAdapter;
import io.github.thebusybiscuit.cscorelib2.config.Config;

public class ArcaneEquipments extends JavaPlugin {

	private final Config config = new Config(this);
	private static Plugin instance;

	@Override
	public void onEnable() {
		instance = this;

		try {
			ScriptAdapter scriptAdapter = new ScriptAdapter(this, config.getString("script-directory-name"));
			scriptAdapter.initialize();
			if (scriptAdapter.getAbandonedScripts().length > 0) {
				warn("Detected that following scripts are invalid: ");
				for (File f : scriptAdapter.getAbandonedScripts()) {
					warn("  - " + f.getName() + " [" + f.getPath() + "]");
				}
			}
			if (scriptAdapter.getDisabledScripts().length > 0) {
				warn("Detected that following scripts are disabled: ");
				for (File f : scriptAdapter.getDisabledScripts()) {
					warn("  - " + f.getName() + " [" + f.getPath() + "]");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			severe("IOException occurred while initializing, self-disabling...");
			this.setEnabled(false);
		}

	}

	public Plugin getInstance() {
		return instance;
	}

	public Config getCSConfig() {
		return config;
	}
	
	public void info(String msg) {
		getLogger().info(msg);
	}

	public void warn(String msg) {
		getLogger().warning(msg);
	}
	
	public void severe(String msg) {
		getLogger().severe(msg);
	}
	
}
