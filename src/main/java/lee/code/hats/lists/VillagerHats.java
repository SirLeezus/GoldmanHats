package lee.code.hats.lists;

import lee.code.hats.GoldmanHats;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public enum VillagerHats {

    FARMER(1000, "&6Farmer Villager Hat"),
    ARMORER(1001, "&6Armorer Villager Goggles"),
    DESERT(1002, "&6Desert Villager Hat"),
    FISHERMAN(1003, "&6Fisherman Villager Hat"),
    FLETCHER(1004, "&6Fletcher Villager Hat"),
    LIBRARIAN(1005, "&6Librarian Villager Hat"),
    SAVANNA(1006, "&6Savanna Villager Headband"),
    SHEPHERD(1007, "&6Shepherd Villager Hat"),
    SNOW(1008, "&6Snow Villager Hat"),
    SWAMP(1009, "&6Swamp Villager Hat"),
    BUTCHER(1010, "&6Butcher Villager Headband"),

    ;

    @Getter private final int id;
    @Getter private final String name;

    public ItemStack getItem() {
        GoldmanHats plugin = GoldmanHats.getPlugin();
        return plugin.getPU().getItem(Material.GUNPOWDER, name, null, id);
    }
}
