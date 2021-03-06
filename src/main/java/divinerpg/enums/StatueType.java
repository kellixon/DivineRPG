package divinerpg.enums;

import divinerpg.client.render.DivineModel;
import divinerpg.objects.blocks.tile.model.statue.ModelAncientEntityStatue;
import divinerpg.objects.blocks.tile.model.statue.ModelAyeracoStatue;
import divinerpg.objects.blocks.tile.model.statue.ModelDensosStatue;
import divinerpg.objects.blocks.tile.model.statue.ModelDramixStatue;
import divinerpg.objects.blocks.tile.model.statue.ModelEternalArcherStatue;
import divinerpg.objects.blocks.tile.model.statue.ModelKarotStatue;
import divinerpg.objects.blocks.tile.model.statue.ModelKingOfScorchersStatue;
import divinerpg.objects.blocks.tile.model.statue.ModelParasectaStatue;
import divinerpg.objects.blocks.tile.model.statue.ModelReyvorStatue;
import divinerpg.objects.blocks.tile.model.statue.ModelSoulFiendStatue;
import divinerpg.objects.blocks.tile.model.statue.ModelTheWatcherStatue;
import divinerpg.objects.blocks.tile.model.statue.ModelTwilightDemonStatue;
import divinerpg.objects.blocks.tile.model.statue.ModelVamacheronStatue;
import net.minecraft.util.ResourceLocation;

public enum StatueType {
    NONE(null, null),
    ANCIENT_ENTITY_STATUE(new ModelAncientEntityStatue(), StatueLoc("ancient_entity_statue")),
    AYERACO_STATUE(new ModelAyeracoStatue(), StatueLoc("ayeraco_statue")),
    DENSOS_STATUE(new ModelDensosStatue(), StatueLoc("densos_statue")),
    DRAMIX_STATUE(new ModelDramixStatue(), StatueLoc("dramix_statue")),
    ETERNAL_ARCHER_STATUE(new ModelEternalArcherStatue(), StatueLoc("eternal_archer_statue")),
    KAROT_STATUE(new ModelKarotStatue(), StatueLoc("karot_statue")),
    KING_OF_SCORCHERS_STATUE(new ModelKingOfScorchersStatue(), StatueLoc("king_of_scorchers_statue")),
    PARASECTA_STATUE(new ModelParasectaStatue(), StatueLoc("parasecta_statue")),
    REYVOR_STATUE(new ModelReyvorStatue(), StatueLoc("reyvor_statue")),
    SOUL_FIEND_STATUE(new ModelSoulFiendStatue(), StatueLoc("soul_fiend_statue")),
    THE_WATCHER_STATUE(new ModelTheWatcherStatue(), StatueLoc("the_watcher_statue")),
    TWILIGHT_DEMON_STATUE(new ModelTwilightDemonStatue(), StatueLoc("twilight_demon_statue")),
    VAMACHERON_STATUE(new ModelVamacheronStatue(), StatueLoc("vamacheron_statue"));

    private final DivineModel model;
    private final ResourceLocation texture;

    StatueType(DivineModel model, ResourceLocation texture) {
        this.model = model;
        this.texture = texture;
    }

    public DivineModel getModel() {
        return this.model;
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    public static StatueType getStatueFromId(int ordinal) {
        if (ordinal < 0 || ordinal > values().length) {
            ordinal = 0;
        }
        return values()[ordinal];
    }

    private static ResourceLocation StatueLoc(String name) {
        return new ResourceLocation("divinerpg:textures/model/" + name + ".png");
    }
}