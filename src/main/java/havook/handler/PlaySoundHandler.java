/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.handler;

import havook.Havook;
import havook.feature.Mod;
import havook.manager.ModManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlaySoundHandler {
	@SubscribeEvent
	public void onPlaySound(PlaySoundEvent event) {
		for (Mod mod : ModManager.MODS) {
			if (mod.isEnabled()) {
				mod.onPlaySound(event);
			}
		}
	}
}
