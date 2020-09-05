/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.handler;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import havook.Havook;
import havook.feature.Keybind;
import havook.manager.FriendManager;
import havook.manager.KeybindManager;
import havook.util.ChatUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyInputHandler {
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		if (Minecraft.getMinecraft().inGameHasFocus) {
			for (Keybind keybind : KeybindManager.KEYBINDS) {
				keybind.process();
			}
		}
	}
}
