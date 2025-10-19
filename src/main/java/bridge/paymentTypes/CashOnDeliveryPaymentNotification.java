package bridge.paymentTypes;

public class CashOnDeliveryPaymentNotification extends PaymentNotification {

    public CashOnDeliveryPaymentNotification(double transactionAmt) {
        super(transactionAmt);
    }

    @Override
    public String getMessage() {
        return "Cash-on-delivery Payment - " + format.format(this.transactionAmt);
    }
}
