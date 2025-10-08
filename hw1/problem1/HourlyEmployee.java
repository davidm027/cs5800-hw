package problem1;

public class HourlyEmployee extends Employee {
    private int wage;
    private int hoursWorked;

    public HourlyEmployee(String firstName, String lastName, String ssn, int wage, int hoursWorked) {
        super(firstName, lastName, ssn);
        this.wage = wage;
        this.hoursWorked = hoursWorked;
    }

    public int getWage() {
        return this.wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getHoursWorked() {
        return this.hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String toString() {
        String basicInfo =
                this.getFirstName() + " " + this.getLastName() + " " + this.getSsn();
        return basicInfo + " -- " + "Hourly Wage: $" + this.getWage() + "; Hours " +
                "Worked: " + this.getHoursWorked();
    }
}
