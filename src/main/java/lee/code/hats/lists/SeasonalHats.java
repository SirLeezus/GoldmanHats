package lee.code.hats.lists;

import lee.code.core.util.bukkit.BukkitUtils;
import lee.code.hats.GoldmanHats;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public enum SeasonalHats {

    SANTA(2000, "&6Santa Hat", "&c{0} Christmas"),

    ;

    @Getter private final int id;
    @Getter private final String name;
    @Getter private final String lore;

    public ItemStack getItem() {
        return BukkitUtils.getCustomItem(Material.GUNPOWDER, name, lore.replace("{0}", String.valueOf(GoldmanHats.getPlugin().getPU().getYear())), id, false);
    }
}
