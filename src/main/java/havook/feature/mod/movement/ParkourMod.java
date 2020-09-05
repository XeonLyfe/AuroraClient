/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.mod.movement;

import havook.feature.Mod;
import havook.feature.mod.ModCategoryEnum;
import net.minecraft.client.Minecraft;

public class ParkourMod extends Mod {
	public ParkourMod() {
		super("parkour", "Parkour", "Makes you jump automatically when reaching the edge of a block.",
				ModCategoryEnum.MOVEMENT);
	}

	@Override
	public void onLocalPlayerUpdate() {
		if (Minecraft.getMinecraft().player.onGround && !Minecraft.getMinecraft().player.isSneaking()
				&& !Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed()
				&& Minecraft.getMinecraft().world
						.getCollisionBoxes(Minecraft.getMinecraft().player, Minecraft.getMinecraft().player
								.getEntityBoundingBox().offset(0, -0.5, 0).expand(-0.001, 0, -0.001))
						.isEmpty()) {
			Minecraft.getMinecraft().player.jump();
		}
	}
}
