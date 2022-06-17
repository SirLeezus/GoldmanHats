package lee.code.hats.lists;

import lee.code.core.util.bukkit.BukkitUtils;
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
        return BukkitUtils.getCustomItem(Material.GUNPOWDER, name, null, id, false);
    }
}
