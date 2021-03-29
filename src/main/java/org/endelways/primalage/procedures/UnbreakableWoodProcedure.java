package org.endelways.primalage.procedures;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.endelways.primalage.PrimalageModElements;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.HashMap;

@PrimalageModElements.ModElement.Tag
public class UnbreakableWoodProcedure extends PrimalageModElements.ModElement {
	public UnbreakableWoodProcedure(PrimalageModElements instance) {
		super(instance, 6);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
	}

	@SubscribeEvent
    public void harvestCheck(PlayerEvent.BreakSpeed event)
    {
//        System.out.println(event);
        BlockState block = event.getState();
        ResourceLocation rl = block.getBlock().getTags().stream().filter((tag)->
		{
			return tag.toString().equals("minecraft:logs");
		}).findFirst().orElse(null);
		if(rl != null)
        {
            PlayerEntity player = event.getPlayer();
            ItemStack item = player.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            if (!(item.getItem() instanceof AxeItem))
            {
                event.setCanceled(true);
            }
        }
    }
}
