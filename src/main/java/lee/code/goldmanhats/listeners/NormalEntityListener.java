package lee.code.goldmanhats.listeners;

import lee.code.goldmanhats.GoldmanHats;
import lee.code.goldmanhats.PU;
import lee.code.goldmanhats.lists.EntityHats;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Witch;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class NormalEntityListener implements Listener {

    @EventHandler
    public void onSnowmanDeath(EntityDeathEvent e) {
        GoldmanHats plugin = GoldmanHats.getPlugin();
        PU pu = plugin.getPU();
        Entity entity = e.getEntity();
        Location location = entity.getLocation();

        if (entity instanceof Witch) {
            if (pu.getWitchRNG()) {
                ItemStack hat = EntityHats.WITCH.getItem();
                location.getWorld().dropItemNaturally(location, hat);
            }
        }
    }
}
