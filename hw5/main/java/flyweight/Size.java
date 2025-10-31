package flyweight;

public class Size implements Property {

    String size;
    String type;

    public Size() {
        this.type = "SIZE";
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getProperty() {
        return this.size;
    }

    @Override
    public void setProperty(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("(%s:%s)", this.getType(), this.getProperty());
    }
    
}
