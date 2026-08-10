package net.uwulabs.createmate.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.uwulabs.createmate.CreateMate;

public abstract class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateMate.MOD_ID);

    public static final DeferredBlock<Block> YERBA_MATE_CROP = BLOCKS.register("yerba_mate_crop",
            () -> new YerbaMateCropBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)
            )
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
