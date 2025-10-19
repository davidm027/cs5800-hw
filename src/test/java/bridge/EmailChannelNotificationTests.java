package bridge;

import bridge.channels.EmailChannel;
import bridge.paymentTypes.BitcoinPaymentNotification;
import bridge.paymentTypes.CashOnDeliveryPaymentNotification;
import bridge.paymentTypes.OnlinePaymentNotification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailChannelNotificationTests {

    @Test
    void sendOnlinePaymentNotification() {
        EmailChannel eChan = new EmailChannel(new OnlinePaymentNotification(42.00));
        assertEquals("[EMAIL] New Online Payment - $42.00", eChan.send());
        eChan.setNotification(new OnlinePaymentNotification(12.34));
        assertEquals("[EMAIL] New Online Payment - $12.34", eChan.send());
    }

    @Test
    void sendCashOnDeliveryPaymentNotification() {
        EmailChannel eChan = new EmailChannel(new CashOnDeliveryPaymentNotification(42.00));
        assertEquals("[EMAIL] New Cash-on-delivery Payment - $42.00", eChan.send());
        eChan.setNotification(new CashOnDeliveryPaymentNotification(12.34));
        assertEquals("[EMAIL] New Cash-on-delivery Payment - $12.34", eChan.send());
    }

    @Test
    void sendBitcoinPaymentNotification() {
        EmailChannel eChan = new EmailChannel(new BitcoinPaymentNotification(42.00));
        assertEquals("[EMAIL] New Bitcoin Payment - 42.00 BTC", eChan.send());
        eChan.setNotification(new BitcoinPaymentNotification(12.34));
        assertEquals("[EMAIL] New Bitcoin Payment - 12.34 BTC", eChan.send());
    }

}