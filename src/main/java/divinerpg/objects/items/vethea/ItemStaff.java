package divinerpg.objects.items.vethea;

import java.util.List;

import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.projectiles.EntityBouncingProjectile;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.*;
import divinerpg.utils.*;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.*;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.*;

public class ItemStaff extends RangedWeaponBase {

	protected int damage;

	public ItemStaff(int dam,
					 int arcana,
					 String name) {
		super(name, null, null, ModSounds.STAFF,
				SoundCategory.PLAYERS,
				-1,
				0,
				null,
				arcana);

		this.damage = dam;
		this.setCreativeTab(DivineRPGTabs.vethea);
		this.setFull3D();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> list, ITooltipFlag flagIn) {
	    list.add(TooltipLocalizer.arcanaDam(damage));
		list.add(TooltipHelper.getInfoText("tooltip.staff.bounce"));
		/*if(stack.getItem() == ModItems.evernight)
			list.add(TooltipHelper.getInfoText("tooltip.staff.evernight.damage"));*/
		super.addInformation(stack,worldIn,list,flagIn);
		//list.add(TooltipLocalizer.vethean());
	}

	@Override
	protected void spawnEntity(World world, EntityPlayer player, ItemStack stack, BulletType bulletType, Class<? extends EntityThrowable> clazz) {
		Item item = stack.getItem();

		/**if (item == ModItems.evernight){
			player.attackEntityFrom(Utils.arcanaSource, 20);
			EntityThrowable projectile = new EntityEvernightProjectile(world, player, this.damage);
			projectile.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 0.4F);
			world.spawnEntity(projectile);
		}
		else {*/
			EntityThrowable projectile = new EntityBouncingProjectile(world, player, this.damage);
			projectile.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 0.4F);
			world.spawnEntity(projectile);
		/*}*/
	}
}