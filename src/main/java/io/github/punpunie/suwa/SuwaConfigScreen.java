package io.github.punpunie.suwa;

import com.terraformersmc.modmenu.gui.ModsScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;

@Environment(EnvType.CLIENT)
public class SuwaConfigScreen extends Screen {

	public static final int BUTTON_ID_FOV = 0;
	public static final int BUTTON_ID_VIEWMODEL = 1;
	public static final int BUTTON_ID_BACK = 2;

	@Override
	public void init() {
		super.init();
		this.buttons.clear();

		this.buttons.add(new OptionSliderWidgetButBetter(BUTTON_ID_FOV, this.width / 2 - 100, this.height / 4 + 48, "FOV", SuwaConfig.fovValue, 1, 180, true));
		this.buttons.add(new OpenScreenButtonWidget(BUTTON_ID_VIEWMODEL, this.width / 2 - 50, this.height / 4 + 96, 100, 20, "Viewmodel Options", new SuwaConfigViewmodelScreen()));
		this.buttons.add(new OpenScreenButtonWidget(BUTTON_ID_BACK, this.width / 10, 15, 75, 20, "Back", new ModsScreen(null)));
	}

	@Override
	public void render(int mouseX, int mouseY, float tickDelta) {
		this.renderBackground();

		this.drawCenteredString(this.textRenderer, "suwa", this.width / 2, 20, 0xFFFFFF);

		super.render(mouseX, mouseY, tickDelta);
	}
}
