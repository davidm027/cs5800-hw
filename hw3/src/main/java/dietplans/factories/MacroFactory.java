package dietplans.factories;

import java.util.Random;

public abstract class MacroFactory {
    private static final Random random = new Random(42);
    protected static int state = 0;

    static MacroFactory getInstance() {
        return null;
    }

    protected static void randomizeState() {
        state = random.nextInt(4);
    }
}
