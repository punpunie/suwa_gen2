package io.github.punpunie.suwa;

import io.github.punpunie.suwa.mixin.GameRendererMixin;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.ornithemc.osl.config.api.ConfigManager;
import net.ornithemc.osl.config.api.config.option.FloatOption;
import org.lwjgl.opengl.GL11;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class OptionSliderWidgetButBetter extends ButtonWidget {
	public float value = 0.0F;
	public FloatOption floatOption;
	public boolean dragging = false;
	public String name;
	public float minVal;
	public float maxVal;
	public boolean round;

	DecimalFormat df = new DecimalFormat("#.##");

	public OptionSliderWidgetButBetter(int id, int x, int y, String message, FloatOption value, float minVal, float maxVal, boolean round) {
		super(id, x, y, 200, 20, message);
		this.value = value.get();
		this.floatOption = value;
		this.name = message;
		this.minVal = minVal;
		this.maxVal = maxVal;
		this.round = round;
		df.setRoundingMode(RoundingMode.DOWN);
	}

	protected int getYImage(boolean hovered) {
		return 0;
	}

	protected void renderBackground(Minecraft minecraft, int mouseX, int mouseY) {
		if (this.visible) {
			if (this.dragging) {
				float sliderPos = (float)(mouseX - (this.x + 4)) / (float)(this.width - 8);

				// clamp
				sliderPos = Math.max(0.0F, Math.min(1.0F, sliderPos));

				// map slider to values
				this.value = minVal + (sliderPos * (maxVal - minVal));

				floatOption.set(value);
			}

			if(round) this.message = name + ": " + (int)this.value;
			if(!round) this.message = name + ": " + df.format(this.value);
			float visualPos = (this.value - minVal) / (maxVal - minVal);

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.drawTexture(this.x + (int)(visualPos * (float)(this.width - 8)), this.y, 0, 66, 4, 20);
			this.drawTexture(this.x + (int)(visualPos * (float)(this.width - 8)) + 4, this.y, 196, 66, 4, 20);
		}
	}

	public boolean mouseClicked(Minecraft minecraft, int mouseX, int mouseY) {
		if (super.mouseClicked(minecraft, mouseX, mouseY)) {
			float sliderPos = (float)(mouseX - (this.x + 4)) / (float)(this.width - 8);

			// clamp
			sliderPos = Math.max(0.0F, Math.min(1.0F, sliderPos));

			// map slider to values
			this.value = minVal + (sliderPos * (maxVal - minVal));

			floatOption.set(this.value);
			if(round) this.message = name + ": " + (int)this.value;
			if(!round) this.message = name + ": " + df.format(this.value);
			this.dragging = true;
			return true;
		} else {
			return false;
		}
	}

	public void mouseReleased(int mouseX, int mouseY) {
		this.dragging = false;
	}
}
