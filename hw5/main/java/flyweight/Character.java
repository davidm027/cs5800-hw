package flyweight;

public class Character {

    Property font;
    Property color;

    Property size;

    public Character(Property font, Property color, Property size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public Property getFont() {
        return this.font;
    }

    public Property getColor() {
        return this.color;
    }

    public Property getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "[" + this.getFont().toString() + this.getColor().toString() + this.getSize().toString() + "]";
    }
}
