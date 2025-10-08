package problem3;

public class Main {
    public static void main(String[] args) {
        Ship[] ships = {new Ship("A", "1991"), new CruiseShip("B", "1992", 500), new CargoShip("C", "1993", 2000)};

        for (Ship s : ships) {
            System.out.println(s);
        }
    }
}
