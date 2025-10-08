package dietplans.factories;

import dietplans.DietPlan;
import dietplans.macronutrients.carbs.*;

public class CarbFactory extends MacroFactory {

    private static CarbFactory instance = null;

    public static MacroFactory getInstance() {
        if (instance == null) {
            instance = new CarbFactory();
        }
        return instance;
    }

    public static Carb getCarb(DietPlan plan) {
        if (plan == DietPlan.PALEO) {
            return new Pistachio();
        }

        randomizeState();
        Carb randomCarb = mapCarb(state);
        if (isInvalidCarb(plan, randomCarb)) {
            while (isInvalidCarb(plan, randomCarb)) {
                randomizeState();
                randomCarb = mapCarb(state);
            }
        }
        return randomCarb;
    }

    private static boolean isInvalidCarb(DietPlan plan, Carb carb) {
        boolean isNotNutFriendly = plan == DietPlan.NUT_ALLERGY && carb instanceof Pistachio;
        boolean isNotVegan = plan == DietPlan.VEGAN && carb instanceof Cheese;

        return isNotVegan || isNotNutFriendly;
    }

    private static Carb mapCarb(int key) {
        return switch (key) {
            case 0 -> new Bread();
            case 1 -> new Cheese();
            case 2 -> new Lentils();
            case 3 -> new Pistachio();
            default -> throw new IllegalStateException("Unexpected value: " + key);
        };
    }
}
