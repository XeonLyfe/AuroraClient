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
import havook.util.InventoryUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class RenameCommand extends Command {
	public RenameCommand() {
		super("rename", ".rename <name>", "Changes held item's name.");
	}

	@Override
	public void execute(String[] args) {
		if (args.length < 1) {
			ChatUtil.error("Invalid syntax.");
			ChatUtil.syntax(syntax);
			return;
		}
		ItemStack stack = Minecraft.getMinecraft().player.inventory.getCurrentItem();
		if (stack.isEmpty()) {
			ChatUtil.error("You must hold an item in your hand.");
			return;
		}
		String name = args[0];
		for (int i = 1; i < args.length; i++) {
			name += " " + args[i];
		}
		name = name.replace('&', '\247').replace("\247\247", "&");
		if (!Minecraft.getMinecraft().player.isCreative()) {
			ChatUtil.warning("You must be in creative mode!");
		}
		stack.setStackDisplayName(name);
		InventoryUtil.updateSlot(36 + Minecraft.getMinecraft().player.inventory.currentItem, stack);
		ChatUtil.info("Item's name changed to \2477" + name + "\247e.");
	}
}
