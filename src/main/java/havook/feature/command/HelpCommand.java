/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.command;

import havook.feature.Command;
import havook.manager.CommandManager;
import havook.util.ChatUtil;

public class HelpCommand extends Command {
	public HelpCommand() {
		super("help", ".help [command]", "Displays all available havook commands and their syntax.");
	}

	@Override
	public void execute(String[] args) {
		if (args.length < 1) {
			ChatUtil.info("\2473\247l--------------------------------");
			ChatUtil.info("\247lAll available commands:");
			ChatUtil.info("");
			for (Command command : CommandManager.COMMANDS) {
				ChatUtil.info("\247c." + command.name);
			}
			ChatUtil.info("\2473\247l--------------------------------");
			return;
		}
		if (args.length > 1) {
			ChatUtil.warning("Too many arguments.");
		}

		for (Command command : CommandManager.COMMANDS) {
			if (args[0].equalsIgnoreCase(command.name)) {
				ChatUtil.syntax(command.syntax);
				ChatUtil.info("\247lDESCRIPTION: \247e" + command.description);
				return;
			}
		}
		ChatUtil.error("There's no such command with name \2477" + args[0]
				+ "\247c. Type .havook help to list all available commands.");
	}
}
