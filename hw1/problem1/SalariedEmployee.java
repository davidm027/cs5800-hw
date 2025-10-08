package problem1;

public class SalariedEmployee extends Employee {

    private int weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String ssn, int weeklySalary) {
        super(firstName, lastName, ssn);
        this.weeklySalary = weeklySalary;
    }

    public int getWeeklySalary() {
        return this.weeklySalary;
    }

    public void setWeeklySalary(int weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public String toString() {
        String basicInfo =
                this.getFirstName() + " " + this.getLastName() + " " + this.getSsn();
        return basicInfo + " -- " + "Weekly salary: $" + this.getWeeklySalary();
    }
}
