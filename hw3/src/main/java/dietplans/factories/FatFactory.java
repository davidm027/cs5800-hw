package dietplans.factories;

import dietplans.DietPlan;
import dietplans.macronutrients.fats.*;
import dietplans.macronutrients.fats.*;

public class FatFactory extends MacroFactory {

    private static FatFactory instance = null;

    public static MacroFactory getInstance() {
        if (instance == null) {
            instance = new FatFactory();
        }
        return instance;
    }

    public static Fat getFat(DietPlan plan) {
        randomizeState();
        Fat randomFat = mapFat(state);
        if (isInvalidFat(plan, randomFat)) {
            while (isInvalidFat(plan, randomFat)) {
                randomizeState();
                randomFat = mapFat(state);
            }
        }
        return randomFat;
    }

    private static boolean isInvalidFat(DietPlan plan, Fat fat) {
        boolean cannotEatDairy = plan == DietPlan.VEGAN || plan == DietPlan.PALEO;
        boolean isNotDairyFree = cannotEatDairy && fat instanceof SourCream;
        boolean isNotVegan = plan == DietPlan.VEGAN && fat instanceof Tuna;
        boolean isNotNutFriendly = plan == DietPlan.NUT_ALLERGY && fat instanceof Peanuts;

        return isNotVegan || isNotDairyFree || isNotNutFriendly;
    }

    private static Fat mapFat(int key) {
        return switch (key) {
            case 0 -> new Avocado();
            case 1 -> new Peanuts();
            case 2 -> new SourCream();
            case 3 -> new Tuna();
            default -> throw new IllegalStateException("Unexpected value: " + key);
        };
    }
}
