package bridge.channels;

import bridge.paymentTypes.PaymentNotification;

public class EmailChannel extends Channel {
    public EmailChannel(PaymentNotification notification) {
        super(notification);
    }

    @Override
    public String send() {
        return "[EMAIL] New " + notification.getMessage();
    }
}
