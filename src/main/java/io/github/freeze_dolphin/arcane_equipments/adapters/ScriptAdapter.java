package io.github.freeze_dolphin.arcane_equipments.adapters;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import io.github.freeze_dolphin.arcane_equipments.ArcaneEquipments;

public class ScriptAdapter {

	private File scriptDir;

	public ScriptAdapter(ArcaneEquipments plug) throws IOException {
		scriptDir = new File(plug.getDataFolder().getAbsolutePath() + File.separator + "scripts");

		if (!scriptDir.exists()) {
			scriptDir.createNewFile();
			plug.getLogger().warning("Script folder not found, automatically created!");
		}
	}

	public void initialize() {
		for (File f : scriptDir.listFiles(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				return name.endsWith(".yml") || name.endsWith(".yaml");
			}
		})) {
			YamlConfiguration ycfg = YamlConfiguration.loadConfiguration(f);

		}
	}

	public void reload() {

		// TODO code to realise: script file reloading

	}

}
