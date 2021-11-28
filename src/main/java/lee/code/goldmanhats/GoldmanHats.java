package lee.code.goldmanhats;

import lee.code.goldmanhats.listeners.NormalEntityListener;
import lee.code.goldmanhats.listeners.SeasonalEntityListener;
import lee.code.goldmanhats.listeners.VillagerDeathListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class GoldmanHats extends JavaPlugin {

    @Getter private PU pU;

    @Override
    public void onEnable() {
        this.pU = new PU();

        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static GoldmanHats getPlugin() {
        return GoldmanHats.getPlugin(GoldmanHats.class);
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new VillagerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new SeasonalEntityListener(), this);
        getServer().getPluginManager().registerEvents(new NormalEntityListener(), this);
    }
}
