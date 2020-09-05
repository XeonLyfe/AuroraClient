package havook.handler;

import havook.feature.Mod;
import havook.manager.ModManager;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderLivingEventHandler {
	@SubscribeEvent
	public void onRenderLivingSpecialsPre(RenderLivingEvent.Specials.Pre event) {
		for (Mod mod : ModManager.MODS) {
			if (mod.isEnabled()) {
				mod.onRenderLivingSpecialsPre(event);
			}
		}
	}
}
