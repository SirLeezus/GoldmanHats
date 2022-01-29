package lee.code.goldmanhats.listeners;

import lee.code.goldmanhats.GoldmanHats;
import lee.code.goldmanhats.PU;
import lee.code.goldmanhats.lists.EntityHats;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Witch;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class NormalEntityListener implements Listener {

    @EventHandler
    public void onEntityHatDrop(EntityDeathEvent e) {
        GoldmanHats plugin = GoldmanHats.getPlugin();
        PU pu = plugin.getPU();
        Entity entity = e.getEntity();
        Location location = entity.getLocation();

        boolean creative = false;
        if (e.getEntity().getKiller() != null) {
            Player killer = e.getEntity().getKiller();
            if (killer.getGameMode().equals(GameMode.CREATIVE)) creative = true;

            if (entity instanceof Witch) {
                if (pu.getWitchRNG() || creative) {
                    ItemStack hat = EntityHats.WITCH.getItem();
                    location.getWorld().dropItemNaturally(location, hat);
                }
            } else if (entity instanceof ElderGuardian) {
                if (pu.getSeaCrownRNG() || creative) {
                    ItemStack hat = EntityHats.SEA_CROWN.getItem();
                    location.getWorld().dropItemNaturally(location, hat);
                }
            }
        }
    }
}
