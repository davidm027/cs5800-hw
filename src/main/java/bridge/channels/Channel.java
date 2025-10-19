package bridge.channels;

import bridge.paymentTypes.CashOnDeliveryPaymentNotification;
import bridge.paymentTypes.PaymentNotification;

public abstract class Channel {
    protected PaymentNotification notification;

    public Channel(PaymentNotification notification) {
        this.notification = notification;
    }

    public PaymentNotification getNotification() {
        return this.notification;
    }

    public void setNotification(PaymentNotification notification) {
        this.notification = notification;
    }

    abstract public String send();
}
