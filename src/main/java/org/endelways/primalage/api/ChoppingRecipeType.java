package org.endelways.primalage.api;

import net.minecraft.item.crafting.IRecipeType;

    public class ChoppingRecipeType implements IRecipeType<ChoppingRecipe> {

        @Override
        public String toString () {
            return "primalage:chopping";
        }
}
