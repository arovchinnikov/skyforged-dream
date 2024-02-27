package github.arovchinnikov.skyforged_dream;

import github.arovchinnikov.skyforged_dream.block.Blocks;
import github.arovchinnikov.skyforged_dream.item.ItemGroups;
import github.arovchinnikov.skyforged_dream.item.Items;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Shadow;

public class SkyforgedDream implements ModInitializer {
	public static final String MOD_ID = "skyforged_dream";
	public static final Logger LOGGER = LoggerFactory.getLogger("skyforged_dream");

	@Override
	public void onInitialize() {
		Blocks.register();
		Items.register();
		ItemGroups.register();
	}
}
