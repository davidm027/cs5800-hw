package dietplans;

public class Driver {
    public static void main(String[] args) {
        Customer alice = new Customer("Alice", DietPlan.NO_RESTRICTION);
        Customer bob = new Customer("Bob", DietPlan.PALEO);
        Customer casey = new Customer("Casey", DietPlan.PALEO);
        Customer diana = new Customer("Diana", DietPlan.VEGAN);
        Customer eric = new Customer("Eric", DietPlan.VEGAN);
        Customer freddie = new Customer("Freddie", DietPlan.NUT_ALLERGY);

        System.out.println(alice);
        System.out.println(bob);
        System.out.println(casey);
        System.out.println(diana);
        System.out.println(eric);
        System.out.println(freddie);

    }
}
