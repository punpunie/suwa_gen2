package io.github.punpunie.suwa.mixin;

import io.github.punpunie.suwa.SuwaConfig;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

	@Shadow private Minecraft minecraft;
	@Shadow private float oldFov;
	@Shadow private float newFov;
	@Shadow private float renderDistance;

	@Unique
	private float getModFov(float tickDelta) {
		float TEMP_FOV = SuwaConfig.fovValue.get();
		MobEntity mobEntity = this.minecraft.camera;

		if (mobEntity.isSubmergedIn(Material.WATER)) {
			TEMP_FOV -= 10F;
		}

		if (mobEntity.health <= 0) {
			float g = mobEntity.deathTicks + tickDelta;
			TEMP_FOV /= (1.0F - 500.0F / (g + 500.0F)) * 2.0F + 1.0F;
		}

		return TEMP_FOV + this.newFov + (this.oldFov - this.newFov) * tickDelta;
	}

	@Redirect(method = "setupCamera", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/GameRenderer;getFov(F)F"))
	private float getFov(GameRenderer instance, float tickDelta) {
		return this.getModFov(tickDelta);
	}
}
