package divinerpg.entities.apalachia.warrior;

import divinerpg.entities.base.DivineMonster;
import divinerpg.entities.goal.SunBurnGoal;
import divinerpg.registry.EntitiesRegistry;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.World;

public class EnchantedWarrior extends DivineMonster {
    public EnchantedWarrior(World world) {
        super(EntitiesRegistry.enchanted_warrior, world, SoundRegistry.GROWL_HURT, SoundRegistry.GROWL, 1.7F);

        putItem(EquipmentSlotType.MAINHAND, ItemRegistry.apalachiaBlade);
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();

        initAttr(200, 1, 10);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(2, new RestrictSunGoal(this));
        this.goalSelector.addGoal(3, new SunBurnGoal(this));
    }

    @Override
    public void livingTick() {
        super.livingTick();
    }
}