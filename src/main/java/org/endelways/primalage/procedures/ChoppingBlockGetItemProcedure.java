package org.endelways.primalage.procedures;

import org.endelways.primalage.block.ChoppingBlockBlock;
import org.endelways.primalage.PrimalageModElements;
import org.endelways.primalage.PrimalageMod;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@PrimalageModElements.ModElement.Tag
public class ChoppingBlockGetItemProcedure extends PrimalageModElements.ModElement {
	public ChoppingBlockGetItemProcedure(PrimalageModElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PrimalageMod.LOGGER.warn("Failed to load dependency entity for procedure ChoppingBlockGetItem!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PrimalageMod.LOGGER.warn("Failed to load dependency x for procedure ChoppingBlockGetItem!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PrimalageMod.LOGGER.warn("Failed to load dependency y for procedure ChoppingBlockGetItem!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PrimalageMod.LOGGER.warn("Failed to load dependency z for procedure ChoppingBlockGetItem!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PrimalageMod.LOGGER.warn("Failed to load dependency world for procedure ChoppingBlockGetItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ChoppingBlockBlock.block.getDefaultState().getBlock())) {
			if (((new Object() {
				public int getAmount(IWorld world, BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (0))) == 1)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = (new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (0);
						final int _amount = (int) 1;
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								ItemStack _stk = capability.getStackInSlot(_sltid).copy();
								_stk.shrink(_amount);
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
							}
						});
					}
				}
			}
		}
	}
}
