package github.arovchinnikov.skyforged_dream.mixin.common;

import github.arovchinnikov.skyforged_dream.common.item.Items;
import github.arovchinnikov.skyforged_dream.util.Color;
import github.arovchinnikov.skyforged_dream.util.Rarity;
import github.arovchinnikov.skyforged_dream.common.item.ConfiguredItem;
import github.arovchinnikov.skyforged_dream.util.helper.ItemHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow public abstract Item getItem();

    @Shadow public abstract Text getName();

    @Shadow public abstract NbtCompound getOrCreateNbt();


    @Inject(at = @At("RETURN"), method = "getTooltip", cancellable = true)
    @Environment(EnvType.CLIENT)
    private void onRenderTooltip(PlayerEntity player, TooltipContext context, CallbackInfoReturnable<List<Text>> cir) {
        List<Text> tooltips = cir.getReturnValue();

        @Nullable NbtElement craftedByTag = getOrCreateNbt().get("crafted_by");
         if (craftedByTag != null && ItemHelper.isEquipment(this.getItem())) {
             this.applyCraftedBy(craftedByTag.toString(), tooltips);
        }

        @Nullable ConfiguredItem item = Items.ConfiguredItemRegistry.find(this.getItem());
        if (item != null) {
            this.applyRarity(item, tooltips);
        }

        cir.setReturnValue(tooltips);
    }

    @Inject(at = @At("TAIL"), method = "onCraftByPlayer")
    private void onCraftByPlayer(World world, PlayerEntity player, int amount, CallbackInfo ci) {
        this.getOrCreateNbt().putString("crafted_by", player.getNameForScoreboard());
    }

    @Unique
    private void applyCraftedBy(String playerName, List<Text> tooltips) {
        tooltips.add(Text.empty().append(Text.translatable("common.skyforged_dream.crafted_by").append(playerName)).withColor(Color.YELLOW.getRGB()));
    }

    @Unique
    private void applyRarity(ConfiguredItem item, List<Text> tooltips) {
        MutableText itemName = Text.empty()
            .append(this.getName())
            .withColor(item.settings().getRarity().getColor().getRGB());

        if (item.settings().getRarity() != Rarity.COMMON && Screen.hasShiftDown()) {
            MutableText rarityDescription = Text.empty()
                .append(" - ")
                .append(item.settings().getRarity().getTranslation())
                .withColor(Color.LIGHT_GREY.getRGB());

            itemName.append(rarityDescription);

            tooltips.set(0, itemName);
        }
    }
}
