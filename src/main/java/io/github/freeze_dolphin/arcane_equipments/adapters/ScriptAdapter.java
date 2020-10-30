package io.github.freeze_dolphin.arcane_equipments.adapters;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import io.github.freeze_dolphin.arcane_equipments.ArcaneEquipments;
import io.github.freeze_dolphin.arcane_equipments.objects.YamlConfigurationElementsChecker;

public class ScriptAdapter {

	private static final String elementsRequired = "engine-name";
	
	private File scriptDir;
	private List<File> yamlAbandoned = new ArrayList<File>();
	private List<File> yamlDisabled = new ArrayList<File>();
	
	public ScriptAdapter(ArcaneEquipments plug, String scriptDirectoryName) throws IOException {
		scriptDir = new File(plug.getDataFolder().getAbsolutePath() + File.separator + scriptDirectoryName);
		if (!scriptDir.exists()) {
			scriptDir.mkdir();
			plug.getLogger().warning("Script directory not found, automatically created!");
		}
	}

	public void initialize() {
		for (File f : scriptDir.listFiles(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				return name.endsWith(".yml") || name.endsWith(".yaml");
			}
		})) {
			YamlConfiguration ycfg = YamlConfiguration.loadConfiguration(f);
			if (new YamlConfigurationElementsChecker(ycfg).check(elementsRequired)) {
				if (f.getName().startsWith("_")) {
					yamlDisabled.add(f);
					continue;
				}
				
				// TODO code to realize: script reading & loadings
				
			} else {
				yamlAbandoned.add(f);
				continue;
			}
		}
	}
	
	public File[] getAbandonedScripts() {
		return yamlAbandoned.toArray(new File[yamlAbandoned.size()]);
	}

	public File[] getDisabledScripts() {
		return yamlDisabled.toArray(new File[yamlDisabled.size()]);
	}
	
	public void reload() {

		// TODO code to realize: script file reloading

	}

}
