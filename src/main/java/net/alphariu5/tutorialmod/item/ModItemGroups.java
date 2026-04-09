package net.alphariu5.tutorialmod.item;

import net.alphariu5.tutorialmod.TutorialMod;
import net.alphariu5.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup TUTORIAL_MOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "tutorial_mod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CHRISTAL))
                    .displayName(Text.translatable("itemgroup.tutorial-mod.tutorial_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CHRISTAL);
                        entries.add(ModItems.RAW_CHRISTAL);
                    })
                    .build());

    public static final ItemGroup TUTORIAL_MOD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "tutorial_mod_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.GDC_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorial-mod.tutorial_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.GDC_BLOCK);
                        entries.add(ModBlocks.GDC_PRIME_BLOCK);
                        entries.add(ModBlocks.DRIFTING_BLOCK);
                    })
                    .build());

    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
