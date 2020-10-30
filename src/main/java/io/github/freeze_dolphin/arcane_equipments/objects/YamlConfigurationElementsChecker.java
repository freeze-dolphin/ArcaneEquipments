package io.github.freeze_dolphin.arcane_equipments.objects;

import org.bukkit.configuration.file.YamlConfiguration;

public class YamlConfigurationElementsChecker {
	
	private final YamlConfiguration yaml;
	
	public YamlConfigurationElementsChecker(YamlConfiguration yaml) {
		this.yaml = yaml;
	}
	
	/**
	 * Check whether the {@link YamlConfiguration} has all the elements provided
	 * @param elementsRequired Format: "name|version|keys.key1.value"
	 */
	public boolean check(String elementsRequired) {
		boolean rt = true;
		for (String s : elementsRequired.split("\\|")) {
			if (!yaml.contains(s)) {
				rt = false;
				break;
			}
		}
		return rt;
	}
	
	
	
}
