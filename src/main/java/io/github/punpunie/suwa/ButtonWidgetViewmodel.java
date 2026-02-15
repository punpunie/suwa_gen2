package io.github.punpunie.suwa;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.ButtonWidget;

public class ButtonWidgetViewmodel extends ButtonWidget
{
	public ButtonWidgetViewmodel(int id, int x, int y, String message) {
		super(id, x, y, message);
	}

	public ButtonWidgetViewmodel(int id, int x, int y, int width, int height, String message) {
		super(id, x, y, width, height, message);
	}

	@Override
	public boolean mouseClicked(Minecraft minecraft, int mouseX, int mouseY) {
		if(super.mouseClicked(minecraft, mouseX, mouseY)) {
			minecraft.openScreen(new SuwaConfigViewmodelScreen());
			return true;
		}
		return false;
	}
}
