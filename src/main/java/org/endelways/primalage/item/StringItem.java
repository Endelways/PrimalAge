
package org.endelways.primalage.item;

import org.endelways.primalage.itemgroup.PrimalAgeItemGroup;
import org.endelways.primalage.PrimalageModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@PrimalageModElements.ModElement.Tag
public class StringItem extends PrimalageModElements.ModElement {
	@ObjectHolder("primalage:string")
	public static final Item block = null;
	public StringItem(PrimalageModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PrimalAgeItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("string");
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
