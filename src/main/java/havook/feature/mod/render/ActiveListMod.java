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

public class ActiveListMod extends Mod {
	public transient ModAttributeDouble topMargin = new ModAttributeDouble("TopMargin", 0);
	public transient ModAttributeBoolean rainbow = new ModAttributeBoolean("Rainbow",false);
	public ActiveListMod() {
		super("activelist", "Active List", "Shows other active mods in upper-left corner of the screen.", ModCategoryEnum.RENDER);
		enabled = true; // overwritten when loading config (this enables the mod on first start)
		addAttrib(topMargin);
		addAttrib(rainbow);
	}

	@Override
	public void onRenderGameOverlay(RenderGameOverlayEvent event) {
		int color;
		if(rainbow.value == true) {

			float hue = (System.currentTimeMillis() % 1500) / 1500f;
			color = Color.HSBtoRGB(hue,1,1);

		} else {

			color = 0xFFFFFF;

		}


		if(event.getType() != ElementType.TEXT || Minecraft.getMinecraft().gameSettings.showDebugInfo)return;
		int i = 0;
		for(Mod mod : ModManager.MODS) {
			if(!mod.isEnabled() || mod.id == "activelist")continue;
			Minecraft.getMinecraft().fontRenderer.drawString(mod.name, 2, 2 + i++ * 10 + (int)(topMargin.value * 10), color);
		}
	}
}
