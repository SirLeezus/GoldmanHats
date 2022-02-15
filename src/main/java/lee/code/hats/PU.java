package lee.code.hats;

import lee.code.hats.lists.EntityHats;
import lee.code.hats.lists.SeasonalHats;
import lee.code.hats.lists.VillagerHats;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;
import java.util.stream.Collectors;

public class PU {

    private final Random random = new Random();

    public String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public Component formatC(String message) {
        LegacyComponentSerializer serializer = LegacyComponentSerializer.legacyAmpersand();
        return Component.empty().decoration(TextDecoration.ITALIC, false).append(serializer.deserialize(message));
    }

    public ItemStack getItem(Material type, String name, String lore, int id) {
        ItemStack item = new ItemStack(type);
        ItemMeta itemMeta = item.getItemMeta();
        if (id != 0) itemMeta.setCustomModelData(id);
        if (name != null) itemMeta.displayName(formatC(name));
        if (lore != null) {
            String[] split = StringUtils.split(lore, "\n");
            List<Component> lines = new ArrayList<>();
            for (String line : split) lines.add(formatC(line));
            itemMeta.lore(lines);
        }
        item.setItemMeta(itemMeta);
        return item;
    }

    public List<String> getVillagerHatNames() {
        return EnumSet.allOf(VillagerHats.class).stream().map(VillagerHats::name).collect(Collectors.toList());
    }

    public List<String> getSeasonalHatNames() {
        return EnumSet.allOf(SeasonalHats.class).stream().map(SeasonalHats::name).collect(Collectors.toList());
    }

    public List<String> getEntityHatNames() {
        return EnumSet.allOf(EntityHats.class).stream().map(EntityHats::name).collect(Collectors.toList());
    }

    public List<String> getAllHatNames() {
        List<String> hats = new ArrayList<>();
        hats.addAll(getVillagerHatNames());
        hats.addAll(getSeasonalHatNames());
        hats.addAll(getEntityHatNames());
        return hats;
    }

    public int getYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public boolean isChristmasSeason() {
        Calendar min = new GregorianCalendar(getYear(), Calendar.NOVEMBER, 26);
        Calendar max = new GregorianCalendar(getYear(), Calendar.DECEMBER, 31);
        Calendar today = new GregorianCalendar();
        return today.after(min) && today.before(max);
    }

    //10%
    public boolean getWitchRNG() {
        int nextInt = random.nextInt(10);
        return nextInt == 0;
    }

    //10%
    public boolean getSeaCrownRNG() {
        int nextInt = random.nextInt(10);
        return nextInt == 0;
    }

    //10%
    public boolean getSeasonalRNG() {
        int nextInt = random.nextInt(10);
        return nextInt == 0;
    }

    //50%
    public boolean getVillagerRNG() {
        int nextInt = random.nextInt(5);
        return nextInt == 0;
    }
}
