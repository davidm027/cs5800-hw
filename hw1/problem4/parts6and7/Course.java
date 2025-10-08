package problem4.parts6and7;

public class Course {
    private String name;
    private Instructor[] instructors;
    private Textbook[] textbooks;

    public Course(String name, Instructor instructor1, Instructor instructor2,
                  Textbook textbook1, Textbook textbook2) {
        this.name = name;
        this.instructors = new Instructor[]{instructor1, instructor2};
        this.textbooks = new Textbook[]{textbook1, textbook2};
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor[] getInstructors() {
        return this.instructors;
    }

    public void setInstructors(Instructor[] instructor) {
        this.instructors = instructors;
    }

    public Textbook[] getTextbooks() {
        return this.textbooks;
    }

    public void setTextbooks(Textbook[] textbook) {
        this.textbooks = textbook;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course: " + this.getName() + " ");
        sb.append("\nInstructors: ");
        for (Instructor i : this.getInstructors()) {
            sb.append("\n- ");
            sb.append(i.getFirstName());
            sb.append(" " + i.getLastName());
        }
        sb.append("\nBooks: ");
        for (Textbook t : this.getTextbooks()) {
            sb.append("\n- ");
            sb.append(t.getTitle());
            sb.append(" by " + t.getAuthor());
        }
        sb.append("\n");
        return sb.toString();
    }
}
