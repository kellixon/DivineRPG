package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityGreenlightFurnace;
import divinerpg.proxy.GUIHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGreenlightFurnace extends BlockModFurnace implements ITileEntityProvider {
    protected String name;

    public BlockGreenlightFurnace(String name, boolean isBurnging) {
        super(name, isBurnging);
        this.name = name;
    }

    public int getGuiID() {
        return GUIHandler.GREENLIGHT_FURNACE_GUI_ID;
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityGreenlightFurnace();
    }
}
