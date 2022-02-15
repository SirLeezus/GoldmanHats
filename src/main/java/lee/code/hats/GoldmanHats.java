package lee.code.hats;

import lee.code.hats.commands.cmds.GiveHatCMD;
import lee.code.hats.commands.tabs.GiveHatTab;
import lee.code.hats.listeners.NormalEntityListener;
import lee.code.hats.listeners.SeasonalEntityListener;
import lee.code.hats.listeners.VillagerDeathListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class GoldmanHats extends JavaPlugin {

    @Getter private PU pU;

    @Override
    public void onEnable() {
        this.pU = new PU();

        registerListeners();
        registerCommands();
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

    private void registerCommands() {
        getCommand("givehat").setExecutor(new GiveHatCMD());
        getCommand("givehat").setTabCompleter(new GiveHatTab());
    }
}
