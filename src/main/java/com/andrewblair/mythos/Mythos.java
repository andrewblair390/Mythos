package com.andrewblair.mythos;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andrewblair.mythos.items.ModItems;
import com.andrewblair.mythos.creative.ModCreativeTabs;

public class Mythos implements ModInitializer {
	public static final String MOD_ID = "mythos";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		ModItems.initialize();

		ModCreativeTabs.initialize();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
