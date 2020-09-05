package havook.handler;

import havook.feature.Mod;
import havook.manager.ModManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderGameOverlayHandler {
	@SubscribeEvent
	public void onRenderGameOverlay(RenderGameOverlayEvent event) {
		for (Mod mod : ModManager.MODS) {
			if (mod.isEnabled()) {
				mod.onRenderGameOverlay(event);
			}
		}
	}
}
