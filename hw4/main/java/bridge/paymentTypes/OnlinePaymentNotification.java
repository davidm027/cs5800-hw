package bridge.paymentTypes;

public class OnlinePaymentNotification extends PaymentNotification {

    public OnlinePaymentNotification(double transactionAmt) {
        super(transactionAmt);
    }

    @Override
    public String getMessage() {
        return "Online Payment - " + format.format(this.transactionAmt);
    }
}
