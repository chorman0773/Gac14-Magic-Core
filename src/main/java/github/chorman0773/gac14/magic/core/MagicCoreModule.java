package github.chorman0773.gac14.magic.core;

import github.chorman0773.gac14.Gac14Module;
import github.chorman0773.gac14.Version;
import net.minecraft.util.ResourceLocation;

public class MagicCoreModule extends Gac14Module<MagicCoreModule> {

	public MagicCoreModule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResourceLocation getModuleName() {
		// TODO Auto-generated method stub
		return ResourceLocation.makeResourceLocation("gac14:magic/core");
	}

	@Override
	public Version getModuleVersion() {
		// TODO Auto-generated method stub
		return new Version("1.0");
	}

}
