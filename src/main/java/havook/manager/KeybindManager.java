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

import havook.Havook;
import havook.feature.Keybind;

public class KeybindManager {
	public static List<Keybind> KEYBINDS = new ArrayList<Keybind>();

	public static void loadKeybinds() {
		JsonArray keybindsArray = ConfigManager.getJsonObject().getAsJsonArray("keybinds");
		if (keybindsArray == null) {
			resetKeybinds();
			return;
		}
		for (int i = 0; i < keybindsArray.size(); i++) {
			int id = keybindsArray.get(i).getAsJsonObject().get("id").getAsInt();
			int key = keybindsArray.get(i).getAsJsonObject().get("key").getAsInt();
			String message = keybindsArray.get(i).getAsJsonObject().get("message").getAsString();
			addKeybind(id, key, message);
		}
	}

	public static void saveKeybinds() {
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(KEYBINDS, new TypeToken<List<Keybind>>() {
		}.getType());
		ConfigManager.getJsonObject().add("keybinds", element);
		ConfigManager.saveConfig();
	}

	public static void resetKeybinds() {
		KEYBINDS.clear();
		addKeybind(0, 54, ".gui");
		addKeybind(1, 49, ".mod t TriggerbotCommand.java");
		saveKeybinds();
	}

	public static boolean removeKeybind(int id) {
		for (int i = 0; i < KEYBINDS.size(); i++) {
			if (KEYBINDS.get(i).id == id) {
				KEYBINDS.remove(i);
				saveKeybinds();
				return true;
			}
		}
		return false;
	}

	public static void addKeybind(int id, int key, String message) {
		KEYBINDS.add(new Keybind(id, key, message));
		saveKeybinds();
	}

	public static Keybind getKeybindById(int id) {
		for (Keybind keybind : KEYBINDS) {
			if (keybind.id == id) {
				return keybind;
			}
		}
		return null;
	}
}
