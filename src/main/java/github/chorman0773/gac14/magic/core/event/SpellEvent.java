package github.chorman0773.gac14.magic.core.event;

import github.chorman0773.gac14.magic.core.spell.SpellInstance;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

public abstract class SpellEvent extends Event {

	
	public final SpellInstance instance;
	
	public SpellEvent(SpellInstance instance) {
		
		this.instance = instance;
		
	}
	
	@Cancelable
	public static final class Cast extends SpellEvent {

		public Cast(SpellInstance instance) {
			super(instance);
			
		}
		
	}
	
	@Cancelable
	public static final class Activates extends SpellEvent{

		public Activates(SpellInstance instance) {
			super(instance);
			
		}
		
	}
	
	
	public static final class AffectsBlock extends SpellEvent{
		
		public final IBlockState state;
		
		public AffectsBlock(SpellInstance instance, IBlockState state) {
			super(instance);
			this.state = state;
		}
		
	}
	
	public static final class AffectsEntity extends SpellEvent{

		public final EntityLivingBase entity;
		
		public AffectsEntity(SpellInstance instance, EntityLivingBase entity) {
			super(instance);
			this.entity = entity;
		}
		
		
	}
	
	
}
