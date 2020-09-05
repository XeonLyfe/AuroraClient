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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagString;

public class AuthorCommand extends Command {
	public AuthorCommand() {
		super("author", ".author <author>", "Changes held book's author.");
	}

	@Override
	public void execute(String[] args) {
		if (!Minecraft.getMinecraft().player.isCreative()) {
			ChatUtil.warning("You must be in creative mode.");
		}
		if (args.length < 1) {
			ChatUtil.error("Invalid syntax.");
			ChatUtil.syntax(syntax);
			return;
		}
		ItemStack stack = Minecraft.getMinecraft().player.inventory.getCurrentItem();
		if (stack.isEmpty() || Item.getIdFromItem(stack.getItem()) != 387) {
			ChatUtil.error("You must hold a written book in your hand.");
			return;
		}
		String author = args[0];
		for (int i = 1; i < args.length; i++) {
			author += " " + args[i];
		}
		author = author.replace('&', '\247').replace("\247\247", "&");
		stack.setTagInfo("author", new NBTTagString(author));
		InventoryUtil.updateSlot(36 + Minecraft.getMinecraft().player.inventory.currentItem, stack);
		ChatUtil.info("Book's author changed to \2477" + author + "\247e.");
	}
}
