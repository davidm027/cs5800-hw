package bridge;

import bridge.channels.EmailChannel;
import bridge.channels.PushChannel;
import bridge.channels.SmsChannel;
import bridge.paymentTypes.BitcoinPaymentNotification;
import bridge.paymentTypes.CashOnDeliveryPaymentNotification;
import bridge.paymentTypes.OnlinePaymentNotification;

public class Main {
    public static void main(String[] args) {

        // Part 1
        System.out.println("-- PART 1 --");
        EmailChannel eChanOnlinePayment = new EmailChannel(new OnlinePaymentNotification(42.00));
        EmailChannel eChanCashOnDeliveryPayment =
                new EmailChannel(new CashOnDeliveryPaymentNotification(12.34));
        System.out.println(eChanOnlinePayment.send());
        System.out.println(eChanCashOnDeliveryPayment.send());

        SmsChannel smsChanOnlinePayment = new SmsChannel(new OnlinePaymentNotification(42.00));
        SmsChannel smsChanCashOnDeliveryPayment =
                new SmsChannel(new CashOnDeliveryPaymentNotification(12.34));
        System.out.println(smsChanOnlinePayment.send());
        System.out.println(smsChanCashOnDeliveryPayment.send());
        System.out.println();

        // Part 2
        System.out.println("-- PART 2 --");
        EmailChannel eChanBitcoinPayment = new EmailChannel(new BitcoinPaymentNotification(23.34));
        SmsChannel smsChanBitcoinPayment = new SmsChannel(new BitcoinPaymentNotification(23.34));
        System.out.println(eChanBitcoinPayment.send());
        System.out.println(smsChanBitcoinPayment.send());
        System.out.println();

        // Part 3
        System.out.println("-- PART 3 --");
        PushChannel pushChanOnlinePayment = new PushChannel(new OnlinePaymentNotification(42.00));
        PushChannel pushChanCashOnDeliveryPayment =
                new PushChannel(new CashOnDeliveryPaymentNotification(12.34));
        PushChannel pushChanBitcoinPayment = new PushChannel(new BitcoinPaymentNotification(23.34));
        System.out.println(pushChanOnlinePayment.send());
        System.out.println(pushChanCashOnDeliveryPayment.send());
        System.out.println(pushChanBitcoinPayment.send());
    }
}
