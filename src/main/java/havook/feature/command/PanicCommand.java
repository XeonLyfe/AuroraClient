/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.command;

import havook.feature.Command;
import havook.feature.Mod;
import havook.manager.ModManager;
import havook.util.ChatUtil;

public class PanicCommand extends Command {
	public PanicCommand() {
		super("panic", ".panic", "Disables all mods.");
	}

	@Override
	public void execute(String[] args) {
		for (Mod mod : ModManager.MODS) {
			if(mod.id == "activelist")continue;
			mod.setEnabled(false);
		}
	}
}
