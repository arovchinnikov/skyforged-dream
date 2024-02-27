package github.arovchinnikov.skyforged_dream.item.base;

import github.arovchinnikov.skyforged_dream.client.ModColor;
import github.arovchinnikov.skyforged_dream.item.ModRarity;
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
    private final ModRarity rarity;

    public ModItem() {
        super(new FabricItemSettings());

        this.hasDescription = false;
        this.rarity = ModRarity.COMMON;
    }

    public ModItem(Settings settings, ModRarity rarity, boolean hasDescription) {
        super(settings);

        this.rarity = rarity;
        this.hasDescription = hasDescription;
    }

    public ModRarity getRarity() {
        return this.rarity;
    }

    public boolean hasDescription() {
        return this.hasDescription;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (this.hasDescription() && Screen.hasShiftDown()) {
            tooltip.add(
                Text.translatable(getTranslationKey() + ".description")
                    .withColor(ModColor.LIGHT_GREY.getRGB())
            );
        }
    }
}
