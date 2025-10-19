package bridge;

import bridge.channels.SmsChannel;
import bridge.paymentTypes.BitcoinPaymentNotification;
import bridge.paymentTypes.CashOnDeliveryPaymentNotification;
import bridge.paymentTypes.OnlinePaymentNotification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmsChannelNotificationTests {

    @Test
    void sendOnlinePaymentNotification() {
        SmsChannel smsChannel = new SmsChannel(new OnlinePaymentNotification(42.00));
        assertEquals("[SMS] New Online Payment - $42.00", smsChannel.send());
        smsChannel.setNotification(new OnlinePaymentNotification(12.34));
        assertEquals("[SMS] New Online Payment - $12.34", smsChannel.send());
    }

    @Test
    void sendCashOnDeliveryPaymentNotification() {
        SmsChannel smsChannel = new SmsChannel(new CashOnDeliveryPaymentNotification(42.00));
        assertEquals("[SMS] New Cash-on-delivery Payment - $42.00", smsChannel.send());
        smsChannel.setNotification(new CashOnDeliveryPaymentNotification(12.34));
        assertEquals("[SMS] New Cash-on-delivery Payment - $12.34", smsChannel.send());
    }

    @Test
    void sendBitcoinPaymentNotification() {
        SmsChannel smsChannel = new SmsChannel(new BitcoinPaymentNotification(42.00));
        assertEquals("[SMS] New Bitcoin Payment - 42.00 BTC", smsChannel.send());
        smsChannel.setNotification(new BitcoinPaymentNotification(12.34));
        assertEquals("[SMS] New Bitcoin Payment - 12.34 BTC", smsChannel.send());
    }

}