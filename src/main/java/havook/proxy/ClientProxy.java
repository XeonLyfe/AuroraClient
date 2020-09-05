/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.proxy;

import havook.handler.ChatHandler;
import havook.handler.ClientTickHandler;
import havook.handler.KeyInputHandler;
import havook.handler.MouseInputHandler;
import havook.handler.PlaySoundHandler;
import havook.handler.PlayerTickHandler;
import havook.handler.RenderGameOverlayHandler;
import havook.handler.RenderLivingEventHandler;
import havook.handler.RenderWorldLastHandler;
import havook.manager.CommandManager;
import havook.manager.ConfigManager;
import havook.manager.FriendManager;
import havook.manager.KeybindManager;
import havook.manager.ModManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		if (event.getSide() == Side.CLIENT) {
			ConfigManager.loadConfig();

			CommandManager.loadCommands();
			FriendManager.loadFriends();
			KeybindManager.loadKeybinds();
			ModManager.loadMods();
		}
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		if (event.getSide() == Side.CLIENT) {
			MinecraftForge.EVENT_BUS.register(new ChatHandler());
			MinecraftForge.EVENT_BUS.register(new ClientTickHandler());
			MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
			MinecraftForge.EVENT_BUS.register(new MouseInputHandler());
			MinecraftForge.EVENT_BUS.register(new PlayerTickHandler());
			MinecraftForge.EVENT_BUS.register(new PlaySoundHandler());
			MinecraftForge.EVENT_BUS.register(new RenderWorldLastHandler());
			MinecraftForge.EVENT_BUS.register(new RenderGameOverlayHandler());
			MinecraftForge.EVENT_BUS.register(new RenderLivingEventHandler());
		}
	}

	@Override
	public void serverStarting(FMLServerStartingEvent event) {
		super.serverStarting(event);
	}

	@Override
	public void serverStopping(FMLServerStoppingEvent event) {
		super.serverStopping(event);
	}
}
