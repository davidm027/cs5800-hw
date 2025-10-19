package bridge.paymentTypes;

import java.text.DecimalFormat;

public class BitcoinPaymentNotification extends PaymentNotification {

    public BitcoinPaymentNotification(double transactionAmt) {
        super(transactionAmt);
        this.format = new DecimalFormat("#.00 BTC");
    }

    @Override
    public String getMessage() {
        return "Bitcoin Payment - " + format.format(this.transactionAmt);
    }
}
