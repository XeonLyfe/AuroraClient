/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.command;

import havook.feature.Command;
import havook.gui.LongMessageSenderGui;
import havook.gui.MainMenuGui;
import havook.handler.ClientTickHandler;
import havook.util.ChatUtil;

public class GuiCommand extends Command {

	public GuiCommand() {
		super("gui", ".gui", "Opens graphical interface. This command is binded to RSHIFT key by default.");
	}

	@Override
	public void execute(String[] args) {
		if (args.length > 0) {
			ChatUtil.warning("Too many arguments.");
		}
		ClientTickHandler.queueGui(new MainMenuGui());
	}

}
