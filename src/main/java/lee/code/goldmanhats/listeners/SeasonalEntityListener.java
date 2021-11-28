package lee.code.goldmanhats.listeners;

import lee.code.goldmanhats.GoldmanHats;
import lee.code.goldmanhats.PU;
import lee.code.goldmanhats.lists.SeasonalHats;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class SeasonalEntityListener implements Listener {

    @EventHandler
    public void onSnowmanDeath(EntityDeathEvent e) {
        GoldmanHats plugin = GoldmanHats.getPlugin();
        PU pu = plugin.getPU();
        Entity entity = e.getEntity();

        if (entity instanceof Snowman snowman) {
            if (pu.isChristmasSeason() && pu.getSeasonalRNG()) {
                Location location  = snowman.getLocation();
                location.getWorld().dropItemNaturally(location, SeasonalHats.SANTA.getItem());
            }
        }
    }
}
