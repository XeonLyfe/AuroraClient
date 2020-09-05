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

public class HeadCommand extends Command {
	public HeadCommand() {
		super("head", ".head <player>", "Sets the owner of the head you are holding or creates new one.");
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
		if (args.length > 1) {
			ChatUtil.warning("Too many arguments.");
		}
		ItemStack stack = Minecraft.getMinecraft().player.inventory.getCurrentItem();
		if (!stack.isEmpty() && Item.getIdFromItem(stack.getItem()) == 397 && stack.getMetadata() == 3) {
			stack.setTagInfo("SkullOwner", new NBTTagString(args[0]));
			InventoryUtil.updateSlot(36 + Minecraft.getMinecraft().player.inventory.currentItem, stack);
			ChatUtil.info("Head's owner changed to \2477" + args[0] + "\247e.");
			return;
		}
		ItemStack newStack = new ItemStack(new Item().getItemById(397), 1, 3);
		newStack.setTagInfo("SkullOwner", new NBTTagString(args[0]));
		InventoryUtil.updateFirstEmptySlot(newStack);
		ChatUtil.info("Given head of player \2477" + args[0] + "\247e to \2477"
				+ Minecraft.getMinecraft().player.getName() + "\247e.");
		return;
	}
}
