package lee.code.goldmanhats.lists;

import lee.code.goldmanhats.GoldmanHats;
import lee.code.goldmanhats.PU;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.kyori.adventure.text.Component;

@AllArgsConstructor
public enum Lang {
    PREFIX("&e&lHats &2➔ &r"),
    USAGE("&6&lUsage: &e{0}"),
    ERROR_NOT_CONSOLE_COMMAND("&cThis command does not work in console."),
    ;

    @Getter private final String string;

    public String getString(String[] variables) {
        GoldmanHats plugin = GoldmanHats.getPlugin();
        PU pu = plugin.getPU();
        String value = string;
        if (variables == null || variables.length == 0) return pu.format(value);
        for (int i = 0; i < variables.length; i++) value = value.replace("{" + i + "}", variables[i]);
        return pu.format(value);
    }

    public Component getComponent(String[] variables) {
        GoldmanHats plugin = GoldmanHats.getPlugin();
        PU pu = plugin.getPU();
        String value = string;
        if (variables == null || variables.length == 0) return pu.formatC(value);
        for (int i = 0; i < variables.length; i++) value = value.replace("{" + i + "}", variables[i]);
        return pu.formatC(value);
    }
}
