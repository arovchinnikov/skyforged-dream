package github.arovchinnikov.skyforged_dream.mixin.item;

import github.arovchinnikov.skyforged_dream.util.helper.TooltipHelper;
import github.arovchinnikov.skyforged_dream.mod.item.base.RegisteredItem;
import github.arovchinnikov.skyforged_dream.mod.item.RegisteredItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Shadow public abstract String getTranslationKey();

    @ModifyVariable(
        method = "appendTooltip",
        at = @At(value = "RETURN"),
        index = 3,
        argsOnly = true
    )
    @Environment(EnvType.CLIENT)
    public List<Text> onAppendTooltip(
        List<Text> value
    ) {
        @Nullable RegisteredItem item = RegisteredItems.findByKey(getTranslationKey());
        if (item == null) {
            return value;
        }

        if (item.settings().isHasDescription() && Screen.hasShiftDown()) {
            TooltipHelper.appendLargeTooltip(
                value,
                Text.translatable(getTranslationKey() + ".description")
            );
        }

        return value;
    }
}
