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
import havook.feature.mod.ModAttributeString;
import havook.feature.mod.ModCategoryEnum;
import net.minecraft.client.Minecraft;

public class Step extends Mod {
	ModAttributeDouble stepheight = new ModAttributeDouble("Step Height", 1);
	public Step() {
		super("step", "Step", "Step up blocks", ModCategoryEnum.MOVEMENT);
		addAttrib(stepheight);
	}

	@Override
	public void onLocalPlayerUpdate() {
		Minecraft.getMinecraft().player.stepHeight = (float)stepheight.value;
	}
	@Override
	public void onDisable() {
		
		Minecraft.getMinecraft().player.stepHeight = 0.5f;
		
	}
}
