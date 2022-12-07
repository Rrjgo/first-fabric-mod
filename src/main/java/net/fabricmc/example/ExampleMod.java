package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static final FabricItem FABRIC_ITEM = new FabricItem(new FabricItemSettings());

	public static final ExampleBlock EXAMPLE_BLOCK = new ExampleBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool());
	public static final JukeboxDrawerBlock JUKEBOX_DRAWER_BLOCK = new JukeboxDrawerBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));

	public static final BlockEntityType<JukeboxDrawerBlockEntity> JUKEBOX_DRAWER_BLOCK_ENTITY = Registry.register(
			Registry.BLOCK_ENTITY_TYPE,
			new Identifier("tutorial", "jukebox_drawer_block_entity"),
			FabricBlockEntityTypeBuilder.create(JukeboxDrawerBlockEntity::new, JUKEBOX_DRAWER_BLOCK).build()
	);

	public static final ScreenHandlerType<JukeboxDrawerScreenHandler> JUKEBOX_DRAWER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(
			new Identifier("tutorial", "jukebox_drawer_block_entity"),
			JukeboxDrawerScreenHandler::new
	);



	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
			new Identifier("tutorial", "fabric"))
			.icon(() -> new ItemStack(FABRIC_ITEM))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(FABRIC_ITEM));
				stacks.add(new ItemStack(EXAMPLE_BLOCK));
				stacks.add(new ItemStack(JUKEBOX_DRAWER_BLOCK));
			})
			.build();


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		Registry.register(Registry.ITEM, new Identifier("tutorial", "fabric_item"),FABRIC_ITEM);

		Registry.register(Registry.BLOCK, new Identifier("tutorial", "example_block"), EXAMPLE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "example_block"), new BlockItem(EXAMPLE_BLOCK, new Item.Settings()));

		Registry.register(Registry.BLOCK, new Identifier("tutorial", "jukebox_drawer"), JUKEBOX_DRAWER_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "jukebox_drawer"), new BlockItem(JUKEBOX_DRAWER_BLOCK, new Item.Settings()));

	}
}
