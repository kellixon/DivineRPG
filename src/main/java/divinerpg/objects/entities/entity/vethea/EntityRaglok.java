package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;


import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import divinerpg.objects.entities.entity.projectiles.EntityRaglokBomb;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import divinerpg.utils.MessageLocalizer;
import divinerpg.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class EntityRaglok extends EntityDivineRPGBoss {

    private int       ability;
    private final int DEFAULT = 0, LIGHTNING = 1, BLIND = 2, BOMBS = 3, SLOW = 4;
    private double prevPlayerX, prevPlayerY, prevPlayerZ;
    private int     abilityCooldown;
    private boolean loaded = false;
    private int     rangedAttackCounter;
    private boolean avengeAbilityUsed = false;
    public EntityRaglok(World worldIn) {
		super(worldIn);
		this.setSize(3F, 5f);
	}

    @Override
	protected ResourceLocation getLootTable()
	{
		return DRPGLootTables.ENTITIES_RAGLOK;
	}

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!loaded && !this.world.isRemote) {
            List<EntityPlayer> players = this.world.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox().expand(30, 30, 30));
            for (EntityPlayer p : players) {
                p.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.raglok.dare")));
            }
            this.playSound(ModSounds.RAGLOK_AWAKEN, 1.0F, 1.0F);
            loaded = true;
        }

        manageAbilities();
    }

    public void manageAbilities() {
        EntityPlayer player = this.world.getClosestPlayerToEntity(this, 64.0D);
        
        if(player == null || player.isCreative() || avengeAbilityUsed) {
            return;
        }
        
        if (abilityCooldown == 0 || ability == DEFAULT) {
            abilityCooldown = 400;
            switch (this.rand.nextInt(4)) {
                case 0:
                    ability = LIGHTNING;
                    this.rangedAttackCounter = 0;
                    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
                    break;
                case 1:
                    ability = BLIND;
                    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
                    break;
                case 2:
                    ability = BOMBS;
                    this.rangedAttackCounter = 0;
                    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
                    break;
                case 3:
                    ability = SLOW;
                    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
                    break;
                default:
                    break;
            }
            this.message();
        } else if (abilityCooldown > 0) {
            abilityCooldown--;
        }

        if (ability == BLIND) {
            if (player != null) {
                player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 25, 0));
            }
        }
        if (ability == SLOW) {
            if (player != null) {
                player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 10, 1));
            }
        }
        if (ability == LIGHTNING) {
            if (abilityCooldown % 40 == 0 && player != null) {
                this.world.spawnEntity(new EntityLightningBolt(this.world, prevPlayerX, prevPlayerY, prevPlayerZ, false));
                this.rangedAttackCounter++;
            } else if (abilityCooldown % 40 != 0 && abilityCooldown % 20 == 0 && player != null) {
                this.prevPlayerX = player.posX;
                this.prevPlayerY = player.posY;
                this.prevPlayerZ = player.posZ;
            }
            if (this.rangedAttackCounter == 10) {
                ability = DEFAULT;
            }
        }
        if (ability == BOMBS) {
            if (abilityCooldown % 30 == 0 && player != null) {

                for (int i = 0; i < 4; i++) {
                    EntityRaglokBomb var2 = new EntityRaglokBomb(this.world);
                    var2.setPosition(player.posX, player.posY + 5, player.posZ);
                    var2.motionX = (rand.nextDouble() - rand.nextDouble()) / 5;
                    var2.motionY = -0.14;
                    var2.motionZ = (rand.nextDouble() - rand.nextDouble()) / 5;
                    this.world.spawnEntity(var2);
                    ++this.rangedAttackCounter;
                }
            }
            if (this.rangedAttackCounter == 12) {
                ability = DEFAULT;
            }
        }
    }

    private void message() {
        List list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(64.0D, 64.0D, 64.0D));
        for (int var1 = 0; var1 < list.size(); ++var1) {
            if (list.get(var1) instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) list.get(var1);
                switch (ability) {
                    case LIGHTNING:
                        this.playSound(ModSounds.RAGLOK_GUARDIAN, 1.0F, 1.0F);
                        if (!this.world.isRemote) {
                            player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.raglok.think")));
                            player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.raglok.great")));
                        }
                        break;
                    case BLIND:
                        this.playSound(ModSounds.RAGLOK_DARK, 1.0F, 1.0F);
                        if (!this.world.isRemote)
                            player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.raglok.future")));
                        break;
                    case BOMBS:
                        this.playSound(ModSounds.RAGLOK_RAIN, 1.0F, 1.0F);
                        if (!this.world.isRemote) {
                            player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.raglok.rain")));
                            player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.raglok.kill")));
                        }
                        break;
                    case SLOW:
                        this.playSound(ModSounds.RAGLOK_NOTHING, 1.0F, 1.0F);
                        if (!this.world.isRemote)
                            player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.raglok.compare")));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5000.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(30.0D);

    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(8, new EntityAIAttackMelee(this, 1, true));
        this.tasks.addTask(8, new EntityAIFollow(this, 1, 1, 1));
        this.applyEntityAI();
    }

    private void applyEntityAI() {
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[]{EntityPigZombie.class}));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 3;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.RAGLOK_AVENGE;
    }

    @Override
    public void onDeathUpdate() {
        if(!avengeAbilityUsed) {
            if (!this.world.isRemote) {
                List<EntityPlayer> players = this.world.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox().expand(30, 30, 30));
                for (EntityPlayer p : players) {
                    p.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.raglok.avenge")));
                }
            }
            EntityPlayer player = this.world.getClosestPlayerToEntity(this, 64.0D);
            if (player != null && !player.isCreative()) {
                this.world.spawnEntity(new EntityLightningBolt(this.world, player.posX, player.posY, player.posZ, false));
            }
            
            avengeAbilityUsed = true;
        }
        
        super.onDeathUpdate();
    }
}
