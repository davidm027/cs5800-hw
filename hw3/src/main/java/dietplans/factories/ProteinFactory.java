package dietplans.factories;

import dietplans.DietPlan;
import dietplans.macronutrients.proteins.*;

import java.util.Objects;

public class ProteinFactory extends MacroFactory {

    private static ProteinFactory instance = null;

    public static MacroFactory getInstance() {
        if (instance == null) {
            instance = new ProteinFactory();
        }
        return instance;
    }

    public static Protein getProtein(DietPlan plan) {
        if (plan == DietPlan.VEGAN) {
            return new Tofu();
        }

        randomizeState();
        Protein randomProtein = mapProtein(state);
        if (isInvalidProtein(plan, randomProtein)) {
            while (isInvalidProtein(plan, randomProtein)) {
                randomizeState();
                randomProtein = mapProtein(state);
            }
        }
        return randomProtein;
    }

    private static boolean isInvalidProtein(DietPlan plan, Protein protein) {
        return plan == DietPlan.PALEO && Objects.equals(protein.toString(), "Tofu");
    }

    private static Protein mapProtein(int key) {
        return switch (key) {
            case 0 -> new Beef();
            case 1 -> new Chicken();
            case 2 -> new Fish();
            case 3 -> new Tofu();
            default -> throw new IllegalStateException("Unexpected value: " + key);
        };
    }
}
