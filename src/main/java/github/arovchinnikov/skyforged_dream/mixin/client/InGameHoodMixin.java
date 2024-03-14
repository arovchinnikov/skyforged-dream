package github.arovchinnikov.skyforged_dream.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import github.arovchinnikov.skyforged_dream.common.item.RegisteredItems;
import github.arovchinnikov.skyforged_dream.common.item.RegisteredItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
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
    @Environment(EnvType.CLIENT)
    private void setTooltip(DrawContext context, CallbackInfo ci, @Local LocalRef<MutableText> mutableText) {
        @Nullable RegisteredItem item = RegisteredItems.find(currentStack.getItem());
        if (item == null) {
            return;
        }

        mutableText.set(
            Text.empty()
                .append(currentStack.getName())
                .formatted(currentStack.getRarity().formatting)
                .withColor(item.settings().getRarity().getColor().getRGB())
        );
    }
}
