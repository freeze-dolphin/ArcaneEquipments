package io.github.freeze_dolphin.arcane_equipments;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.ArrayUtils;
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
			File[] allInvalidScripts = {};
			File[] allDisabledScripts = {};
			for (String scriptDirName : config.getStringList("script-directories")) {
				ScriptAdapter scriptAdapter = new ScriptAdapter(this, scriptDirName);
				scriptAdapter.initialize();
				ArrayUtils.addAll(allInvalidScripts, scriptAdapter.getInvalidScripts());
				ArrayUtils.addAll(allDisabledScripts, scriptAdapter.getDisabledScripts());
			}
			if (allInvalidScripts.length > 0) {
				warn("Detected that following scripts are invalid: ");
				for (File f : allInvalidScripts) {
					warn("  - " + f.getName() + " [" + f.getPath() + "]");
				}
			}
			if (allDisabledScripts.length > 0) {
				warn("Detected that following scripts are disabled: ");
				for (File f : allDisabledScripts) {
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
