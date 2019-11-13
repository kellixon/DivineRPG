package divinerpg.blocks.base;

import divinerpg.utils.DivinePlantType;
import divinerpg.utils.properties.block.ExtendedBlockProperties;
import divinerpg.utils.properties.block.IPlacementCheck;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.PlantType;

import java.util.function.Consumer;

/**
 * Basic bush. Can have customized size and ground to place.
 */
public class DivineBushBlock extends BushBlock implements IDivinePlant {
    private final IPlacementCheck validGround;
    private final DivinePlantType specialType;
    private final VoxelShape shape;
    private final Consumer<Entity> onCollision;
    private final Consumer<Entity> onHarvest;

    public DivineBushBlock(ExtendedBlockProperties props) {
        super(props.props.doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT));
        validGround = props.validGround;
        specialType = props.type;
        shape = props.shape;
        onCollision = props.onCollision;
        onHarvest = props.onHarvest;
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return validGround == null
                ? super.isValidGround(state, worldIn, pos)
                : validGround.canPlace(state, worldIn, pos);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return shape;
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return specialType.type;
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        super.onEntityCollision(state, worldIn, pos, entityIn);

        if (onCollision != null) {
            onCollision.accept(entityIn);
        }
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBlockHarvested(worldIn, pos, state, player);

        if (onHarvest != null) {
            onHarvest.accept(player);
        }
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!canStandOnPostPlacement(validGround, worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
}
