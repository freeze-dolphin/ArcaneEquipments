package io.github.freeze_dolphin.arcane_equipments.adapters;

import java.io.File;
import java.io.IOException;

import io.github.freeze_dolphin.arcane_equipments.ArcaneEquipments;

public class ScriptAdapter {
	
	public ScriptAdapter(ArcaneEquipments plug) throws IOException {
		File scriptDir = new File(plug.getDataFolder().getAbsolutePath() + File.separator + "scripts");
		
		if (!scriptDir.exists()) {
			scriptDir.createNewFile();
			plug.getLogger().warning("Script folder not found, automatically created");
			return;
		}
		
		
		
	}
	
}
