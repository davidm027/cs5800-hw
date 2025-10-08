package dietplans;

import dietplans.factories.CarbFactory;
import dietplans.factories.FatFactory;
import dietplans.factories.ProteinFactory;
import dietplans.macronutrients.carbs.Carb;
import dietplans.macronutrients.fats.Fat;
import dietplans.macronutrients.proteins.Protein;

public class Customer {

    private class Meal {
        private Carb carb;
        private Protein protein;
        private Fat fat;

        Meal(Carb carb, Protein protein, Fat fat) {
            this.carb = carb;
            this.protein = protein;
            this.fat = fat;
        }

        public String toString() {
            return "carb: " + this.carb + ", protein: " + this.protein + ", fat: " + this.fat;
        }
    }

    private String name;
    private DietPlan plan;
    private Meal meal;

    public Customer(String name, DietPlan plan) {
        this.name = name;
        this.plan = plan;
        this.meal = this.makeMeal();
    }

    public String getName() {
        return this.name;
    }

    public DietPlan getPlan() {
        return this.plan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlan(DietPlan plan) {
        this.plan = plan;
    }

    public Meal getMeal() {
        return this.meal;
    }

    public Meal makeMeal() {
        return new Meal(this.getCarb(), this.getProtein(), this.getFat());
    }

    private Carb getCarb() {
        return CarbFactory.getCarb(this.plan);
    }

    private Protein getProtein() {
        return ProteinFactory.getProtein(this.plan);
    }

    private Fat getFat() {
        return FatFactory.getFat(this.plan);
    }

    public String toString() {
        return this.getName() + " - " + this.getMeal().toString();
    }

}
