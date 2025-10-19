package bridge.channels;

import bridge.paymentTypes.PaymentNotification;

public class PushChannel extends Channel {
    public PushChannel(PaymentNotification notification) {
        super(notification);
    }

    @Override
    public String send() {
        return "[PUSH] New " + notification.getMessage();
    }
}
