package net.uwulabs.createmate.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class VirtualFluid extends Fluid {
    private final Supplier<FluidType> fluidType;

    public VirtualFluid(Supplier<FluidType> fluidType) {
        this.fluidType = fluidType;
    }

    @Override
    public @NotNull FluidType getFluidType() {
        return fluidType.get();
    }

    @Override
    public @NotNull Item getBucket() {
        return Items.AIR;
    }

    @Override
    protected boolean canBeReplacedWith(@NotNull FluidState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Fluid fluid, @NotNull Direction direction) {
        return false;
    }

    @Override
    protected @NotNull Vec3 getFlow(@NotNull BlockGetter blockReader, @NotNull BlockPos pos, @NotNull FluidState fluidState) {
        return Vec3.ZERO;
    }

    @Override
    public int getTickDelay(@NotNull LevelReader level) {
        return 0;
    }

    @Override
    protected float getExplosionResistance() {
        return 0;
    }

    @Override
    public float getHeight(@NotNull FluidState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return 0;
    }

    @Override
    public float getOwnHeight(@NotNull FluidState state) {
        return 0;
    }

    @Override
    protected @NotNull BlockState createLegacyBlock(@NotNull FluidState state) {
        return Blocks.AIR.defaultBlockState();
    }

    @Override
    public boolean isSource(@NotNull FluidState state) {
        return true;
    }

    @Override
    public int getAmount(@NotNull FluidState state) {
        return 8;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull FluidState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return Shapes.empty();
    }
}
