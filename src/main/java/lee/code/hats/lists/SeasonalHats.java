package lee.code.hats.lists;

import lee.code.hats.GoldmanHats;
import lee.code.hats.PU;
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
        GoldmanHats plugin = GoldmanHats.getPlugin();
        PU pu = plugin.getPU();
        return plugin.getPU().getItem(Material.GUNPOWDER, name, lore.replace("{0}", String.valueOf(pu.getYear())), id);
    }
}
