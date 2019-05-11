package github.chorman0773.gac14.magic.core.spell;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

@EventBusSubscriber
public final class SpellRegistry {

	private SpellRegistry() {
		
		
	}
	
	@SubscribeEvent
	public static void createRegistry(RegistryEvent.NewRegistry r) {}
	
	
	public static final IForgeRegistry<ISpell> SpellRegistry;
	
	static{
		
		SpellRegistry = new RegistryBuilder<ISpell>()
				.setType(ISpell.class)
				.create();
		
	
	
	}
}
