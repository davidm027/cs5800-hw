package flyweight;

public class Font implements Property {

    String font;
    String type;

    public Font() {
        this.type = "FONT";
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getProperty() {
        return this.font;
    }

    @Override
    public void setProperty(String font) {
        this.font = font;
    }

    @Override
    public String toString() {
        return String.format("(%s:%s)", this.getType(), this.getProperty());
    }
    
}
