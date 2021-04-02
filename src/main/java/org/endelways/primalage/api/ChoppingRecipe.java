package org.endelways.primalage.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.endelways.primalage.PrimalageMod;

public class ChoppingRecipe implements IRecipe<IInventory> {

    public static final Serializer SERIALIZER = new Serializer();
    private ItemStack output;
    private ResourceLocation block;
    private ResourceLocation id;
    public ResourceLocation getBlock()
    {
        return block;
    }
    public ChoppingRecipe(ResourceLocation id, ItemStack output, ResourceLocation block) {

        this.id = id;
        this.output = output;
        this.block = block;

        // This output is not required, but it can be used to detect when a recipe has been
        // loaded into the game.
        System.out.println("Loaded " + this.toString());
    }

    @Override
    public String toString () {

        // Overriding toString is not required, it's just useful for debugging.
        return "ChoppingRecipe [output=" + this.output + ", item=" + this.block + ", id=" + this.id + "]";
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return false;
    }

    @Override
    public ItemStack getCraftingResult (IInventory inv) {

        // This method is ignored by our custom recipe system. getRecipeOutput().copy() is used
        // instead.
        return this.output.copy();
    }

    @Override
    public boolean canFit(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getRecipeOutput () {

        return this.output;
    }

    @Override
    public ResourceLocation getId () {

        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer () {

        return SERIALIZER;
    }

    @Override
    public IRecipeType<?> getType () {

        return PrimalageMod.CHOPPING_RECIPE;
    }

    @Override
    public ItemStack getIcon () {

        return new ItemStack(Blocks.STONE);
    }

    public boolean isValid (ResourceLocation Block) {

        return this.block.equals(Block);
    }

    private static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ChoppingRecipe> {

        Serializer() {

            // This registry name is what people will specify in their json files.
            this.setRegistryName(new ResourceLocation("primalage", "chopping"));
        }

        @Override
        public ChoppingRecipe read (ResourceLocation recipeId, JsonObject json) {

            final ResourceLocation block = new ResourceLocation(JSONUtils.getString(json, "input"));

            // Reads the output. The common utility method in ShapedRecipe is what all vanilla
            // recipe classes use for this.
            final ItemStack output = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "output"));

            // Reads a resource location, which is used to look up the target block.
            // If something is invalid or null an exception should be thrown. This is used to
            // let the game and end user know a recipe was bad.
            if (block == null || ForgeRegistries.BLOCKS.getValue(block) == Blocks.AIR) {

                throw new IllegalStateException("The block " + block + " does not exist.");
            }

            return new ChoppingRecipe(recipeId, output, block);
        }

        @Override
        public ChoppingRecipe read (ResourceLocation recipeId, PacketBuffer buffer) {

            // Reads a recipe from a packet buffer. This code is called on the client.
            final ItemStack output = buffer.readItemStack();
            final ResourceLocation block = buffer.readResourceLocation();

            if (block == null) {

                throw new IllegalStateException("The block " + block + " does not exist.");
            }

            return new ChoppingRecipe(recipeId, output, block);
        }
        @Override
        public void write (PacketBuffer buffer, ChoppingRecipe recipe) {

            // Writes the recipe to a packet buffer. This is called on the server when a player
            // connects or when /reload is used.
            buffer.writeItemStack(recipe.output);
            buffer.writeResourceLocation(recipe.block);
        }
    }
}
