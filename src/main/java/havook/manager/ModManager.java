/*******************************************************************************
 * Copyright � 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.manager;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import havook.feature.Mod;
import havook.feature.mod.ModAttribute;
import havook.feature.mod.ModAttributeBoolean;
import havook.feature.mod.ModAttributeDouble;
import havook.feature.mod.ModAttributeString;
import havook.feature.mod.combat.TriggerBotMod;
import havook.feature.mod.misc.AutoFishMod;
import havook.feature.mod.misc.ChatSpammer;
import havook.feature.mod.misc.FastPlaceMod;
import havook.feature.mod.movement.AutoSneakMod;
import havook.feature.mod.movement.AutoSprintMod;
import havook.feature.mod.movement.AutoWalkMod;
import havook.feature.mod.movement.ElytraBoostMod;
import havook.feature.mod.movement.FlyMod;
import havook.feature.mod.movement.ParkourMod;
import havook.feature.mod.movement.SafeWalkMod;
import havook.feature.mod.movement.Speed;
import havook.feature.mod.movement.SpeedBounce;
import havook.feature.mod.movement.Step;
import havook.feature.mod.render.ActiveListMod;
import havook.feature.mod.render.ChestESPMod;
import havook.feature.mod.render.FullBrightMod;
import havook.feature.mod.render.HealthTags;
import havook.feature.mod.render.ItemESPMod;
import havook.feature.mod.render.MobESPMod;
import havook.feature.mod.render.PlayerESPMod;
import havook.feature.mod.render.TrajectoriesMod;
import havook.feature.mod.render.Watermark;

public class ModManager {
	public static List<Mod> MODS = new ArrayList<Mod>();

	public static void loadMods() {

		MODS.add(new ActiveListMod());
		MODS.add(new Watermark());
		MODS.add(new AutoFishMod());
		MODS.add(new AutoSneakMod());
		MODS.add(new AutoSprintMod());
		MODS.add(new AutoWalkMod());
		MODS.add(new ChestESPMod());
		MODS.add(new ElytraBoostMod());
		MODS.add(new FastPlaceMod());
		MODS.add(new FlyMod());
		// 10th Mod vv
		MODS.add(new FullBrightMod());
		MODS.add(new HealthTags());
		MODS.add(new ItemESPMod());
		MODS.add(new MobESPMod());
		MODS.add(new ParkourMod());
		MODS.add(new PlayerESPMod());
		MODS.add(new SafeWalkMod());
		MODS.add(new TrajectoriesMod());
		MODS.add(new TriggerBotMod());
		MODS.add(new ChatSpammer());
		// 20th Mod vv
		MODS.add(new Speed());
		MODS.add(new Step());
		MODS.add(new SpeedBounce());
		JsonArray modsArray = ConfigManager.getJsonObject().getAsJsonArray("mods");
		if(modsArray == null) {
			saveMods();
			return;
		}
		for (int i = 0; i < modsArray.size(); i++) {
			String id = modsArray.get(i).getAsJsonObject().get("id").getAsString();
			Mod targetMod = getModById(id);
			if (targetMod == null)continue;
			if(modsArray.get(i).getAsJsonObject().has("enabled") && modsArray.get(i).getAsJsonObject().get("enabled").getAsBoolean())if(modsArray.get(i).getAsJsonObject().get("enabled").getAsBoolean())targetMod.setEnabled(true);
			for (ModAttribute targetAttribute : targetMod.ATTRIBUTES) {
				String stringValue = null;
				JsonArray attribsArray = modsArray.get(i).getAsJsonObject().getAsJsonArray("attributes");
				for (int j = 0; j < attribsArray.size(); j++) {
					if (attribsArray.get(j).getAsJsonObject().get("name").getAsString().equals(targetAttribute.name)) {
						stringValue = attribsArray.get(j).getAsJsonObject().get("value").getAsString();
						break;
					}
				}
				if (stringValue == null)continue;
				if (targetAttribute instanceof ModAttributeBoolean) {
					if (stringValue.equalsIgnoreCase("true") || stringValue.equalsIgnoreCase("false")) {
						Boolean value = Boolean.parseBoolean(stringValue);
						((ModAttributeBoolean) targetAttribute).value = value;
					} else continue;
				} else if (targetAttribute instanceof ModAttributeDouble) {
					double number;
					try {
						number = Double.parseDouble(stringValue);
					} catch (NullPointerException | NumberFormatException e) {
						continue;
					}
					((ModAttributeDouble) targetAttribute).value = number;
				} else if (targetAttribute instanceof ModAttributeString) {
					((ModAttributeString) targetAttribute).value = stringValue;
				}
			}
		}
		saveMods(); // fix any errors in the config file
	}

	public static void saveMods() {
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(MODS, new TypeToken<List<Mod>>() {
		}.getType());
		ConfigManager.getJsonObject().add("mods", element);
		ConfigManager.saveConfig();
	}

	public static Mod getModById(String id) {
		for (Mod mod : MODS) {
			if (mod.id.equalsIgnoreCase(id))
				return mod;
		}
		return null;
	}
}
