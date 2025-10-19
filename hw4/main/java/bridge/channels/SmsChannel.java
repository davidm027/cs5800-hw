package bridge.channels;

import bridge.paymentTypes.PaymentNotification;

public class SmsChannel extends Channel {
    public SmsChannel(PaymentNotification notification) {
        super(notification);
    }

    @Override
    public String send() {
        return "[SMS] New " + notification.getMessage();
    }
}
