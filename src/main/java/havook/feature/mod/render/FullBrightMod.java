/*******************************************************************************
 * Copyright � 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.mod.render;

import havook.feature.Mod;
import havook.feature.mod.ModCategoryEnum;
import net.minecraft.client.Minecraft;

public class FullBrightMod extends Mod {
	private transient float nativeGamma;

	public FullBrightMod() {
		super("fullbright", "Light", "Allows you to see in the dark.", ModCategoryEnum.RENDER);
	}

	@Override
	public void onEnable() {
		nativeGamma = Minecraft.getMinecraft().gameSettings.gammaSetting;
		Minecraft.getMinecraft().gameSettings.gammaSetting = 8f;
	}

	@Override
	public void onDisable() {
		if (nativeGamma < 1.0) // if game has closed with Full Bright enabled, the gamma will be ducked up
			Minecraft.getMinecraft().gameSettings.gammaSetting = nativeGamma;
		else
			Minecraft.getMinecraft().gameSettings.gammaSetting = 0.5f;
	}
}
