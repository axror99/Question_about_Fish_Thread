package jk.uz.pdp;

import java.util.ArrayList;
import java.util.List;

public class FishService {
    static List<Fish> fishList = new ArrayList<>();

    public static void birthFish(String parents) {
        System.out.println("\n =======================================================================");
        int maleFishNumber = RandomUtils.getFishNumber();
        int femaleFishNumber = RandomUtils.getFishNumber();

        for (int i = 0; i < maleFishNumber + femaleFishNumber; i++) {
            if (i < maleFishNumber) {
                Fish fish = Fish.buildFish(Gender.MALE, parents);
                fishList.add(fish);
            } else {
                Fish fish = Fish.buildFish(Gender.FEMALE, parents);
                fishList.add(fish);
            }
        }
    }


    public static synchronized Fish fishDating(Fish currentFish) {

        int dateNumber = currentFish.getDateNumber();
        Gender gender = currentFish.getGender();

        Fish pairFish = fishList.stream().filter((fish) -> {
            if (fish.getAge() >= 18 && fish.getAge() <= 30 && !fish.isMarried()) {
                if (!fish.getGender().equals(gender) && fish.getDateNumber() == dateNumber) {
                    fish.setMarried(true);
                    currentFish.setMarried(true);
                    return true;
                }
            }
            return false;
        }).findFirst().orElse(null);

        if (pairFish != null) {
            System.out.println("\n =======================================================================");
            birthFish(currentFish.getFishId() + " va " + pairFish.getFishId() + " baliqlar ");
        }
        return pairFish;
    }
}
