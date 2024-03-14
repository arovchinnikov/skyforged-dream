package github.arovchinnikov.skyforged_dream.common.block.blocks;

import github.arovchinnikov.skyforged_dream.common.block.BlockMaterials;
import github.arovchinnikov.skyforged_dream.common.entity.EntityTypes;
import github.arovchinnikov.skyforged_dream.common.entity.ambient.AnadiumPoisonCloud;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.explosion.Explosion;

import java.util.List;
import java.util.function.BiConsumer;

@SuppressWarnings("deprecation")
public class DeepslateAnadiumOre extends Block {
    public DeepslateAnadiumOre() {
        super(BlockMaterials.DEEPSLATE.settings.strength(3.8f, 6));
    }
    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        super.onBlockBreakStart(state, world, pos, player);

        if (player.isCreative()) {
            return;
        }

        this.triggerCloud(world, pos);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);

        if (!(entity instanceof LivingEntity)) {
            return;
        }

        this.triggerCloud(world, pos);
    }

    @Override
    public void onExploded(
        BlockState state,
        World world,
        BlockPos pos,
        Explosion explosion,
        BiConsumer<ItemStack,
            BlockPos> stackMerger
    ) {
        super.onExploded(state, world, pos, explosion, stackMerger);

        this.triggerCloud(world, pos);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        super.onBroken(world, pos, state);

        this.triggerCloud((World) world, pos);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        this.triggerCloud(world, pos);
    }

    private void triggerCloud(World world, BlockPos pos) {
        List<AnadiumPoisonCloud> existClouds = world.getEntitiesByClass(
            AnadiumPoisonCloud.class,
            new Box(pos).expand(1),
            e -> true
        );

        if (existClouds.isEmpty() || existClouds.getFirst().isRemoved()) {
            AnadiumPoisonCloud cloud = new AnadiumPoisonCloud(EntityTypes.ANADIUM_POISON_CLOUD, world);
            cloud.refreshPositionAndAngles(pos, 0f, 0f);
            world.spawnEntity(cloud);
        } else {
            existClouds.getFirst().trigger();
        }
    }
}
