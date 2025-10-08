package problem4.parts1to5;

public class Main {

    public static void main(String[] args) {
        Textbook textbook = new Textbook("Clean Code", "Uncle Bob", "Prentice Hall");
        Instructor instructor = new Instructor("Nima", "Davarpanah", "3-2636");
        Course course = new Course("CS5800", instructor, textbook);

        System.out.println(course);
    }

}
