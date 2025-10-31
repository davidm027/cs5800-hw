package flyweight;

import java.util.HashMap;

public class CharacterFactory {
    private HashMap<Integer, Property> propertyMap = new HashMap<>();

    public Property getProperty(int type) {
        if (this.getPropertyMap().containsKey(type)) {
            return this.getPropertyMap().get(type);
        }

        Property property = null;
        switch (type) {
            case 0:
                property = new Font();
                break;
            case 1:
                property = new Color();
                break;
            case 2:
                property = new Size();
                break;
            default:
                break;
        }

        this.getPropertyMap().put(type, property);
        return property;
    }

    public HashMap<Integer, Property> getPropertyMap() {
        return this.propertyMap;
    }
}
