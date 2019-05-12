package github.chorman0773.gac14.magic.core.player;

import java.util.List;

import github.chorman0773.gac14.magic.core.spell.ISpell;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface IClass extends IForgeRegistryEntry<IClass> {
	public ResourceLocation getClassName();
	
	public ITextComponent getDisplayName();
	
	public double getLevelingRate();
	
	public List<ISpell> getSpellsAtLevel(int level);
	
	@Override
	default IClass setRegistryName(ResourceLocation name) {
		throw new UnsupportedOperationException("setRegistryName: Operation not Permitted");
	}

	@Override
	default ResourceLocation getRegistryName() {
		return getClassName();
	}

	@Override
	default Class<IClass> getRegistryType() {
		// TODO Auto-generated method stub
		return IClass.class;
	}
}
