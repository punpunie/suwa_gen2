package io.github.punpunie.suwa;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;

public class OpenScreenButtonWidget extends ButtonWidget
{
	Screen screen;
	public OpenScreenButtonWidget(int id, int x, int y, String message) {
		super(id, x, y, message);
	}

	public OpenScreenButtonWidget(int id, int x, int y, int width, int height, String message, Screen screen) {
		super(id, x, y, width, height, message);
		this.screen = screen;
	}

	@Override
	public boolean mouseClicked(Minecraft minecraft, int mouseX, int mouseY) {
		if(super.mouseClicked(minecraft, mouseX, mouseY)) {
			minecraft.openScreen(screen);
			return true;
		}
		return false;
	}
}
