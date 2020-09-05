/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.command;

import havook.feature.Command;
import havook.util.ChatUtil;

public class ClearChatCommand extends Command {
	public ClearChatCommand() {
		super("clearchat", ".clearchat", "Clears the chat completely.");
	}

	@Override
	public void execute(String[] args) {
		if (args.length > 0) {
			ChatUtil.warning("Too many arguments.");
		}
		ChatUtil.clear(256);
	}
}
