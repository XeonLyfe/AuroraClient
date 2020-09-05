/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.handler;

import havook.Havook;
import havook.gui.LongMessageSenderGui;
import havook.util.ChatUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class ClientTickHandler {
	private static GuiScreen nextGui = null;

	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		if (event.phase != Phase.START)
			return;

		if (nextGui != null) {
			Minecraft.getMinecraft().displayGuiScreen(nextGui);
			nextGui = null;
		}
	}

	public static void queueGui(GuiScreen gui) {
		nextGui = gui;
	}
}
