package github.arovchinnikov.skyforged_dream.common.item;

import github.arovchinnikov.skyforged_dream.util.ModId;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public class ItemGroups {
    public static final RegistryKey<ItemGroup> MAIN_GROUP = RegistryKey.of(
        RegistryKeys.ITEM_GROUP,
        ModId.get("main")
    );

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, MAIN_GROUP, FabricItemGroup.builder()
            .displayName(Text.translatable("item_group.skyforged_dream.main"))
            .icon(() -> new ItemStack(Items.BLACK_PEARL.item()))
            .build());
    }
}
