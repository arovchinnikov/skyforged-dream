package github.arovchinnikov.skyforged_dream.item.base;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.helper.TooltipHelper;
import github.arovchinnikov.skyforged_dream.item.ItemRarity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItem extends Item implements IHasDescription, IHasRarity {
    private final boolean hasDescription;
    private final ItemRarity rarity;

    public ModItem() {
        super(new FabricItemSettings());

        this.hasDescription = false;
        this.rarity = ItemRarity.COMMON;
    }

    public ModItem(ItemRarity rarity, boolean hasDescription) {
        super(new FabricItemSettings());

        this.rarity = rarity;
        this.hasDescription = hasDescription;
    }

    public ModItem(Settings settings, ItemRarity rarity, boolean hasDescription) {
        super(settings);

        this.rarity = rarity;
        this.hasDescription = hasDescription;
    }

    public ItemRarity getRarity() {
        return this.rarity;
    }

    public boolean hasDescription() {
        return this.hasDescription;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (this.hasDescription() && Screen.hasShiftDown()) {
            TooltipHelper.appendLargeTooltip(tooltip, Text.translatable(getTranslationKey() + ".description"));
        }
    }
}
