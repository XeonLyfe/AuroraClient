/*******************************************************************************
 * Copyright � 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.mod.misc;

import havook.feature.Mod;
import havook.feature.mod.ModAttributeString;
import havook.feature.mod.ModCategoryEnum;
import net.minecraft.client.Minecraft;

public class ChatSpammer extends Mod {
	public transient ModAttributeString message = new ModAttributeString("Message","This spam message is powered by Aurora Client!");
	public ChatSpammer() {
		super("chatspammer", "Chatspammer", "Be a fricking jerk.", ModCategoryEnum.MISC);
		addAttrib(message);
	}

	@Override
	public void onLocalPlayerUpdate() {

		Minecraft.getMinecraft().player.sendChatMessage(message.value);

	}
}
