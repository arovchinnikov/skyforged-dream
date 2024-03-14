package github.arovchinnikov.skyforged_dream.common.feature.features;

import com.mojang.serialization.Codec;
import github.arovchinnikov.skyforged_dream.common.block.Blocks;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

@SuppressWarnings("deprecation")
public class PearlShellFeature extends Feature<PearlShellFeatureConfig> {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public PearlShellFeature(Codec<PearlShellFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<PearlShellFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        PearlShellFeatureConfig config = context.getConfig();

        if (
            world.getBlockState(pos).isOf(net.minecraft.block.Blocks.WATER)
                && pos.getY() < world.getSeaLevel() - 5
                && world.getBlockState(pos.down()).isSolid()
        ) {
            if (config.getChance() < random.nextFloat()) {
                return false;
            }
            
            world.setBlockState(pos, Blocks.PEARL_SHELL.block().getDefaultState().with(FACING, getRandomDirection(random)), 3);

            return true;
        }

        return false;
    }

    private Direction getRandomDirection(Random random) {
        return switch (random.nextBetween(1, 4)) {
            default -> Direction.NORTH;
            case 2 -> Direction.SOUTH;
            case 3 -> Direction.EAST;
            case 4 -> Direction.WEST;
        };
    }
}
