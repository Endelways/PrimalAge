
package org.endelways.primalage.item;

import org.endelways.primalage.itemgroup.PrimalAgeItemGroup;
import org.endelways.primalage.PrimalageModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@PrimalageModElements.ModElement.Tag
public class ClayBucketItem extends PrimalageModElements.ModElement {
	@ObjectHolder("primalage:clay_bucket")
	public static final Item block = null;
	public ClayBucketItem(PrimalageModElements instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PrimalAgeItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("clay_bucket");
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
