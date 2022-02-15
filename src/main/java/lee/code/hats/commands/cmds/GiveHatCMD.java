package lee.code.hats.commands.cmds;

import lee.code.hats.GoldmanHats;
import lee.code.hats.PU;
import lee.code.hats.lists.EntityHats;
import lee.code.hats.lists.Lang;
import lee.code.hats.lists.SeasonalHats;
import lee.code.hats.lists.VillagerHats;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GiveHatCMD implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        GoldmanHats plugin = GoldmanHats.getPlugin();
        PU pu = plugin.getPU();

        if (sender instanceof Player player) {
            if (args.length > 0) {
                String hatName = args[0].toUpperCase();
                if (pu.getAllHatNames().contains(hatName)) {
                    ItemStack hat = new ItemStack(Material.AIR);
                    if (pu.getEntityHatNames().contains(hatName)) hat = EntityHats.valueOf(hatName).getItem();
                    else if (pu.getVillagerHatNames().contains(hatName)) hat = VillagerHats.valueOf(hatName).getItem();
                    else if (pu.getSeasonalHatNames().contains(hatName)) hat = SeasonalHats.valueOf(hatName).getItem();
                    player.getInventory().addItem(hat);
                }
            } else sender.sendMessage(Lang.USAGE.getComponent(new String[] { command.getUsage() }));
        } else sender.sendMessage(Lang.PREFIX.getComponent(null).append(Lang.ERROR_NOT_CONSOLE_COMMAND.getComponent(null)));
        return true;
    }
}