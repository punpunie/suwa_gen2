package io.github.punpunie.suwa;

import net.minecraft.client.gui.screen.Screen;

public class SuwaConfigViewmodelScreen extends Screen {
	public static final int BUTTON_ID_X = 0;
	public static final int BUTTON_ID_Y = 1;
	public static final int BUTTON_ID_Z = 2;
	public static final int BUTTON_ID_BACK = 3;

	@Override
	public void init() {
		super.init();
		this.buttons.clear();

		this.buttons.add(new OptionSliderWidgetButBetter(BUTTON_ID_X, this.width / 2 - 100, this.height / 4, "Viewmodel X", SuwaConfig.viewmodelX, -5, 5, false));
		this.buttons.add(new OptionSliderWidgetButBetter(BUTTON_ID_Y, this.width / 2 - 100, this.height / 4 + 48, "Viewmodel Y", SuwaConfig.viewmodelY, -5, 5, false));
		this.buttons.add(new OptionSliderWidgetButBetter(BUTTON_ID_Z, this.width / 2 - 100, this.height / 4 + 96, "Viewmodel Z", SuwaConfig.viewmodelZ, -5, 5, false));

		this.buttons.add(new OpenScreenButtonWidget(BUTTON_ID_BACK, this.width / 10, 15, 75, 20, "Back", new SuwaConfigScreen()));
	}

	@Override
	public void render(int mouseX, int mouseY, float tickDelta) {
		this.renderBackground();

		this.drawCenteredString(this.textRenderer, "suwa", this.width / 2, 20, 0xFFFFFF);

		super.render(mouseX, mouseY, tickDelta);
	}
}
