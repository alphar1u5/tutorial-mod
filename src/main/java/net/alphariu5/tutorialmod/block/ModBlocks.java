package net.alphariu5.tutorialmod.block;

import net.alphariu5.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block GDC_BLOCK  = registerBlock("gdc_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER)));
    public static final Block GDC_PRIME_BLOCK = registerBlock("gdc_prime_block",
            new Block(AbstractBlock.Settings.create()
            .strength(2f)
            .requiresTool()
            .sounds(BlockSoundGroup.ANVIL)));
    public static final Block DRIFTING_BLOCK = registerBlock("drifting_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE)));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering Mod Blocks " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.GDC_BLOCK);
            entries.add(ModBlocks.GDC_PRIME_BLOCK);
            entries.add(ModBlocks.DRIFTING_BLOCK);
        });
    }
}
