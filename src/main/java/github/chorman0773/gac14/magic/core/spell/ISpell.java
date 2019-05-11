package github.chorman0773.gac14.magic.core.spell;

import java.time.Duration;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface ISpell extends IForgeRegistryEntry<ISpell> {
	
	
	public ResourceLocation getSpellName();
	
	public float getSpeed();

	@Override
	default ISpell setRegistryName(ResourceLocation name) {
		
		throw new UnsupportedOperationException("setRegistryName is not allowed");
	}

	@Override
	default ResourceLocation getRegistryName() {
		// TODO Auto-generated method stub
		return getSpellName();
	}

	@Override
	default Class<ISpell> getRegistryType() {
		// TODO Auto-generated method stub
		return ISpell.class;
	}
	
	public SpellInstance CastSpell(ICaster caster, Duration chargeTime, boolean force) ;
	
	public void onSpellCast(SpellInstance instance);
	
	public void onSpellActivates(SpellInstance instance);
	
	public void onSpellAffects(SpellInstance instance, EntityLivingBase entity);
	
	public void onSpellAffects(SpellInstance instance, IBlockState state);

	public Duration getMaxLife();
	
	public double getManaCost();
	
	public Duration getCooldownTime();
	
	public Duration getWarmupTime();
	
	public int getBurnout();
	
	public ResourceLocation getType();
	
}
