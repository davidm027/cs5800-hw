package problem2;

public class VendorInvoice implements Payable {
    private String vendorName;
    private String invoiceNumber;
    private double amountDue;

    public VendorInvoice(String vendorName, String invoiceNumber, double amountDue) {
        this.vendorName = vendorName;
        this.invoiceNumber = invoiceNumber;
        this.amountDue = amountDue;
    }

    @Override
    public double calculatePayment() {
        return this.getAmountDue();
    }

    @Override
    public String getPayeeName() {
        return this.getVendorName();
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vendor Name: " + this.getPayeeName() + "\n");
        sb.append("Invoice Number: " + this.getInvoiceNumber() + "\n");
        sb.append("Calculated Payment: " + this.calculatePayment() + "\n");
        return sb.toString();
    }

}
