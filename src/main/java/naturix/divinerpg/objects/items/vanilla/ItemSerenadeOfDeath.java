package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.projectiles.EntitySerenadeOfDeath;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemSerenadeOfDeath extends ItemMod {

    public ItemSerenadeOfDeath(String name) {
        super(name);
        this.setCreativeTab(DRPGCreativeTabs.ranged);
        setMaxDamage(500);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Poisons enemies for 2 seconds");
        tooltip.add(stack.getMaxDamage() - stack.getItemDamage() + " uses left");
        tooltip.add(TooltipLocalizer.rangedDam(14));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (!world.isRemote) {
            world.playSound(null, player.getPosition(), ModSounds.SERENADE, SoundCategory.MASTER, 1, 1);
            EntityThrowable bullet = new EntitySerenadeOfDeath(world, player);
            bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(bullet);
            if (!player.capabilities.isCreativeMode) {
                stack.damageItem(1, player);
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
}