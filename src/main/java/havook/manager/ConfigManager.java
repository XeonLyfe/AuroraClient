/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import havook.Havook;
import havook.Reference;

public class ConfigManager {
	private static JsonObject jsonObject;

	public static void loadConfig() {
		try {
			File file = new File("config/" + Reference.MODID + ".cfg");
			FileReader reader = new FileReader(file);
			char[] charBuffer = new char[(int) file.length()];
			reader.read(charBuffer);
			reader.close();
			jsonObject = new JsonParser().parse(String.valueOf(charBuffer)).getAsJsonObject();
		} catch (IOException e) {
			Havook.LOGGER.warning(e.getMessage());
			jsonObject = new JsonObject();
		}
	}

	public static void saveConfig() {
		Gson gson = new GsonBuilder().create();
		try {
			FileWriter writer = new FileWriter("config/" + Reference.MODID + ".cfg");
			writer.write(gson.toJson(jsonObject));
			writer.close();
		} catch (IOException e) {
			Havook.LOGGER.warning(e.getMessage());
		}
	}

	public static JsonObject getJsonObject() {
		return jsonObject;
	}
}
