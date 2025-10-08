package problem1;

public class CommisionEmployee extends Employee {
    private double commissionRate;
    private int grossSales;

    public CommisionEmployee(String firstName, String lastName, String ssn, double commissionRate, int grossSales) {
        super(firstName, lastName, ssn);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return this.commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public int getGrossSales() {
        return this.grossSales;
    }

    public void setGrossSales(int grossSales) {
        this.grossSales = grossSales;
    }

    public String toString() {
        String commRateString = String.valueOf((int) (this.getCommissionRate() * 100));
        String basicInfo =
                this.getFirstName() + " " + this.getLastName() + " " + this.getSsn();
        return basicInfo + " -- " + "Commission Rate: " + commRateString + "%; Gross " +
                "Sales: " +
                "$" + this.getGrossSales();
    }
}
