/*******************************************************************************
 * Copyright � 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.manager;

import java.util.ArrayList;
import java.util.List;

import havook.feature.Command;
import havook.feature.command.AuthorCommand;
import havook.feature.command.BindCommand;
import havook.feature.command.ClearChatCommand;
import havook.feature.command.CopyDataCommand;
import havook.feature.command.CopyItemCommand;
import havook.feature.command.DupeCommand;
import havook.feature.command.ForwardCommand;
import havook.feature.command.FriendCommand;
import havook.feature.command.GiveCommand;
import havook.feature.command.GuiCommand;
import havook.feature.command.HatCommand;
import havook.feature.command.HeadCommand;
import havook.feature.command.HelpCommand;
import havook.feature.command.LoreCommand;
import havook.feature.command.ModCommand;
import havook.feature.command.NbtCommand;
import havook.feature.command.PanicCommand;
import havook.feature.command.RenameCommand;
import havook.feature.command.RepairCommand;
import havook.feature.command.SayCommand;
import havook.feature.command.TpCommand;
import havook.feature.command.TriggerbotCommand;

public class CommandManager {
	public static List<Command> COMMANDS = new ArrayList<Command>();

	public static void loadCommands() {
		COMMANDS.add(new AuthorCommand());
		COMMANDS.add(new BindCommand());
		COMMANDS.add(new ClearChatCommand());
		COMMANDS.add(new CopyDataCommand());
		COMMANDS.add(new CopyItemCommand());
		COMMANDS.add(new ForwardCommand());
		COMMANDS.add(new FriendCommand());
		COMMANDS.add(new GiveCommand());
		COMMANDS.add(new GuiCommand());
		COMMANDS.add(new HatCommand());
		COMMANDS.add(new HeadCommand());
		COMMANDS.add(new HelpCommand());
		COMMANDS.add(new LoreCommand());
		COMMANDS.add(new ModCommand());
		COMMANDS.add(new NbtCommand());
		COMMANDS.add(new PanicCommand());
		COMMANDS.add(new RenameCommand());
		COMMANDS.add(new RepairCommand());
		COMMANDS.add(new SayCommand());
		COMMANDS.add(new TpCommand());
		COMMANDS.add(new TriggerbotCommand());
	}
}
