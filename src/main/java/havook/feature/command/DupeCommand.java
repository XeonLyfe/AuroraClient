/*******************************************************************************
 * Copyright � 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;

public class DupeCommand extends Command {
	ItemStack item = new ItemStack(Items.TOTEM_OF_UNDYING);
	public DupeCommand() {
		super("spawnitem", ".spawnitem", "Spawns an item.");
	}

	@Override
	public void execute(String[] args) {
		Minecraft.getMinecraft().playerController.sendPacketDropItem(item);;
	}
}
