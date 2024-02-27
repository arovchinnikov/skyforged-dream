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
    public static final RegistryKey<ItemGroup> ITEMS_GROUP = makeKey("items");

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, ITEMS_GROUP, FabricItemGroup.builder()
            .displayName(Text.translatable("item_group.skyforged_dream.items"))
            .icon(() -> new ItemStack(Items.DARK_SILVER_INGOT.get()))
            .build());
    }

    private static RegistryKey<ItemGroup> makeKey(String name) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(SkyforgedDream.MOD_ID, name));
    }
}
