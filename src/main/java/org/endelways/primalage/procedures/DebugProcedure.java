package org.endelways.primalage.procedures;

import org.endelways.primalage.PrimalageModElements;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Map;
import java.util.HashMap;

@PrimalageModElements.ModElement.Tag
public class DebugProcedure extends PrimalageModElements.ModElement {
	public DebugProcedure(PrimalageModElements instance) {
		super(instance, 10);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
	}

	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
//		PlayerEntity entity = event.getPlayer();
//		if (event.getHand() != entity.getActiveHand()) {
//			return;
//		}
//		double i = event.getPos().getX();
//		double j = event.getPos().getY();
//		double k = event.getPos().getZ();
//		IWorld world = event.getWorld();
//		Map<String, Object> dependencies = new HashMap<>();
//		dependencies.put("x", i);
//		dependencies.put("y", j);
//		dependencies.put("z", k);
//		dependencies.put("world", world);
//		dependencies.put("entity", entity);
//		dependencies.put("event", event);
//		this.executeProcedure(dependencies);
		System.out.println(event.getItemStack().getItem().getTags().toString());
	}

}
