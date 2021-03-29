package org.endelways.primalage.procedures;

import org.endelways.primalage.item.FIBERItem;
import org.endelways.primalage.PrimalageModElements;
import org.endelways.primalage.PrimalageMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import java.util.Map;

@PrimalageModElements.ModElement.Tag
public class GetFiberFromGrassProcedure extends PrimalageModElements.ModElement {
	public GetFiberFromGrassProcedure(PrimalageModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PrimalageMod.LOGGER.warn("Failed to load dependency x for procedure GetFiberFromGrass!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PrimalageMod.LOGGER.warn("Failed to load dependency y for procedure GetFiberFromGrass!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PrimalageMod.LOGGER.warn("Failed to load dependency z for procedure GetFiberFromGrass!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PrimalageMod.LOGGER.warn("Failed to load dependency world for procedure GetFiberFromGrass!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double randomDrop = 0;
		randomDrop = (double) Math.random();
		if (((randomDrop) >= 0.5)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(FIBERItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 0.5);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
