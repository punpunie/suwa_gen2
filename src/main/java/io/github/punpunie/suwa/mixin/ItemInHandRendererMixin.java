package io.github.punpunie.suwa.mixin;

import io.github.punpunie.suwa.SuwaConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.ItemInHandRenderer;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemInHandRenderer.class)
public class ItemInHandRendererMixin {
	@Shadow private Minecraft minecraft;
	@Inject(method = "renderHand(F)V", at = @At("HEAD"))
	private void moveHand(float tickDelta, CallbackInfo ci) {
		float valX = SuwaConfig.viewmodelX.get();
		float valY = SuwaConfig.viewmodelY.get();
		float valZ = SuwaConfig.viewmodelZ.get();
		GL11.glTranslatef(valX, valY, valZ);
	}

}
