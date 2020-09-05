/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.util.math.Vec3d;

public class EntityUtil {
	public static boolean isAnimal(Entity entity) {
		if (entity instanceof EntityAgeable || entity instanceof EntityAmbientCreature
				|| entity instanceof EntityWaterMob || entity instanceof EntityGolem)
			return true;
		return false;
	}

	public static Vec3d getInterpolatedPos(Entity entity, float partialTicks) {
		return MathUtil.interpolateVec3d(entity.getPositionVector(),
				new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ), partialTicks);
	}
}
