package github.chorman0773.gac14.magic.core.player;

import java.util.List;

import github.chorman0773.gac14.magic.core.spell.ICaster;
import github.chorman0773.gac14.magic.core.spell.ISpell;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface ISpecies extends IForgeRegistryEntry<ISpecies> {
	public ResourceLocation getSpeciesName();
	public ITextComponent getDisplayName();
	
	public List<ISpell> getSpellsAtLevel(int level);
	
	public void applyPassiveEffects(ICaster caster);
	
	public double getBaseRegen();
	
	public double getManaCap();
	
	//TODO Add Remainder of the Species Methods
	
	@Override
	default ISpecies setRegistryName(ResourceLocation name) {
		throw new UnsupportedOperationException("setRegistryName: Operation not allowed");
	}
	@Override
	default ResourceLocation getRegistryName() {
		// TODO Auto-generated method stub
		return getSpeciesName();
	}
	@Override
	default Class<ISpecies> getRegistryType() {
		// TODO Auto-generated method stub
		return ISpecies.class;
	}
}
