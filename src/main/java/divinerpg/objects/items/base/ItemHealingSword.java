package divinerpg.objects.items.base;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.registry.ModSounds;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHealingSword extends ItemModSword {

    private float healAmount;

    public ItemHealingSword(String name, ToolMaterial material, float healAmount) {
        super(material, name);
        this.healAmount = healAmount;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getHeldItem(hand);
            if (!player.capabilities.isCreativeMode) {
                stack.damageItem(1, player);
            }
            player.heal(healAmount);
            player.playSound(ModSounds.HEAL, 1, 1);
        }
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add("Heals " + this.healAmount / 2 + " hearts on use");
        list.add(TooltipLocalizer.usesRemaining(item.getMaxDamage() - item.getItemDamage()));
    }
}
