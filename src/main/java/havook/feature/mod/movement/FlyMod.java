/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.mod.movement;

import havook.feature.Mod;
import havook.feature.mod.ModAttributeDouble;
import havook.feature.mod.ModCategoryEnum;
import net.minecraft.client.Minecraft;

public class FlyMod extends Mod {
	public transient ModAttributeDouble speed = new ModAttributeDouble("Speed", 1.0);

	public FlyMod() {
		super("fly", "Fly", "Allows you to fly.", ModCategoryEnum.MOVEMENT);
		addAttrib(speed);
	}

	@Override
	public void onLocalPlayerUpdate() {
		float yaw = Minecraft.getMinecraft().player.rotationYaw;
		int dx = 0, dy = 0, dz = 0;

		if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())
			dz--;
		if (Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown())
			dz++;

		if (Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown())
			dx--;
		if (Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown())
			dx++;

		if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown())
			dy++;
		if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown())
			dy--;

		double tempSpeed = speed.value * 0.5;

		// FORWARD & BACKWARD MOVEMENT
		Minecraft.getMinecraft().player.motionX = tempSpeed * dz * Math.sin(Math.toRadians(yaw));
		Minecraft.getMinecraft().player.motionZ = tempSpeed * dz * -Math.cos(Math.toRadians(yaw));
		// LEFT & RIGHT MOVEMENT
		Minecraft.getMinecraft().player.motionX += tempSpeed * dx * -Math.cos(Math.toRadians(yaw));
		Minecraft.getMinecraft().player.motionZ += tempSpeed * dx * -Math.sin(Math.toRadians(yaw));
		// UP & DOWN MOVEMENT
		Minecraft.getMinecraft().player.motionY = tempSpeed * dy;
	}
}
