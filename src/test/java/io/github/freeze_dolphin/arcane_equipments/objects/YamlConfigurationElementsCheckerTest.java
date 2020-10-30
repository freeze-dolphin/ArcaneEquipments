package io.github.freeze_dolphin.arcane_equipments.objects;

import static org.junit.jupiter.api.Assertions.*;

import org.bukkit.configuration.file.YamlConfiguration;
import org.junit.jupiter.api.Test;

class YamlConfigurationElementsCheckerTest {
	
	@Test
	void test() {
		YamlConfiguration yaml = new YamlConfiguration();
		yaml.set("name.a.v", "test");
		yaml.set("\t", "test");
		assertEquals(new YamlConfigurationElementsChecker(yaml).check("name.a.v|\t||||"), true);
	}

}
