package bridge;

import bridge.channels.PushChannel;
import bridge.paymentTypes.BitcoinPaymentNotification;
import bridge.paymentTypes.CashOnDeliveryPaymentNotification;
import bridge.paymentTypes.OnlinePaymentNotification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PushChannelNotificationTests {

    @Test
    void sendOnlinePaymentNotification() {
        PushChannel pushChannel = new PushChannel(new OnlinePaymentNotification(42.00));
        assertEquals("[PUSH] New Online Payment - $42.00", pushChannel.send());
        pushChannel.setNotification(new OnlinePaymentNotification(12.34));
        assertEquals("[PUSH] New Online Payment - $12.34", pushChannel.send());
    }

    @Test
    void sendCashOnDeliveryPaymentNotification() {
        PushChannel pushChannel = new PushChannel(new CashOnDeliveryPaymentNotification(42.00));
        assertEquals("[PUSH] New Cash-on-delivery Payment - $42.00", pushChannel.send());
        pushChannel.setNotification(new CashOnDeliveryPaymentNotification(12.34));
        assertEquals("[PUSH] New Cash-on-delivery Payment - $12.34", pushChannel.send());
    }

    @Test
    void sendBitcoinPaymentNotification() {
        PushChannel pushChannel = new PushChannel(new BitcoinPaymentNotification(42.00));
        assertEquals("[PUSH] New Bitcoin Payment - 42.00 BTC", pushChannel.send());
        pushChannel.setNotification(new BitcoinPaymentNotification(12.34));
        assertEquals("[PUSH] New Bitcoin Payment - 12.34 BTC", pushChannel.send());
    }

}