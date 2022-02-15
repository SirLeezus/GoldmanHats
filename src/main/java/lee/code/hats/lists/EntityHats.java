package lee.code.hats.lists;

import lee.code.hats.GoldmanHats;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public enum EntityHats {

    WITCH(2001, "&6Witch Hat"),
    SEA_CROWN(2002, "&6Sea Crown"),

    ;

    @Getter private final int id;
    @Getter private final String name;

    public ItemStack getItem() {
        GoldmanHats plugin = GoldmanHats.getPlugin();
        return plugin.getPU().getItem(Material.GUNPOWDER, name, null, id);
    }
}
