package github.chorman0773.gac14.magic.core.spell;

import java.time.Duration;
import java.time.Instant;

import github.chorman0773.gac14.magic.core.event.SpellEvent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.MinecraftForge;

public final class SpellInstance implements Runnable {
	
	private final ISpell spell;
	
	private final ICaster caster;
	
	private final Duration chargeTime;
	
	private boolean isLoaded;
	
	private boolean isUpdating;
	
	private Vec3d pos;
	
	private Vec3d motion;
	
	private Instant creationTime;
	
	private Vec3d initial;

	private int phase;
	

	public SpellInstance(ISpell spell, ICaster caster, Duration chargeTime) {
		
		this.spell = spell;
		this.caster = caster;
		this.chargeTime = chargeTime;
		isLoaded = true;
		isUpdating = true;
		creationTime = Instant.now();
		initial = pos = caster.getPos();
		
		Vec2f facing = caster.getFacing();
		
		double xzLen = Math.cos(facing.y);
		float spellSpeed = spell.getSpeed();
		
		motion = new Vec3d(spellSpeed * xzLen * Math.cos(facing.x), spellSpeed * Math.sin(facing.y), spellSpeed * xzLen * Math.sin(-facing.x));
		
	}
	
	public boolean Cast() {
		
		if(MinecraftForge.EVENT_BUS.post(new SpellEvent.Cast(this))) {
			
			spell.onSpellCast(this);
			phase = 1;
			return true;
		}
		phase = -1;
		return false;
	}
	
	
	public boolean Activates() {
		
		if(MinecraftForge.EVENT_BUS.post(new SpellEvent.Activates(this))) {
			
			spell.onSpellActivates(this);
			phase = 2;
			return true;
		}
		phase = -1;
		return false;	
	}

	@Override
	public void run() {
		
		pos = pos.add(motion);
		if(phase == 1 && Instant.now().isAfter(creationTime.plus(spell.getMaxLife()))){
			Activates();
		}
		
	}
	
	public void Affect(IBlockState state) {
		
		MinecraftForge.EVENT_BUS.post(new SpellEvent.AffectsBlock(this, state));
		spell.onSpellAffects(this, state);
		
		
	}
	
	public void Affect(EntityLivingBase entity) {
		
		MinecraftForge.EVENT_BUS.post(new SpellEvent.AffectsEntity(this, entity));
		spell.onSpellAffects(this, entity);
		
		
	}
}
