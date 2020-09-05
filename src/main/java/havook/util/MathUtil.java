/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.util;

import net.minecraft.util.math.Vec3d;

public class MathUtil {
	public static float interpolateFloat(float current, float last, float partialTicks) {
		float interpolation = -(current - last) + (current - last) * partialTicks;
		return current + interpolation;
	}

	public static Vec3d interpolateVec3d(Vec3d current, Vec3d last, float partialTicks) {
		return current.subtract(last).scale(partialTicks).add(last);
	}
}
