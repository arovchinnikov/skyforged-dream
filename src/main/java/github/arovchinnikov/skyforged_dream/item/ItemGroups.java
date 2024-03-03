package github.arovchinnikov.skyforged_dream.item;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroups {
    public static final RegistryKey<ItemGroup> MAIN_GROUP = RegistryKey.of(
        RegistryKeys.ITEM_GROUP,
        new Identifier(SkyforgedDream.MOD_ID, "main")
    );

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, MAIN_GROUP, FabricItemGroup.builder()
            .displayName(Text.translatable("item_group.skyforged_dream.main"))
            .icon(() -> new ItemStack(Items.BLACK_PEARL.get()))
            .build());
    }
}
