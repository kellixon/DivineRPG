package divinerpg.objects.blocks.iceika;

import divinerpg.enums.EnumBlockType;
import divinerpg.objects.blocks.BlockMod;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by LiteWolf101 on Jan /28/2019
 */
public class WorkshopCarpet extends BlockMod {

	public WorkshopCarpet(String name) {
		super(EnumBlockType.WOOL, name, 1.5F);
		setSoundType(SoundType.CLOTH);
		this.setCreativeTab(DivineRPGTabs.BlocksTab);
	}

}
