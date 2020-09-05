/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature;

import org.lwjgl.input.Keyboard;

import havook.util.ChatUtil;

public class Keybind {
	public int id;
	public int key;
	public String message;
	private transient Boolean active;

	public Keybind(int id, int key, String message) {
		this.id = id;
		this.key = key;
		this.message = message;
		active = false;
	}

	public void process() {
		if (active == false && Keyboard.isKeyDown(key)) {
			active = true;
			ChatUtil.sendChatMessage(message, false);
		} else if (!Keyboard.isKeyDown(key)) {
			active = false;
		}
	}
}
