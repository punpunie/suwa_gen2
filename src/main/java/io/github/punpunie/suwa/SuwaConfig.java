package io.github.punpunie.suwa;

import net.ornithemc.osl.config.api.ConfigScope;
import net.ornithemc.osl.config.api.LoadingPhase;
import net.ornithemc.osl.config.api.config.BaseConfig;
import net.ornithemc.osl.config.api.config.option.FloatOption;
import net.ornithemc.osl.config.api.serdes.FileSerializerType;
import net.ornithemc.osl.config.api.serdes.SerializerTypes;

import java.util.function.Predicate;


public class SuwaConfig extends BaseConfig {

	static Predicate<Float> isBetween180 = val -> val >= 0 && val <= 180;
	static Predicate<Float> isBetweenm5v5 = val -> val >= -5 && val <= 5;

	public static final FloatOption fovValue = new FloatOption("FOV", "Field of View", 40F, isBetween180);
	public static final FloatOption viewmodelX = new FloatOption("viewX", "Viewmodel X", 0F, isBetweenm5v5);
	public static final FloatOption viewmodelY = new FloatOption("viewY", "Viewmodel Y", 0F, isBetweenm5v5);
	public static final FloatOption viewmodelZ = new FloatOption("viewZ", "Viewmodel Z", 0F, isBetweenm5v5);

	@Override
	public String getNamespace() {
		return "io/github/punpunie/suwa";
	}

	@Override
	public String getName() {
		return "io/github/punpunie/suwa";
	}

	@Override
	public String getSaveName() {
		return "suwa-config.json";
	}

	@Override
	public ConfigScope getScope() {
		return ConfigScope.GLOBAL;
	}

	@Override
	public LoadingPhase getLoadingPhase() {
		return LoadingPhase.START;
	}

	@Override
	public FileSerializerType<?> getType() {
		return SerializerTypes.JSON;
	}

	@Override
	public int getVersion() {
		return 0;
	}

	@Override
	public void init() {
		registerOptions("suwaGroup", fovValue, viewmodelX, viewmodelY, viewmodelZ);
	}
}
