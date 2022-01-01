package lee.code.goldmanhats.listeners;

import lee.code.goldmanhats.GoldmanHats;
import lee.code.goldmanhats.PU;
import lee.code.goldmanhats.lists.VillagerHats;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
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
            boolean creative = false;
            if (e.getEntity().getKiller() != null) {
                Player killer = e.getEntity().getKiller();
                if (killer.getGameMode().equals(GameMode.CREATIVE)) creative = true;
                if (pu.getVillagerRNG() || creative) {
                    String villagerType = villager.getVillagerType().name();
                    String villagerProfession = villager.getProfession().name();

                    if (pu.getVillagerHatNames().contains(villagerType)) {
                        ItemStack hat = VillagerHats.valueOf(villagerType).getItem();
                        location.getWorld().dropItemNaturally(location, hat);
                    }

                    if (pu.getVillagerHatNames().contains(villagerProfession)) {
                        ItemStack hat = VillagerHats.valueOf(villagerProfession).getItem();
                        location.getWorld().dropItemNaturally(location, hat);
                    }
                }
            }
        }
    }
}
