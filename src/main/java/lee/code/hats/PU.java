package lee.code.hats;

import lee.code.hats.lists.EntityHats;
import lee.code.hats.lists.SeasonalHats;
import lee.code.hats.lists.VillagerHats;
import java.util.*;
import java.util.stream.Collectors;

public class PU {

    private final Random random = new Random();

    public List<String> getVillagerHatNames() {
        return EnumSet.allOf(VillagerHats.class).stream().map(VillagerHats::name).collect(Collectors.toList());
    }

    public List<String> getSeasonalHatNames() {
        return EnumSet.allOf(SeasonalHats.class).stream().map(SeasonalHats::name).collect(Collectors.toList());
    }

    public List<String> getEntityHatNames() {
        return EnumSet.allOf(EntityHats.class).stream().map(EntityHats::name).collect(Collectors.toList());
    }

    public List<String> getAllHatNames() {
        List<String> hats = new ArrayList<>();
        hats.addAll(getVillagerHatNames());
        hats.addAll(getSeasonalHatNames());
        hats.addAll(getEntityHatNames());
        return hats;
    }

    public int getYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public boolean isChristmasSeason() {
        Calendar min = new GregorianCalendar(getYear(), Calendar.NOVEMBER, 26);
        Calendar max = new GregorianCalendar(getYear(), Calendar.DECEMBER, 31);
        Calendar today = new GregorianCalendar();
        return today.after(min) && today.before(max);
    }

    //10%
    public boolean getWitchRNG() {
        int nextInt = random.nextInt(10);
        return nextInt == 0;
    }

    //10%
    public boolean getSeaCrownRNG() {
        int nextInt = random.nextInt(10);
        return nextInt == 0;
    }

    //10%
    public boolean getSeasonalRNG() {
        int nextInt = random.nextInt(10);
        return nextInt == 0;
    }

    //50%
    public boolean getVillagerRNG() {
        int nextInt = random.nextInt(2);
        return nextInt == 0;
    }
}
