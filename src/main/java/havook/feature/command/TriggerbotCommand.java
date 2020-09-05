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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;

public class TriggerbotCommand extends Command {
    public TriggerbotCommand() {
        super("triggerbot", ".triggerbot", "Enable Triggerbot Easily");
    }

    @Override
    public void execute(String[] args) {
        havook.manager.ModManager.MODS.get(17).setEnabled(true);
    }
}
