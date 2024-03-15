package github.arovchinnikov.skyforged_dream.common.block.blocks;

import github.arovchinnikov.skyforged_dream.common.block.BlockMaterials;
import github.arovchinnikov.skyforged_dream.util.helper.ItemHelper;
import github.arovchinnikov.skyforged_dream.common.item.Items;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class PearlShell extends Block implements Waterloggable {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public PearlShell() {
        super(BlockMaterials.BONE.settings.strength(0.2f, 0.2f));
        this.setDefaultState(this.stateManager.getDefaultState().
            with(FACING, Direction.NORTH)
            .with(WATERLOGGED, true));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemHeld = player.getStackInHand(hand);
        Random rand = Random.create();

        if (ItemHelper.isTool(itemHeld.getItem())) {
            return toolUse(world, pos, player, rand, itemHeld);
        }

        return handUse(world, pos, player, rand);
    }

    private ActionResult toolUse(World world, BlockPos pos, PlayerEntity player, Random random, ItemStack stack) {
        stack.damage(random.nextBetween(1, 3), random, null);

        if (0.8 > random.nextDouble()) {
            successOpen(world, pos, player, random);
            player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
            return ActionResult.SUCCESS;
        }

        world.playSound(null, pos, SoundEvents.BLOCK_BONE_BLOCK_HIT, SoundCategory.BLOCKS, 1.f, .8f);
        return ActionResult.PASS;
    }

    private ActionResult handUse(World world, BlockPos pos, PlayerEntity player, Random random) {
        if (0.5 > random.nextDouble()) {
            successOpen(world, pos, player, random);
            return ActionResult.SUCCESS;
        }

        world.playSound(null, pos, SoundEvents.BLOCK_BONE_BLOCK_HIT, SoundCategory.BLOCKS, 1.f, .8f);
        if (player.getHealth() > 2 && 0.7 > random.nextDouble()) {
            player.damage(world.getDamageSources().inWall(), random.nextBetween(1, 2));
        }

        return ActionResult.PASS;
    }

    private void successOpen(World world, BlockPos pos, PlayerEntity player, Random random) {
        world.breakBlock(pos, false);
        world.playSound(null, pos, SoundEvents.BLOCK_BONE_BLOCK_BREAK, SoundCategory.BLOCKS, 1.f, .8f);

        player.addExperience(random.nextBetween(1, 2));

        if (0.04 > random.nextDouble()) {
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.BLACK_PEARL.item()));
        } else {
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.PEARL.item()));
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(3.d, .0d, 2.d, 13.d, 2.d, 12.d);
            case SOUTH -> Block.createCuboidShape(3.d, .0d, 4.d, 13.d, 2.d, 14.d);
            case EAST -> Block.createCuboidShape(4.d, .0d, 3.d, 14.d, 2.d, 13.d);
            case WEST -> Block.createCuboidShape(2.d, .0d, 3.d, 12.d, 2.d, 13.d);
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(3.d, .0d, 3.d, 13.d, 2.d, 13.d);
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
            .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER)
            .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public boolean canMobSpawnInside(BlockState state) {
        return true;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return hasTopRim(world, blockPos) || sideCoversSmallSquare(world, blockPos, Direction.UP);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
}
