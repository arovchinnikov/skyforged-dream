package github.arovchinnikov.skyforged_dream.mixin.client;

import github.arovchinnikov.skyforged_dream.client.ModColor;
import github.arovchinnikov.skyforged_dream.item.base.IHasRarity;
import github.arovchinnikov.skyforged_dream.item.ItemRarity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow public abstract Item getItem();

    @Shadow public abstract Text getName();

    // Replace name in inventories for mod items
    @Inject(at = @At("RETURN"), method = "getTooltip")
    @Environment(EnvType.CLIENT)
    private void onRenderTooltip(PlayerEntity player, TooltipContext context, CallbackInfoReturnable<List<Text>> cir) {
        if (this.getItem() instanceof IHasRarity item) {
            List<Text> defaultReturn = cir.getReturnValue();

            MutableText mutableText = Text.empty()
                .append(this.getName())
                .withColor(item.getRarity().getColor().getRGB());

            if (item.getRarity() != ItemRarity.COMMON && Screen.hasShiftDown()) {
                MutableText rarityDescription = Text.empty()
                    .append(" - ")
                    .append(item.getRarity().getTranslation())
                    .withColor(ModColor.LIGHT_GREY.getRGB());

                mutableText.append(rarityDescription);
            }

            defaultReturn.set(0, mutableText);
        }
    }
}
