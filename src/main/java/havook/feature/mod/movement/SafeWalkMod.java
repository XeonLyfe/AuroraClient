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
import havook.feature.mod.ModAttributeBoolean;
import havook.feature.mod.ModCategoryEnum;
import havook.util.BlockUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class SafeWalkMod extends Mod {
	public SafeWalkMod() {
		super("safewalk", "Safe Walk", "Makes you sneak on edges.", ModCategoryEnum.MOVEMENT);
	}

	@Override
	public void onDisable() {
		KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(),
				Minecraft.getMinecraft().gameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindSneak));
	}

	@Override
	public void onLocalPlayerUpdate() {
		if (Minecraft.getMinecraft().player.onGround
				&& !Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed()
				&& !BlockUtil.isCollidable(Minecraft.getMinecraft().world
						.getBlockState(new BlockPos(
								Minecraft.getMinecraft().player.getPositionVector().add(new Vec3d(0, -0.5, 0))))
						.getBlock()))
			KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), true);
		
		else if (!Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode()))
			KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), false);
	}
}
