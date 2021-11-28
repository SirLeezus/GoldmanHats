package lee.code.goldmanhats.listeners;

import lee.code.goldmanhats.GoldmanHats;
import lee.code.goldmanhats.PU;
import lee.code.goldmanhats.lists.VillagerHats;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class VillagerDeathListener implements Listener {

    @EventHandler
    public void onVillagerDeath(EntityDeathEvent e) {
        GoldmanHats plugin = GoldmanHats.getPlugin();
        PU pu = plugin.getPU();
        Entity entity = e.getEntity();
        Location location = entity.getLocation();

        if (entity instanceof Villager villager) {
            if (pu.getVillagerRNG()) {
                String villagerType = villager.getVillagerType().name();
                String villagerProfession = villager.getProfession().name();

                if (pu.getVillagerHatsNames().contains(villagerType)) {
                    ItemStack hat = VillagerHats.valueOf(villagerType).getItem();
                    location.getWorld().dropItemNaturally(location, hat);
                }

                if (pu.getVillagerHatsNames().contains(villagerProfession)) {
                    ItemStack hat = VillagerHats.valueOf(villagerProfession).getItem();
                    location.getWorld().dropItemNaturally(location, hat);
                }
            }
        }
    }
}
