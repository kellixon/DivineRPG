package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.config.OreGen;
import divinerpg.world.arcana.structure.ArcanaMazeRoomPiece;
import divinerpg.world.arcana.structure.ArcanaMazeStructure;
import divinerpg.world.twilight.feature.DivineFlowersFeature;
import divinerpg.world.twilight.feature.DivineOreFeature;
import divinerpg.world.twilight.feature.DivineTreeFeature;
import divinerpg.world.twilight.feature.config.CustomFillerBlockType;
import divinerpg.world.twilight.feature.config.DivineCountRangeConfig;
import divinerpg.world.twilight.feature.config.DivineOreFeatureConfig;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DivineRPG.MODID)
public class FeatureRegistry {
    @ObjectHolder("eden_tree_feature")
    public static DivineTreeFeature eden_tree_feature;
    @ObjectHolder("flowers_feature")
    public static DivineFlowersFeature flowers_feature;
    @ObjectHolder("ore_feature")
    public static DivineOreFeature ORE;
    @ObjectHolder("arcana_maze")
    public static Structure<NoFeatureConfig> arcana_maze;

    public static IStructurePieceType arcana_maze_type;

    static {
        eden_tree_feature = new DivineTreeFeature(false, 7, () -> BlockRegistry.edenSapling,
                () -> BlockRegistry.edenLog, () -> BlockRegistry.edenLeaves);
        flowers_feature = new DivineFlowersFeature();
        ORE = new DivineOreFeature(DivineOreFeatureConfig::deserialize);

        // arcana structure piece type
        arcana_maze_type = IStructurePieceType.register(ArcanaMazeRoomPiece::new, "ArcSPT");
    }

    /**
     * Injecting features to worldgen
     */
    public static void registerWorldGen() {
        // TODO inject features in chunk gen, not in biomes

        for (BiomeManager.BiomeType type : BiomeManager.BiomeType.values()) {
            for (BiomeManager.BiomeEntry entry : BiomeManager.getBiomes(type)) {
                Biome biome = entry.biome;

                if (DivineRPG.CONFIG.worlgen.genTrees.get()) {
                    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                            Biome.createDecoratedFeature(eden_tree_feature, IFeatureConfig.NO_FEATURE_CONFIG, Placement.CHANCE_HEIGHTMAP,
                                    new ChanceConfig(10)));
                }

                // TODO balancing
                registerOre(biome, DivineRPG.CONFIG.worlgen.realmit, BlockRegistry.realmiteOre, new CustomFillerBlockType(OreFeatureConfig.FillerBlockType.NATURAL_STONE));
                registerOre(biome, DivineRPG.CONFIG.worlgen.arlemit, BlockRegistry.arlemiteOre, new CustomFillerBlockType(OreFeatureConfig.FillerBlockType.NATURAL_STONE));
                registerOre(biome, DivineRPG.CONFIG.worlgen.rupee, BlockRegistry.rupeeOre, new CustomFillerBlockType(OreFeatureConfig.FillerBlockType.NATURAL_STONE));

                registerOre(biome, DivineRPG.CONFIG.worlgen.nethers, BlockRegistry.bloodgemOre, new CustomFillerBlockType(OreFeatureConfig.FillerBlockType.NETHERRACK));
                registerOre(biome, DivineRPG.CONFIG.worlgen.nethers, BlockRegistry.netheriteOre, new CustomFillerBlockType(OreFeatureConfig.FillerBlockType.NETHERRACK));
            }
        }
    }

    private static void registerOre(Biome biome, OreGen config, Block block, CustomFillerBlockType type) {
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(FeatureRegistry.ORE,
                new DivineOreFeatureConfig(type, block.getDefaultState(),
                        config.maxInChunk.get()),
                Placement.COUNT_RANGE,
                new DivineCountRangeConfig(config)));
    }

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> e) {
        IForgeRegistry<Feature<?>> registry = e.getRegistry();

        registry.register(eden_tree_feature.setRegistryName(DivineRPG.MODID, "eden_tree_feature"));
        registry.register(flowers_feature.setRegistryName(DivineRPG.MODID, "flowers_feature"));
        registry.register(ORE.setRegistryName(DivineRPG.MODID, "ore_feature"));
        registry.register(new ArcanaMazeStructure().setRegistryName(DivineRPG.MODID, "arcana_maze"));
    }
}