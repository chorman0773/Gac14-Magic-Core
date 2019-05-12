package github.chorman0773.gac14.magic.core.spell;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public interface ICaster {
	
	public ResourceLocation getProvider();
				
	public double getMana();
		
	public double getManaCap();
	
	public Vec3d getPos();

	public BlockPos getBlockPos();
	
	public World getWorld();
	
	public Vec2f getFacing();
	
	public double getResistenceByType(ResourceLocation type);
	
	public double getDamMul();
	
	public double getResistence();
	
	public Set<ISpell> getSpells();
	
	public Duration getRemainingTimeFor(ISpell spell);
	
	public boolean canCast(ISpell spell);
	
	public boolean checkCast(ISpell spell);
	
	public void doCast(ISpell spell);
}
