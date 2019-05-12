package github.chorman0773.gac14.magic.core.player;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import github.chorman0773.gac14.magic.core.spell.ICaster;
import github.chorman0773.gac14.magic.core.spell.ISpell;
import github.chorman0773.gac14.player.PlayerProfile;
import github.chorman0773.gac14.util.Comparators;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.INBTSerializable;

public class PlayerCasterObject implements ICaster, INBTSerializable<NBTTagCompound>, Runnable {
	
	private static final Comparator<ISpell> compareSpells = Comparator.comparing(s->s.getSpellName(), Comparators.stringOrder);
	
	private PlayerProfile prof;
	private double mana;
	private Set<ISpell> spells = new TreeSet<>(compareSpells);
	private ISpell active;
	private ISpell last;
	private Duration totalChargeTime;
	private boolean charging;
	private Instant chargeStart;
	private Map<ISpell,Instant> spellCooldownTimes = new TreeMap<>(compareSpells);
	
	private double manaCharge;
	private Instant lastTickTime;
	
	public PlayerCasterObject(PlayerProfile prof) {
		this.prof = prof;
	}

	@Override
	public ResourceLocation getProvider() {
		// TODO Auto-generated method stub
		return ResourceLocation.makeResourceLocation("gac14:magic/player");
	}

	@Override
	public double getMana() {
		// TODO Auto-generated method stub
		return mana;
	}

	@Override
	public double getManaCap() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vec3d getPos() {
		// TODO Auto-generated method stub
		return prof.getPlayer().getPositionVector();
	}

	@Override
	public BlockPos getBlockPos() {
		// TODO Auto-generated method stub
		return prof.getPlayer().getPosition();
	}

	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return prof.getPlayer().getEntityWorld();
	}

	@Override
	public Vec2f getFacing() {
		// TODO Auto-generated method stub
		return prof.getPlayer().getPitchYaw();
	}

	@Override
	public double getResistenceByType(ResourceLocation type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDamMul() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getResistence() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<ISpell> getSpells() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Duration getRemainingTimeFor(ISpell spell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canCast(ISpell spell) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkCast(ISpell spell) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doCast(ISpell spell) {
		// TODO Auto-generated method stub

	}

	@Override
	public NBTTagCompound serializeNBT() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
