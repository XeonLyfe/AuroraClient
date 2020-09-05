package havook.feature.mod.render;

import org.lwjgl.opengl.GL11;

import havook.Reference;
import havook.feature.Mod;
import havook.feature.mod.ModAttributeDouble;
import havook.feature.mod.ModCategoryEnum;
import havook.manager.ModManager;
import net.minecraft.client.Minecraft;
import java.awt.Color;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import havook.feature.mod.ModAttributeBoolean;

public class Watermark extends Mod {
	public Watermark() {
		super("watermark", "Aurora Client", "Shows a watermark in the corner of the screen.", ModCategoryEnum.RENDER);
		enabled = true; // overwritten when loading config (this enables the mod on first start)
	}

	@Override
	public void onRenderGameOverlay(RenderGameOverlayEvent event) {

	}
}
