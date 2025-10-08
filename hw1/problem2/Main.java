package problem2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Payable> payments = new ArrayList<>();

        Payable jjones = new Freelancer("Joe", "Jones", 25, 32);
        Payable ssmith = new Freelancer("Stephanie", "Smith", 19, 47);
        Payable vendorA = new VendorInvoice("A", "11111111", 5000);
        Payable vendorB = new VendorInvoice("B", "11111112", 48000);

        payments.add(jjones);
        payments.add(ssmith);
        payments.add(vendorA);
        payments.add(vendorB);

        double totalPayout = 0;
        for (Payable p : payments) {
            System.out.println(p);
            totalPayout += p.calculatePayment();
        }
        System.out.println("Total payout: " + totalPayout);
    }
}
