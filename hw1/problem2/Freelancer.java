package problem2;

public class Freelancer implements Payable {
    private String firstName;
    private String lastName;
    private double hourlyRate;
    private double hoursWorked;

    public Freelancer(String firstName, String lastName, double hourlyRate, double hoursWorked) throws Exception {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate must be positive.");
        }
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked must be positive.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePayment() {
        double overtime = 0.0;

        if (this.getHoursWorked() > 40) {
            double otHours = this.getHoursWorked() - 40;
            overtime = otHours * this.getHourlyRate() * 1.5;
        }

        return this.getHourlyRate() * this.getHoursWorked() + overtime;
    }

    @Override
    public String getPayeeName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + this.getPayeeName() + "\n");
        sb.append("Calculated Payment: " + this.calculatePayment() + "\n");
        return sb.toString();
    }
}
