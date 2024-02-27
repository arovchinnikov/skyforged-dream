package github.arovchinnikov.skyforged_dream.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import github.arovchinnikov.skyforged_dream.item.base.IHasRarity;
import github.arovchinnikov.skyforged_dream.item.base.ModItem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(InGameHud.class)
public class InGameHoodMixin {
    @Shadow private ItemStack currentStack;

    @Inject(
        method = "renderHeldItemTooltip",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;hasCustomName()Z"),
        locals = LocalCapture.CAPTURE_FAILEXCEPTION
    )
    private void setTooltip(DrawContext context, CallbackInfo ci, @Local LocalRef<MutableText> mutableText) {
        if (currentStack.getItem() instanceof IHasRarity item) {
            mutableText.set(
                Text.empty()
                    .append(currentStack.getName())
                    .formatted(currentStack.getRarity().formatting)
                    .withColor(item.getRarity().getColor().getRGB())
            );
        }
    }
}
