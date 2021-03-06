/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package divinerpg.dimensions.vethea.layer3;
import java.util.Random;

import divinerpg.dimensions.vethea.VetheaWorldGenerator;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class QuadroticPost extends VetheaWorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {

		setBlock(world, i + 0, j + 5, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 0, j + 5, k + 1, ModBlocks.firelight);
		setBlock(world, i + 0, j + 5, k + 2, ModBlocks.firelight);
		setBlock(world, i + 0, j + 5, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 1, j + 5, k + 0, ModBlocks.firelight);
		setBlock(world, i + 1, j + 5, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 1, j + 5, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 1, j + 5, k + 3, ModBlocks.firelight);
		setBlock(world, i + 1, j + 6, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 1, j + 6, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 1, j + 7, k + 1, ModBlocks.quadroticAltar);
		setBlock(world, i + 1, j + 7, k + 2, ModBlocks.quadroticAltar);
		setBlock(world, i + 2, j + 5, k + 0, ModBlocks.firelight);
		setBlock(world, i + 2, j + 5, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 2, j + 5, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 2, j + 5, k + 3, ModBlocks.firelight);
		setBlock(world, i + 2, j + 6, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 2, j + 6, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 2, j + 7, k + 1, ModBlocks.quadroticAltar);
		setBlock(world, i + 2, j + 7, k + 2, ModBlocks.quadroticAltar);
		setBlock(world, i + 3, j + 5, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 3, j + 5, k + 1, ModBlocks.firelight);
		setBlock(world, i + 3, j + 5, k + 2, ModBlocks.firelight);
		setBlock(world, i + 3, j + 5, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 3, j + 6, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 3, j + 6, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 4, j + 4, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 4, j + 4, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 4, j + 5, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 4, j + 5, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 4, j + 5, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 4, j + 5, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 5, j + 3, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 5, j + 3, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 5, j + 4, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 5, j + 4, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 5, j + 4, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 5, j + 4, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 5, j + 5, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 5, j + 5, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 6, j + 2, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 6, j + 2, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 6, j + 3, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 6, j + 3, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 6, j + 3, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 6, j + 3, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 6, j + 4, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 6, j + 4, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 7, j + 1, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 7, j + 1, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 7, j + 2, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 7, j + 2, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 7, j + 2, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 7, j + 2, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 7, j + 3, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 7, j + 3, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 8, j + 0, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 8, j + 0, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 8, j + 1, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 8, j + 1, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 8, j + 1, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 8, j + 1, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 8, j + 2, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 8, j + 2, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 9, j + 0, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 9, j + 0, k + 1, ModBlocks.darkDreamBricks);
		setBlock(world, i + 9, j + 0, k + 2, ModBlocks.darkDreamBricks);
		setBlock(world, i + 9, j + 0, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 9, j + 1, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 9, j + 1, k + 3, ModBlocks.darkDreamBricks);
		setBlock(world, i + 10, j + 0, k + 0, ModBlocks.darkDreamBricks);
		setBlock(world, i + 10, j + 0, k + 3, ModBlocks.darkDreamBricks);

		return true;
	}
}