package problem4.parts1to5;

public class Course {
    private String name;
    private Instructor instructor;
    private Textbook textbook;

    public Course(String name, Instructor instructor, Textbook textbook) {
        this.name = name;
        this.instructor = instructor;
        this.textbook = textbook;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getInstructor() {
        return this.instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Textbook getTextbook() {
        return this.textbook;
    }

    public void setTextbook(Textbook textbook) {
        this.textbook = textbook;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course: " + this.getName() + "\n");
        sb.append("Instructor: " + this.instructor.getFirstName() + " " + this.instructor.getLastName() + "\n");
        sb.append("Textbook: " + this.textbook.getTitle() + " by " + this.textbook.getAuthor());
        return sb.toString();
    }
}
