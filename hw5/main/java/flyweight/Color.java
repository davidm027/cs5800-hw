package flyweight;

public class Color implements Property {

    String color;
    String type;

    public Color() {
        this.type = "COLOR";
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getProperty() {
        return this.color;
    }

    @Override
    public void setProperty(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("(%s:%s)", this.getType(), this.getProperty());
    }

}
