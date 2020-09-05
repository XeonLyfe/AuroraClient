/*******************************************************************************
 * Copyright � 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.mod.movement;

import havook.feature.Mod;
import havook.feature.mod.ModAttributeDouble;
import havook.feature.mod.ModCategoryEnum;
import havook.manager.ModManager;
import net.minecraft.client.Minecraft;

public class Speed extends Mod {

	public transient ModAttributeDouble multiplier = new ModAttributeDouble("Multiplier",1.4);

	public Speed() {
		super("speedmotionx", "Speed | MotionX", "Go faster, duh.", ModCategoryEnum.MOVEMENT);
		addAttrib(multiplier);
	}

	@Override
	public void onLocalPlayerUpdate() {
		if (Minecraft.getMinecraft().player.collidedHorizontally || Minecraft.getMinecraft().player.isSneaking())
			return;
		if (Minecraft.getMinecraft().player.moveForward != 0 && Minecraft.getMinecraft().player.onGround || Minecraft.getMinecraft().player.moveStrafing != 0 && Minecraft.getMinecraft().player.onGround) {
			Minecraft.getMinecraft().player.motionX *= multiplier.value;
			Minecraft.getMinecraft().player.motionZ *= multiplier.value;
		}

	}
	@Override
	public void onEnable() {
		super.onEnable();
		ModManager.MODS.get(22).setEnabled(false);
	}
}
