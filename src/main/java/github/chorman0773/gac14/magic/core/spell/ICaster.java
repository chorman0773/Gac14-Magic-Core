package github.chorman0773.gac14.magic.core.spell;

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
	
	
	
	

}
