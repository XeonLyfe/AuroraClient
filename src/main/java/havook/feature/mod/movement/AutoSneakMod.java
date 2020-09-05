/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.mod.movement;

import org.lwjgl.input.Keyboard;

import havook.feature.Mod;
import havook.feature.mod.ModCategoryEnum;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class AutoSneakMod extends Mod {
	public AutoSneakMod() {
		super("autosneak", "Auto Sneak", "Makes you sneak automatically.", ModCategoryEnum.MOVEMENT);
	}

	@Override
	public void onDisable() {
		KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(),
				Minecraft.getMinecraft().gameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindSneak));
	}

	@Override
	public void onLocalPlayerUpdate() {
		KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), true);
	}
}
