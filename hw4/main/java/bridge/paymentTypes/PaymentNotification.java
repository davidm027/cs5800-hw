package bridge.paymentTypes;

import java.text.DecimalFormat;

public abstract class PaymentNotification {
    protected double transactionAmt;
    protected DecimalFormat format;

    public PaymentNotification(double transactionAmt) {
        this.transactionAmt = transactionAmt;
        this.format = new DecimalFormat("$#.00");
    }

    public abstract String getMessage();
}
