/*******************************************************************************
 * Copyright � 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.mod.movement;

import havook.feature.Mod;
import havook.feature.mod.ModAttributeString;
import havook.feature.mod.ModCategoryEnum;
import net.minecraft.client.Minecraft;

public class AutoSprintMod extends Mod {
	public AutoSprintMod() {
		super("autosprint", "Sprint", "Makes you sprint automatically.", ModCategoryEnum.MOVEMENT);
	}

	@Override
	public void onLocalPlayerUpdate() {
		if (Minecraft.getMinecraft().player.collidedHorizontally || Minecraft.getMinecraft().player.isSneaking())
			return;
		if (Minecraft.getMinecraft().player.moveForward > 0)
			Minecraft.getMinecraft().player.setSprinting(true);
	}
}
