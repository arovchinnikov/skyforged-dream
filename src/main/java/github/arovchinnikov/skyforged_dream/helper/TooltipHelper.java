package github.arovchinnikov.skyforged_dream.helper;

import github.arovchinnikov.skyforged_dream.client.Colors;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.List;

public class TooltipHelper {
    public static void appendLargeTooltip(List<Text> tooltips, MutableText description) {
        String[] rows = description.getString().split("\\|");

        for (String row : rows) {
            tooltips.add(Text.literal(row).withColor(Colors.LIGHT_GREY.getRGB()));
        }
    }
}
