
package org.endelways.primalage.itemgroup;

import org.endelways.primalage.item.HatchetItem;
import org.endelways.primalage.PrimalageModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@PrimalageModElements.ModElement.Tag
public class PrimalAgeItemGroup extends PrimalageModElements.ModElement {
	public PrimalAgeItemGroup(PrimalageModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabprimal_age") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(HatchetItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
