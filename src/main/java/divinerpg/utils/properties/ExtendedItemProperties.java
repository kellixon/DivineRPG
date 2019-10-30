package divinerpg.utils.properties;

import net.minecraft.item.Item;

public class ExtendedItemProperties extends Item.Properties {
    public IShootEntity spawnBullet;
    public Item ammo;
    public int ammoConsumeCount = -1;
    public int cooldown = 0;
    public int bowLikeDuration = 0;
    public int arcana = 0;

    /**
     * Adding shoot ability
     *
     * @param spawnBullet - function for creating bullet entity
     * @return this
     */
    public ExtendedItemProperties withBulletOnLeftClick(IShootEntity spawnBullet) {
        this.spawnBullet = spawnBullet;
        return this;
    }

    /**
     * Consuming some amount of ammo
     *
     * @param ammo  - ammo item
     * @param count - consuming ammoConsumeCount at once
     * @return this
     */
    public ExtendedItemProperties withAmmo(Item ammo, int count) {
        this.ammo = ammo;
        this.ammoConsumeCount = count;
        return this;
    }

    /**
     * Set cooldown between shoots
     */
    public ExtendedItemProperties withDelay(int ticks) {
        this.cooldown = ticks;
        return this;
    }

    /**
     * Set max duration like for bow
     */
    public ExtendedItemProperties withUseDuration(int duration) {
        this.bowLikeDuration = duration;
        return this;
    }

    /**
     * Set arcana usage per shot
     */
    public ExtendedItemProperties useArcana(int arcana) {
        this.arcana = arcana;
        return this;
    }
}