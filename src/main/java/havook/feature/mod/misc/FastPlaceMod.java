/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.mod.misc;

import havook.feature.Mod;
import havook.feature.mod.ModCategoryEnum;
import havook.util.ChatUtil;
import net.minecraft.client.Minecraft;

public class FastPlaceMod extends Mod {
	private transient int nativeDelay;
	
	public FastPlaceMod() {
		super("fastplace", "Fast Place", "Allows to place blocks faster.", ModCategoryEnum.MISC);
	}
	
	@Override
	public void onEnable() {
		nativeDelay = Minecraft.getMinecraft().rightClickDelayTimer;
	}
	
	@Override
	public void onDisable() {
		Minecraft.getMinecraft().rightClickDelayTimer = nativeDelay;
	}
	
	@Override
	public void onLocalPlayerUpdate() {
		Minecraft.getMinecraft().rightClickDelayTimer = 0;
	}
}
