
package org.endelways.primalage.item;

import org.endelways.primalage.itemgroup.PrimalAgeItemGroup;
import org.endelways.primalage.PrimalageModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

@PrimalageModElements.ModElement.Tag
public class HatchetItem extends PrimalageModElements.ModElement {
	@ObjectHolder("primalage:hatchet")
	public static final Item block = null;
	public HatchetItem(PrimalageModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 20;
			}

			public float getEfficiency() {
				return 1f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3.5f, new Item.Properties().group(PrimalAgeItemGroup.tab)) {
		}.setRegistryName("hatchet"));
	}
}
