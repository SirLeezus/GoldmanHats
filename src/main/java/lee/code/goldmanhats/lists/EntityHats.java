package lee.code.goldmanhats.lists;

import lee.code.goldmanhats.GoldmanHats;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public enum EntityHats {

    WITCH(2001, "&6Witch Hat"),

    ;

    @Getter private final int id;
    @Getter private final String name;

    public ItemStack getItem() {
        GoldmanHats plugin = GoldmanHats.getPlugin();
        return plugin.getPU().getItem(Material.STICK, name, null, id);
    }
}
