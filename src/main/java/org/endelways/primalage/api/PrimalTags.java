package org.endelways.primalage.api;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TagsUpdatedEvent;

import java.util.function.Consumer;

public class PrimalTags {
    private static boolean tagsLoaded = false;

    /** Called on mod construct to set up tags */
    public static void init() {
//        Blocks.init();
        Items.init();
        Fluids.init();
        Consumer<TagsUpdatedEvent.VanillaTagTypes> onTagsLoaded = (event) -> tagsLoaded = true;
        MinecraftForge.EVENT_BUS.addListener(onTagsLoaded);
    }

    /** Returns true if tags have been loaded at least once. Will be false before the world is loaded */
    public static boolean tagsLoaded() {
        return tagsLoaded;
    }

//    public static class Blocks {
//        private static void init() {}
//        public static final INamedTag<Block> COLORED_TERRACOTTA = makeWrapperTag("colored_terracotta");
//        public static final INamedTag<Block> PORCELAIN = makeWrapperTag("porcelain_block");
//        public static final INamedTag<Block> COLORED_PORCELAIN = makeWrapperTag("colored_porcelain");
//        public static final INamedTag<Block> RAINBOW_PORCELAIN = makeWrapperTag("rainbow_porcelain");
//        public static final INamedTag<Block> BRICKS = makeWrapperTag("bricks");
//        public static final INamedTag<Block> TERRACOTTA_CISTERNS = makeWrapperTag("terracotta_cisterns");
//        public static final INamedTag<Block> PORCELAIN_CISTERNS = makeWrapperTag("porcelain_cisterns");
//        public static final INamedTag<Block> CISTERN_CONNECTIONS = makeWrapperTag("cistern_connections");
//
//        private static INamedTag<Block> makeWrapperTag(String id) {
//            return BlockTags.makeWrapperTag(Ceramics.locationName(id));
//        }
//    }
    public static class Items {
        private static void init() {}
//        public static final INamedTag<Item> COLORED_TERRACOTTA = makeWrapperTag("colored_terracotta");
//        public static final INamedTag<Item> PORCELAIN = makeWrapperTag("porcelain_block");
//        public static final INamedTag<Item> COLORED_PORCELAIN = makeWrapperTag("colored_porcelain");
//        public static final INamedTag<Item> RAINBOW_PORCELAIN = makeWrapperTag("rainbow_porcelain");
//        public static final INamedTag<Item> BRICKS = makeWrapperTag("bricks");
        public static final ITag.INamedTag<Item> MILK_BUCKETS = ItemTags.makeWrapperTag("forge:buckets/milk");
//        public static final INamedTag<Item> TERRACOTTA_CISTERNS = makeWrapperTag("terracotta_cisterns");
//        public static final INamedTag<Item> PORCELAIN_CISTERNS = makeWrapperTag("porcelain_cisterns");
//        public static final INamedTag<Item> TERRACOTTA_CRACK_REPAIR = makeWrapperTag("terracotta_crack_repair");

        private static ITag.INamedTag<Item> makeWrapperTag(String id) {
            return ItemTags.makeWrapperTag("primalage:" + id);
        }
    }

    public static class Fluids {
        private static void init() {}
        @SuppressWarnings("WeakerAccess")
        public static final Tags.IOptionalNamedTag<Fluid> MILK = FluidTags.createOptional(new ResourceLocation("forge:milk"));

        public static final Tags.IOptionalNamedTag<Fluid> HOT_FLUIDS = makeWrapperTag("hot_fluids");
        public static final Tags.IOptionalNamedTag<Fluid> COOL_FLUIDS = makeWrapperTag("cool_fluids");

        private static Tags.IOptionalNamedTag<Fluid> makeWrapperTag(String id) {
            return FluidTags.createOptional(new ResourceLocation("primalage:" + id));
        }
    }
}

