package github.arovchinnikov.skyforged_dream.item.base;

import github.arovchinnikov.skyforged_dream.helper.TooltipHelper;
import github.arovchinnikov.skyforged_dream.item.ItemRarity;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlockItem extends BlockItem implements IHasDescription, IHasRarity {
    private final boolean hasDescription;
    private final ItemRarity rarity;

    public ModBlockItem(Block block, Settings settings, ItemRarity rarity, boolean hasDescription) {
        super(block, settings);

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
