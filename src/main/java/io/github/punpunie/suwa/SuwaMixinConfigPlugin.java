package io.github.punpunie.suwa;

import net.ornithemc.osl.config.api.ConfigManager;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class SuwaMixinConfigPlugin implements IMixinConfigPlugin {

	public static SuwaConfig CONFIG = new SuwaConfig();

	@Override
	public void onLoad(String s) {
		ConfigManager.register(CONFIG);
	}


	@Override
	public boolean shouldApplyMixin(String s, String s1) {
		return true;
	}

	// empty
	@Override public String getRefMapperConfig() { return null; }
	@Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
	@Override public List<String> getMixins() { return null; }
	@Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
	@Override public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
