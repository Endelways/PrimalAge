
package org.endelways.primalage.item;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.util.NonNullList;
import net.minecraftforge.registries.ForgeRegistries;
import org.endelways.primalage.api.PrimalTags;
import org.endelways.primalage.itemgroup.PrimalAgeItemGroup;
import org.endelways.primalage.PrimalageModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.block.BlockState;

import java.util.Objects;

@PrimalageModElements.ModElement.Tag
public class BurntBucketItem extends PrimalageModElements.ModElement {
	@ObjectHolder("primalage:burnt_bucket")
	public static final Item block = null;
	public BurntBucketItem(PrimalageModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom(Fluids.EMPTY, "burnt_bucket"));
	}
	public static class ItemCustom extends BucketItem {
		private static final String TAG_FLUID = "fluid";
		public ItemCustom(Fluid fluid, String name) {
			super(fluid, new Item.Properties().group(PrimalAgeItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName(name);
		}
		@Override
		public void fillItemGroup(ItemGroup tab, NonNullList<ItemStack> subItems) {
				for(Fluid fluid : ForgeRegistries.FLUIDS.getValues()) {
					// skip flowing fluids (we have still) and milks
					// include cracked if cracked, non-cracked if not cracked
						subItems.add(setFluid(new ItemStack(this), fluid));
				}
		}

		protected static ItemStack setFluid(ItemStack stack, Fluid fluid) {
			stack.getOrCreateTag().putString(TAG_FLUID, Objects.requireNonNull(fluid.getRegistryName()).toString());
			return stack;
		}
		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
