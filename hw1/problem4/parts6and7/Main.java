package problem4.parts6and7;

public class Main {

    public static void main(String[] args) {
        Textbook textbook1 = new Textbook("Clean Code", "Uncle Bob", "Prentice Hall");
        Instructor instructor1 = new Instructor("Nima", "Davarpanah", "3-2636");

        Textbook textbook2 = new Textbook("Hands-On Machine Learning", "Aurelien Geron", "O'Reilly");
        Instructor instructor2 = new Instructor("Joe", "Jones", "1-1111");

        Course course = new Course("CS4210", instructor1, instructor2,
                textbook1, textbook2);

        System.out.println(course);
    }

}
