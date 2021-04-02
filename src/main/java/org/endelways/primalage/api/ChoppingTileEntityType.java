//package org.endelways.primalage.api;
//
//import net.minecraft.item.Item;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.tileentity.TileEntityType;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.registries.ForgeRegistries;
//import org.endelways.primalage.PrimalageMod;
//import org.endelways.primalage.block.ChoppingBlock;
//
//public class ChoppingTileEntityType {
//    public final <T extends TileEntity> MiniTileEntity<T> tileEntity(String name, Supplier<T> factory, RegistryObject<? extends Block>... blocks)
//    {
//        return new MiniTileEntity<T>(TILE_ENTITIES, name, factory, ImmutableSet.copyOf(blocks));
//    }
//    public static final RegistryObject<TileEntityType<ChoppingBlock.ChoppingTileEntity>> CHOPPING_BLOCK_TILE_ENTITY_TYPE = tileEntity("chopping_block", ChoppingBlock.ChoppingTileEntity::new,
//            ChoppingBlock).defer();
//}
